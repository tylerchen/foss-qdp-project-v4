package org.iff.groovy.view.openreport

class TCBeanUtil {
    @groovy.transform.CompileStatic
    public static Object get(String beanName) {
        return org.iff.infra.util.groovy2.TCGroovyLoader.getDefaultGroovyLoader().getBean(beanName)
    }

    @groovy.transform.CompileStatic
    public static Object getSpringBean(String beanName) {
        return org.iff.infra.util.spring.SpringContextHelper.getBean(beanName)
    }
}

@TCBean(name = 'TC_OR_freemarker')
class ORFreemarker {
    private config

    def String process(templateSource, paramMap) {
        def writer = new java.io.StringWriter()
        getConfig().getTemplate(templateSource, 'UTF-8').process(paramMap, writer)
        return writer.toString()
    }

    def private getConfig() {
        if (config == null) {
            config = new org.iff.infra.util.freemarker.FreeMarkerConfiguration()
            config.setDirectivePath('org.iff.infra.util.freemarker.model')
            def templateLoader = [
                    findTemplateSource : { String name ->
                        name
                    },
                    getLastModified    : { Object templateSource ->
                        Long.valueOf(0)
                    },
                    getReader          : { Object templateSource, String encoding ->
                        new java.io.StringReader((String) templateSource)
                    },
                    closeTemplateSource: { Object templateSource ->
                    }
            ] as freemarker.cache.TemplateLoader
            config.setTemplateLoader(templateLoader)
            def builder = new freemarker.template.DefaultObjectWrapperBuilder(freemarker.template.Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS)
            builder.setUseAdaptersForContainers(true)
            config.setObjectWrapper(builder.build())
        }
        return config
    }
}

@TCBean(name = 'TC_OR_page')
class ORpage {
    def String gen(actionTemplateSource, paramMap) {
        return TCBeanUtil.get('TC_OR_freemarker').process(actionTemplateSource, paramMap)
    }
}

@TCBean(name = 'TC_OR_conditions')
class ORconditions {
    def String gen(actionTemplateSource, paramMap) {
        return TCBeanUtil.get('TC_OR_freemarker').process(actionTemplateSource, paramMap)
    }
}

@TCBean(name = 'TC_OR_actions')
class ORactions {
    def String gen(actionTemplateSource, paramMap) {
        return TCBeanUtil.get('TC_OR_freemarker').process(actionTemplateSource, paramMap)
    }
}

@TCBean(name = 'TC_OR_data')
class ORdata {
    def String gen(actionTemplateSource, paramMap) {
        return TCBeanUtil.get('TC_OR_freemarker').process(actionTemplateSource, paramMap)
    }
}

@TCBean(name = 'TC_OR_pagination')
class ORpagination {
    def String gen(actionTemplateSource, paramMap) {
        return TCBeanUtil.get('TC_OR_freemarker').process(actionTemplateSource, paramMap)
    }
}

@TCBean(name = 'TC_OR_SQL_jdbcConnection')
class ORSQLjdbcConnection {
    def connection(openreportConfig, reportConfig) {
        new groovy.sql.Sql(TCBeanUtil.getSpringBean(reportConfig.datasource ?: 'openReportDataSource'))
        /* TODO Only support spring datasource!!! */
    }
}

