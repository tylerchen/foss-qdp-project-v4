set character set utf8;
SET foreign_key_checks = 0;

DROP TABLE IF EXISTS `AUTH_ACCOUNT`;
CREATE TABLE `AUTH_ACCOUNT` (
    `ID` VARCHAR(40) NOT NULL  COMMENT '主键', 
    `LOGIN_EMAIL` VARCHAR(80) NOT NULL   COMMENT '登录EMail', 
    `LOGIN_PASSWD` VARCHAR(100) NOT NULL   COMMENT '用户密码', 
    `STATUS` VARCHAR(1) NOT NULL   COMMENT '状态', 
    `TYPE` VARCHAR(50) NOT NULL   COMMENT '类型', 
    `USER_ID` VARCHAR(40)    COMMENT '用户', 
    `DESCRIPTION` VARCHAR(200)    COMMENT '描述', 
    `UPDATE_TIME` DATETIME NOT NULL  DEFAULT '1970-01-01 00:00:00' COMMENT '修改时间', 
    `CREATE_TIME` DATETIME NOT NULL  DEFAULT '1970-01-01 00:00:00' COMMENT '创建时间', 
    PRIMARY KEY (`ID`), 
    UNIQUE KEY (`LOGIN_EMAIL`), 
    FOREIGN KEY (`USER_ID`) REFERENCES `AUTH_USER` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='帐户管理';


DROP TABLE IF EXISTS `AUTH_ORGANIZATION`;
CREATE TABLE `AUTH_ORGANIZATION` (
    `ID` VARCHAR(40) NOT NULL  COMMENT '主键', 
    `NAME` VARCHAR(100) NOT NULL   COMMENT '组织机构名称', 
    `PARENT_ID` VARCHAR(40)    COMMENT '上级机构', 
    `ROOT_ID` VARCHAR(40)    COMMENT '根机构', 
    `CODE` VARCHAR(40) NOT NULL   COMMENT '组织机构编码', 
    `IS_USE_ROOT_MENU` VARCHAR(1) NOT NULL   COMMENT '使用根菜单', 
    `TYPE1` VARCHAR(40) NOT NULL   COMMENT '一级分类', 
    `TYPE2` VARCHAR(40) NOT NULL   COMMENT '二级分类', 
    `DESCRIPTION` VARCHAR(200)    COMMENT '描述', 
    `UPDATE_TIME` DATETIME NOT NULL  DEFAULT '1970-01-01 00:00:00' COMMENT '修改时间', 
    `CREATE_TIME` DATETIME NOT NULL  DEFAULT '1970-01-01 00:00:00' COMMENT '创建时间', 
    PRIMARY KEY (`ID`), 
    UNIQUE KEY (`NAME`), 
    UNIQUE KEY (`CODE`), 
    FOREIGN KEY (`PARENT_ID`) REFERENCES `AUTH_ORGANIZATION` (`ID`), 
    FOREIGN KEY (`ROOT_ID`) REFERENCES `AUTH_ORGANIZATION` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织管理';


DROP TABLE IF EXISTS `AUTH_RESOURCE`;
CREATE TABLE `AUTH_RESOURCE` (
    `ID` VARCHAR(40) NOT NULL  COMMENT '主键', 
    `NAME` VARCHAR(100) NOT NULL   COMMENT '名称', 
    `CODE` VARCHAR(200) NOT NULL   COMMENT '编码', 
    `STATUS` VARCHAR(1) NOT NULL  DEFAULT 'N' COMMENT '状态', 
    `TYPE1` VARCHAR(40) NOT NULL   COMMENT '一级分类', 
    `TYPE2` VARCHAR(40) NOT NULL   COMMENT '二级分类', 
    `DESCRIPTION` VARCHAR(200)    COMMENT '描述', 
    `UPDATE_TIME` DATETIME NOT NULL  DEFAULT '1970-01-01 00:00:00' COMMENT '修改时间', 
    `CREATE_TIME` DATETIME NOT NULL  DEFAULT '1970-01-01 00:00:00' COMMENT '创建时间', 
    PRIMARY KEY (`ID`), 
    UNIQUE KEY (`NAME`), 
    UNIQUE KEY (`CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源管理';


DROP TABLE IF EXISTS `AUTH_USER`;
CREATE TABLE `AUTH_USER` (
    `ID` VARCHAR(40) NOT NULL  COMMENT '主键', 
    `NAME` VARCHAR(100) NOT NULL   COMMENT '用户名称', 
    `STATUS` VARCHAR(1) NOT NULL   COMMENT '状态', 
    `TYPE` VARCHAR(50) NOT NULL   COMMENT '类型', 
    `TEL` VARCHAR(40) NOT NULL   COMMENT '联系电话', 
    `EMAIL` VARCHAR(80) NOT NULL   COMMENT '联系EMAIL', 
    `SEX` VARCHAR(1) NOT NULL   COMMENT '性别', 
    `DESCRIPTION` VARCHAR(200)    COMMENT '描述', 
    `UPDATE_TIME` DATETIME NOT NULL  DEFAULT '1970-01-01 00:00:00' COMMENT '修改时间', 
    `CREATE_TIME` DATETIME NOT NULL  DEFAULT '1970-01-01 00:00:00' COMMENT '创建时间', 
    PRIMARY KEY (`ID`), 
    UNIQUE KEY (`NAME`), 
    UNIQUE KEY (`EMAIL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户管理';


DROP TABLE IF EXISTS `AUTH_AUTHER_ROLE`;
CREATE TABLE `AUTH_AUTHER_ROLE` (
    `ID` VARCHAR(40) NOT NULL  COMMENT '主键', 
    `AUTHER_ID` VARCHAR(40) NOT NULL   COMMENT '授权实体', 
    `ROLE_ID` VARCHAR(40) NOT NULL   COMMENT '角色', 
    `TYPE` VARCHAR(40) NOT NULL   COMMENT '分类', 
    `CREATE_TIME` DATETIME NOT NULL  DEFAULT '1970-01-01 00:00:00' COMMENT '创建时间', 
    `UPDATE_TIME` DATETIME NOT NULL  DEFAULT '1970-01-01 00:00:00' COMMENT '修改时间', 
    PRIMARY KEY (`ID`), 
    FOREIGN KEY (`ROLE_ID`) REFERENCES `AUTH_ROLE` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='授权角色';


DROP TABLE IF EXISTS `AUTH_ROLE`;
CREATE TABLE `AUTH_ROLE` (
    `ID` VARCHAR(40) NOT NULL  COMMENT '主键', 
    `NAME` VARCHAR(100) NOT NULL   COMMENT '名称', 
    `CODE` VARCHAR(40) NOT NULL   COMMENT '编码', 
    `TYPE1` VARCHAR(40) NOT NULL   COMMENT '一级分类', 
    `TYPE2` VARCHAR(40) NOT NULL   COMMENT '二级分类', 
    `STATUS` VARCHAR(1) NOT NULL  DEFAULT 'N' COMMENT '状态', 
    `DESCRIPTION` VARCHAR(200)    COMMENT '描述', 
    `UPDATE_TIME` DATETIME NOT NULL  DEFAULT '1970-01-01 00:00:00' COMMENT '修改时间', 
    `CREATE_TIME` DATETIME NOT NULL  DEFAULT '1970-01-01 00:00:00' COMMENT '创建时间', 
    PRIMARY KEY (`ID`), 
    UNIQUE KEY (`NAME`), 
    UNIQUE KEY (`CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色管理';


DROP TABLE IF EXISTS `AUTH_MENU`;
CREATE TABLE `AUTH_MENU` (
    `ID` VARCHAR(40) NOT NULL  COMMENT '主键', 
    `NAME` VARCHAR(100) NOT NULL   COMMENT '菜单名称', 
    `RESOURCE_ID` VARCHAR(40) NOT NULL   COMMENT '资源', 
    `TYPE1` VARCHAR(40) NOT NULL   COMMENT '一级分类', 
    `TYPE2` VARCHAR(40) NOT NULL   COMMENT '二级分类', 
    `PARENT_ID` VARCHAR(40)    COMMENT '父菜单', 
    `ROOT_ID` VARCHAR(40)    COMMENT '根菜单', 
    `MENU_INDEX` INT   DEFAULT 100 COMMENT '菜单排序', 
    `MAX_LEVEL` INT   DEFAULT 3 COMMENT '菜单层次', 
    `ICO` VARCHAR(50)    COMMENT '图标', 
    `DESCRIPTION` VARCHAR(200)    COMMENT '描述', 
    `UPDATE_TIME` DATETIME NOT NULL  DEFAULT '1970-01-01 00:00:00' COMMENT '修改时间', 
    `CREATE_TIME` DATETIME NOT NULL  DEFAULT '1970-01-01 00:00:00' COMMENT '创建时间', 
    PRIMARY KEY (`ID`), 
    UNIQUE KEY (`NAME`), 
    FOREIGN KEY (`RESOURCE_ID`) REFERENCES `AUTH_RESOURCE` (`ID`), 
    FOREIGN KEY (`PARENT_ID`) REFERENCES `AUTH_MENU` (`ID`), 
    FOREIGN KEY (`ROOT_ID`) REFERENCES `AUTH_MENU` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单管理';


DROP TABLE IF EXISTS `AUTH_ORGANIZATION_USER`;
CREATE TABLE `AUTH_ORGANIZATION_USER` (
    `ID` VARCHAR(40) NOT NULL  COMMENT '主键', 
    `USER_ID` VARCHAR(40) NOT NULL   COMMENT '用户', 
    `ORGANIZATION_ID` VARCHAR(40) NOT NULL   COMMENT '组织机构', 
    `UPDATE_TIME` DATETIME NOT NULL  DEFAULT '1970-01-01 00:00:00' COMMENT '修改时间', 
    `CREATE_TIME` DATETIME NOT NULL  DEFAULT '1970-01-01 00:00:00' COMMENT '创建时间', 
    PRIMARY KEY (`ID`), 
    FOREIGN KEY (`USER_ID`) REFERENCES `AUTH_USER` (`ID`), 
    FOREIGN KEY (`ORGANIZATION_ID`) REFERENCES `AUTH_ORGANIZATION` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织用户';


DROP TABLE IF EXISTS `AUTH_ROLE_RESOURCE`;
CREATE TABLE `AUTH_ROLE_RESOURCE` (
    `ID` VARCHAR(40) NOT NULL  COMMENT '主键', 
    `ROLE_ID` VARCHAR(40) NOT NULL   COMMENT '角色', 
    `RESOURCE_ID` VARCHAR(40) NOT NULL   COMMENT '资源', 
    `CREATE_TIME` DATETIME NOT NULL  DEFAULT '1970-01-01 00:00:00' COMMENT '创建时间', 
    `UPDATE_TIME` DATETIME NOT NULL  DEFAULT '1970-01-01 00:00:00' COMMENT '修改时间', 
    PRIMARY KEY (`ID`), 
    FOREIGN KEY (`ROLE_ID`) REFERENCES `AUTH_ROLE` (`ID`), 
    FOREIGN KEY (`RESOURCE_ID`) REFERENCES `AUTH_RESOURCE` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色资源';


DROP TABLE IF EXISTS `AUTH_AUTHER_MENU`;
CREATE TABLE `AUTH_AUTHER_MENU` (
    `ID` VARCHAR(40) NOT NULL  COMMENT '主键', 
    `AUTHER_ID` VARCHAR(40) NOT NULL   COMMENT '授权实体', 
    `MENU_ID` VARCHAR(40) NOT NULL   COMMENT '菜单', 
    `TYPE` VARCHAR(40) NOT NULL   COMMENT '分类', 
    `SORT` INT NOT NULL  DEFAULT 100 COMMENT '排序', 
    `CREATE_TIME` DATETIME NOT NULL   COMMENT '创建时间', 
    `UPDATE_TIME` DATETIME NOT NULL   COMMENT '修改时间', 
    PRIMARY KEY (`ID`), 
    INDEX (`AUTHER_ID`), 
    INDEX (`TYPE`), 
    INDEX (`CREATE_TIME`), 
    INDEX (`UPDATE_TIME`), 
    FOREIGN KEY (`MENU_ID`) REFERENCES `AUTH_MENU` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='授权菜单';


DROP TABLE IF EXISTS `SYS_DICTIONARY`;
CREATE TABLE `SYS_DICTIONARY` (
    `ID` VARCHAR(40) NOT NULL  COMMENT '主键', 
    `TYPE1` VARCHAR(50) NOT NULL   COMMENT '一级分类', 
    `TYPE2` VARCHAR(50) NOT NULL   COMMENT '二级分类', 
    `NAME1` VARCHAR(100) NOT NULL   COMMENT '一级名称', 
    `NAME2` VARCHAR(100) NOT NULL   COMMENT '二级名称', 
    `CODE` VARCHAR(50) NOT NULL   COMMENT '编码', 
    `VALUE` VARCHAR(100)    COMMENT '字典值', 
    `SORT` INT NOT NULL  DEFAULT '0' COMMENT '排序', 
    `DESCIPTION` VARCHAR(200)    COMMENT '描述', 
    `STATUS` VARCHAR(1) NOT NULL  DEFAULT 'Y' COMMENT '状态', 
    `UPDATE_TIME` DATETIME NOT NULL  DEFAULT '1970-01-01 00:00:00' COMMENT '修改时间', 
    `CREATE_TIME` DATETIME NOT NULL  DEFAULT '1970-01-01 00:00:00' COMMENT '创建时间', 
    PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典管理';


DROP TABLE IF EXISTS `SYS_OPENREPORT`;
CREATE TABLE `SYS_OPENREPORT` (
    `ID` VARCHAR(40) NOT NULL  COMMENT '主键', 
    `NAME` VARCHAR(40) NOT NULL   COMMENT '名称', 
    `CONF_TYPE` VARCHAR(100) NOT NULL   COMMENT '配置类别', 
    `XML_CONTENT` TEXT    COMMENT 'XML内容', 
    `TYPE1` VARCHAR(100) NOT NULL   COMMENT '分类1', 
    `TYPE2` VARCHAR(100) NOT NULL   COMMENT '分类2', 
    `DESCRIPTION` VARCHAR(200)    COMMENT '描述', 
    `UPDATE_TIME` DATETIME NOT NULL   COMMENT '修改时间', 
    `CREATE_TIME` DATETIME NOT NULL   COMMENT '创建时间', 
    PRIMARY KEY (`ID`), 
    UNIQUE KEY (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='报表管理';


DROP TABLE IF EXISTS `SYS_I18N`;
CREATE TABLE `SYS_I18N` (
    `ID` VARCHAR(40) NOT NULL  COMMENT '主键', 
    `MESSAGE_KEY` VARCHAR(200) NOT NULL   COMMENT '国际化Key', 
    `MESSAGE_CONTENT` VARCHAR(2048)    COMMENT '国际化内容', 
    PRIMARY KEY (`ID`), 
    UNIQUE KEY (`MESSAGE_KEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='国际化管理';


DROP TABLE IF EXISTS `SYS_EX_TABLE`;
CREATE TABLE `SYS_EX_TABLE` (
    `ID` VARCHAR(40) NOT NULL  COMMENT '主键', 
    `REF_TABLE` VARCHAR(100) NOT NULL   COMMENT '关联表', 
    `COL_NAME` VARCHAR(100) NOT NULL   COMMENT '字段名称', 
    `COL_TYPE` VARCHAR(100) NOT NULL   COMMENT '字段类型', 
    `DESCRIPTION` VARCHAR(200)    COMMENT '描述', 
    `UPDATE_TIME` DATETIME NOT NULL   COMMENT '修改时间', 
    `CREATE_TIME` DATETIME NOT NULL   COMMENT '创建时间', 
    PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='扩展表管理';


DROP TABLE IF EXISTS `SYS_EX_DATA`;
CREATE TABLE `SYS_EX_DATA` (
    `ID` VARCHAR(40) NOT NULL  COMMENT '主键', 
    `REF_TABLE` VARCHAR(100) NOT NULL   COMMENT '表名', 
    `REF_ID` VARCHAR(40) NOT NULL   COMMENT '关联主键', 
    `COL_NAME` VARCHAR(100) NOT NULL   COMMENT '字段名称', 
    `COL_VALUE` VARCHAR(2048)    COMMENT '字段值', 
    `DESCRIPTION` VARCHAR(200)    COMMENT '描述', 
    `UPDATE_TIME` DATETIME NOT NULL   COMMENT '修改时间', 
    `CREATE_TIME` DATETIME NOT NULL   COMMENT '创建时间', 
    PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='扩展数据管理';


DROP TABLE IF EXISTS `SYS_QUERY`;
CREATE TABLE `SYS_QUERY` (
    `ID` VARCHAR(40) NOT NULL  COMMENT '主键', 
    `NAME` VARCHAR(200) NOT NULL   COMMENT '名称', 
    `CODE` VARCHAR(40) NOT NULL   COMMENT '代码', 
    `DATA_SOURCE` VARCHAR(200)    COMMENT '数据源', 
    `QUERY_CONTENT` TEXT NOT NULL   COMMENT '查询语句', 
    `TYPE_1` VARCHAR(100) NOT NULL   COMMENT '一级分类', 
    `TYPE_2` VARCHAR(100) NOT NULL   COMMENT '二级分类', 
    `DESCRIPTION` VARCHAR(200)    COMMENT '描述', 
    `UPDATE_TIME` DATETIME NOT NULL   COMMENT '修改时间', 
    `CREATE_TIME` DATETIME NOT NULL   COMMENT '创建时间', 
    PRIMARY KEY (`ID`), 
    INDEX (`UPDATE_TIME`), 
    INDEX (`CREATE_TIME`), 
    UNIQUE KEY (`NAME`), 
    UNIQUE KEY (`CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='通用查询管理';


DROP TABLE IF EXISTS `SYS_SCRIPT`;
CREATE TABLE `SYS_SCRIPT` (
    `ID` VARCHAR(40) NOT NULL  COMMENT '主键', 
    `NAME` VARCHAR(200) NOT NULL   COMMENT '名称', 
    `CODE` VARCHAR(40) NOT NULL   COMMENT '代码', 
    `CONTENT` TEXT NOT NULL   COMMENT '内容', 
    `PARAMETER` TEXT    COMMENT '参数', 
    `TYPE_1` VARCHAR(40) NOT NULL   COMMENT '分类1', 
    `TYPE_2` VARCHAR(40) NOT NULL   COMMENT '分类2', 
    `DESCRIPTION` VARCHAR(200)    COMMENT '描述', 
    `CREATE_TIME` DATETIME NOT NULL   COMMENT '创建时间', 
    `UPDATE_TIME` DATETIME NOT NULL   COMMENT '更新时间', 
    PRIMARY KEY (`ID`), 
    INDEX (`CREATE_TIME`), 
    INDEX (`UPDATE_TIME`), 
    UNIQUE KEY (`NAME`), 
    UNIQUE KEY (`CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='脚本管理';


DROP TABLE IF EXISTS `LOG_ACCESS`;
CREATE TABLE `LOG_ACCESS` (
    `ID` VARCHAR(40) NOT NULL  COMMENT '主键', 
    `TYPE` VARCHAR(40) NOT NULL   COMMENT '类型', 
    `USER` VARCHAR(100) NOT NULL   COMMENT '访问者', 
    `SOURCE` VARCHAR(100) NOT NULL   COMMENT '来源', 
    `TARGET` VARCHAR(2048) NOT NULL   COMMENT '目标', 
    `CREATE_TIME` DATETIME NOT NULL   COMMENT '创建时间', 
    `UPDATE_TIME` DATETIME NOT NULL   COMMENT '修改时间', 
    PRIMARY KEY (`ID`), 
    INDEX (`TYPE`), 
    INDEX (`USER`), 
    INDEX (`SOURCE`), 
    INDEX (`CREATE_TIME`), 
    INDEX (`UPDATE_TIME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='访问日志';


DROP TABLE IF EXISTS `LOG_OPERATION`;
CREATE TABLE `LOG_OPERATION` (
    `ID` VARCHAR(40) NOT NULL  COMMENT '主键', 
    `TYPE` VARCHAR(200) NOT NULL   COMMENT '类型', 
    `OPERATOR` VARCHAR(200) NOT NULL   COMMENT '操作者', 
    `TARGET` VARCHAR(1000) NOT NULL   COMMENT '目标', 
    `START_TIME` TIMESTAMP NOT NULL   COMMENT '开始时间', 
    `END_TIME` TIMESTAMP NOT NULL   COMMENT '结束时间', 
    `COST_TIME` INT NOT NULL   COMMENT '耗时', 
    `RESULT` VARCHAR(2000) NOT NULL   COMMENT '结果', 
    `CREATE_TIME` DATETIME NOT NULL   COMMENT '创建时间', 
    `UPDATE_TIME` DATETIME NOT NULL   COMMENT '修改时间', 
    PRIMARY KEY (`ID`), 
    INDEX (`TYPE`), 
    INDEX (`OPERATOR`), 
    INDEX (`TARGET`), 
    INDEX (`START_TIME`), 
    INDEX (`END_TIME`), 
    INDEX (`COST_TIME`), 
    INDEX (`CREATE_TIME`), 
    INDEX (`UPDATE_TIME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='操作日志';


SET foreign_key_checks = 1;