@TCBean(name = 'TC_OR_SQL_pageQuery')
class ORSQLpageQuery {
    def query(openreportConfig, reportConfig, conditionParams, jdbcConnection) {
        def query = TCBeanUtil.get('TC_OR_SQL_fillCondition').query(openreportConfig, reportConfig, reportConfig.query.nodeContent, conditionParams)
        def sql = query.sql, queryConditions = query.conditions
        def pageSize = reportConfig.'page-size'?.trim() ?: '0', totalCount = 0, currentPage = (conditionParams.p ?: '1').toInteger() - 1, result
        pageSize = (pageSize.isNumber() ? pageSize.toInteger() : 0) as int
        currentPage = currentPage > 0 ? currentPage : 0
        def columnNames = []
        def sqlMetaClosure = { metaData -> columnNames.addAll(metaData*.columnLabel) }
        if (pageSize > 0) {
            def countSql = 'select count(1) from (' + sql + ') tmp_count'
            if (queryConditions.size() > 0) {
                jdbcConnection.eachRow(countSql, queryConditions) { totalCount = it[0] }
            } else {
                jdbcConnection.eachRow(countSql) { totalCount = it[0] }
            }
            /* guest the jdbc url */
            def url = ''
            try {
                url = url ?: jdbcConnection.dataSource.url
            } catch (err) {
            }
            try {
                url = url ?: jdbcConnection.dataSource.jdbcUrl
            } catch (err) {
            }
            def dialect = org.iff.infra.util.jdbc.dialet.Dialect.getInstanceByUrl(url)
/* TODO Only support C3PO, apache, dubbo datasource!!! */
            def limitSql = dialect.getLimitString(sql, currentPage * pageSize, pageSize)
            result = queryConditions.size() > 0 ? jdbcConnection.rows(limitSql, queryConditions, sqlMetaClosure) : jdbcConnection.rows(limitSql, sqlMetaClosure)
        } else {
            result = queryConditions.size() > 0 ? jdbcConnection.rows(sql, queryConditions, sqlMetaClosure) : jdbcConnection.rows(sql, sqlMetaClosure)
            totalCount = pageSize = result.size()
        }
        ['result': (result ?: []), 'pageSize': pageSize, 'totalCount': totalCount, 'currentPage': currentPage, 'columnNames': columnNames]
    }
}

@TCBean(name = 'TC_OR_SQL_queryAll')
class ORSQLqueryAll {
    def query(openreportConfig, reportConfig, conditionParams, jdbcConnection) {
        def query = TCBeanUtil.get('TC_OR_SQL_fillCondition').query(openreportConfig, reportConfig, reportConfig.query.nodeContent, conditionParams)
        def sql = query.sql, queryConditions = query.conditions
        def columnNames = []
        def sqlMetaClosure = { metaData -> columnNames.addAll(metaData*.columnLabel) }
        def result = queryConditions.size() > 0 ? jdbcConnection.rows(sql, queryConditions, sqlMetaClosure) : jdbcConnection.rows(sql, sqlMetaClosure)
        ['result': (result ?: []), 'pageSize': result.size(), 'totalCount': result.size(), 'currentPage': 1, 'columnNames': columnNames]
    }
}

@TCBean(name = 'TC_OR_SQL_fillCondition')
class ORSQLfillCondition {
    def query(openreportConfig, reportConfig, sql, conditionParams) {
        /* replace or remove the condition block (#[condition]) */
        def index = 0, conditions = [:], conditionParamsConverted = TCBeanUtil.get('TC_OR_SQL_conditions').process(openreportConfig, reportConfig, conditionParams)
        while ((index = sql.indexOf('#[')) > 0) {
            def tmp = sql.substring(index + 2, sql.indexOf(']', index))
            def name = tmp.substring(tmp.indexOf(':') + 1).trim()
            def hasParam = conditionParamsConverted[name] != null && conditionParamsConverted[name] != ''
            sql = sql.substring(0, index) + (hasParam ? tmp : '') + sql.substring(sql.indexOf(']', index) + 1)
            if (hasParam) {
                conditions.put(name, conditionParamsConverted[name])
            }
        }
        ['sql': sql.trim(), 'conditions': conditions]
    }
}

@TCBean(name = 'TC_OR_SQL_conditions')
class ORSQLconditions {
    def process(openreportConfig, reportConfig, conditionParams) {
        /* process the url param to the conditions by type */
        def conditions = [:]
        reportConfig.conditions.each { key, condition ->
            def type = condition.'return-type', name = condition.name, value = conditionParams[condition.name]
            conditions.put(name, TCBeanUtil.get('TC_OR_returnType').returnType(openreportConfig, reportConfig, condition, value))
        }
        conditions
    }
}

@TCBean(name = 'TC_OR_returnType')
class ORSQLreturnType {
    def returnType(openreportConfig, reportConfig, conditionConfig, value) {
        /* process the url param to the specify type */
        def returnType = org.iff.infra.util.openreport.ReturnType.Factory.me().get(conditionConfig.'return-type')
        returnType.returnType(value, returnType.returnType(conditionConfig.defVal, null))
    }
}

@TCBean(name = 'TC_OR_OP_query')
class OROPquery {
    def process(paramsMap) {
        def openreportConfig = paramsMap.openreportConfig, reportConfig = paramsMap.reportConfig, conditionParams = paramsMap.conditionParams
        def pageTemplate = reportConfig.page.'page-template' ?: 'page_template', dataTemplate = reportConfig.page.'data-template' ?: 'data_template'
        def actionTemplate = reportConfig.page.'action-template' ?: 'action_template', conditionTemplate = reportConfig.page.'condition-template' ?: 'condition_template'
        def paginationTemplate = reportConfig.page.'pagination-template' ?: 'pagination_template'
        def isCrossTable = reportConfig.crosstable ? true : false
        def actionContent = TCBeanUtil.get('TC_OR_actions').gen(openreportConfig.globals.templates."template@${actionTemplate}".'nodeContent', paramsMap)
        def conditionContent = TCBeanUtil.get('TC_OR_conditions').gen(openreportConfig.globals.templates."template@${conditionTemplate}".'nodeContent', paramsMap)
        def dataContent, paginationContent
        if (isCrossTable) {
            def jdbcConnection = TCBeanUtil.get('TC_OR_SQL_jdbcConnection').connection(openreportConfig, reportConfig)
            def queryResult = TCBeanUtil.get('TC_OR_SQL_queryAll').query(openreportConfig, reportConfig, conditionParams, jdbcConnection)
            dataContent = new org.iff.infra.util.openreport.CrossTable().generate(openreportConfig, reportConfig, conditionParams, queryResult)
        } else {
            def jdbcConnection = TCBeanUtil.get('TC_OR_SQL_jdbcConnection').connection(openreportConfig, reportConfig)
            def queryResult = TCBeanUtil.get('TC_OR_SQL_pageQuery').query(openreportConfig, reportConfig, conditionParams, jdbcConnection)
            paramsMap.'queryResult' = queryResult
            dataContent = TCBeanUtil.get('TC_OR_data').gen(openreportConfig.globals.templates."template@${dataTemplate}".'nodeContent', paramsMap)
            paginationContent = TCBeanUtil.get('TC_OR_pagination').gen(openreportConfig.globals.templates."template@${paginationTemplate}".'nodeContent', paramsMap)
        }
        paramsMap.'actionContent' = actionContent
        paramsMap.'conditionContent' = conditionContent
        paramsMap.'dataContent' = dataContent
        paramsMap.'paginationContent' = paginationContent
        def pageContent = TCBeanUtil.get('TC_OR_page').gen(openreportConfig.globals.templates."template@${pageTemplate}".'nodeContent', paramsMap)
        pageContent
    }
}

@TCBean(name = 'TC_OR_OP_excel')
class OROPexcel {
    def process(paramsMap) {
        def openreportConfig = paramsMap.openreportConfig, reportConfig = paramsMap.reportConfig, conditionParams = paramsMap.conditionParams
        def jdbcConnection = TCBeanUtil.get('TC_OR_SQL_jdbcConnection').connection(openreportConfig, reportConfig)
        def queryResult = TCBeanUtil.get('TC_OR_SQL_queryAll').query(openreportConfig, reportConfig, conditionParams, jdbcConnection)

        def workbook = new ExcelBuilder().workbook {
            styles {
                font("bold") { font ->
                    font.setBoldweight(font.BOLDWEIGHT_BOLD)
                }
                cellStyle("header") { cellStyle ->
                    cellStyle.setAlignment(cellStyle.ALIGN_CENTER)
                }
            }
            data {
                sheet(reportConfig.'display-name' ?: reportConfig.'name') {
                    header(queryResult.columnNames)
                    queryResult.result.each { rowData ->
                        def data = []
                        rowData.each { k, v -> data << v }
                        row(data)
                    }
                }
            }
            commands {
                /*applyCellStyle(cellStyle: "header", font: "bold", rows: 1, columns: 1..3, sheetName:'Export2')*/
                /*mergeCells(rows: 1, columns: 1..3)*/
            }
        }
        def baos = new ByteArrayOutputStream(1024 * 1024)
        workbook.write(baos)
        ['fileName': "${reportConfig.'display-name' ?: reportConfig.'name'}.xls".toString(), 'data': baos.toByteArray()]
    }
}

@TCAction(name = "/openreport")
class OpenReportAction {
    def index(paramsMap) {
        def op = paramsMap.conditionParams.op ?: 'query'
        return TCBeanUtil.get("TC_OR_OP_${op}").process(paramsMap)
    }
}

