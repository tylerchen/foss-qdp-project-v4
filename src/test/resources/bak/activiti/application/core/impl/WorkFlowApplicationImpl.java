/*******************************************************************************
 * Copyright (c) Jun 23, 2016 @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>.
 * All rights reserved.
 *
 * Contributors:
 *     <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> - initial API and implementation
 ******************************************************************************/
package com.foreveross.extension.activiti.application.core.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.foreveross.extension.activiti.application.core.WorkFlowApplication;
import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.*;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.identity.User;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.bpmn.behavior.UserTaskActivityBehavior;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.delegate.ActivityBehavior;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.impl.task.TaskDefinition;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.Model;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.image.ProcessDiagramGenerator;
import org.activiti.image.impl.DefaultProcessDiagramGenerator;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.iff.infra.util.*;
import org.iff.infra.util.mybatis.plugin.Page;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.*;
import java.util.zip.ZipInputStream;

/**
 * 工作流应用。
 *
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
 * @since Jun 23, 2016
 */
@SuppressWarnings("rawtypes")
@Named("workFlowApplication")
@Transactional
public class WorkFlowApplicationImpl implements WorkFlowApplication {

    @Inject
    RepositoryService repositoryService;

    @Inject
    RuntimeService runtimeService;

    @Inject
    FormService formService;

    @Inject
    TaskService taskService;

    @Inject
    HistoryService historyService;

    @Inject
    IdentityService identityService;

    @Inject
    ManagementService managementService;

    /**
     * <pre>
     * 流程定义列表
     * 保存两个对象，一个是ProcessDefinition（流程定义），一个是Deployment（流程部署）
     * 结构：{
     * processDefinitionId, processDefinitionCategory, processDefinitionName,
     * processDefinitionKey, processDefinitionDescription,processDefinitionVersion,
     * processDefinitionResourceName, processDefinitionDeploymentId, processDefinitionDiagramResourceName,
     * processDefinitionHasStartFormKey, processDefinitionHasGraphicalNotation, processDefinitionIsSuspended,
     * processDefinitionTenantId, deploymentId, deploymentName,
     * deploymentTime, deploymentCategory, deploymentTenantId
     * }
     * </pre>
     *
     * @param page
     * @return
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 23, 2016
     */
    public Page pageFindProcessDefinition(Page page) {
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery()
                .orderByDeploymentId().desc();
        List<ProcessDefinition> processDefinitionList = processDefinitionQuery.listPage(page.getOffset(),
                page.getLimit());
        List<Object> objects = new ArrayList<Object>();
        for (ProcessDefinition processDefinition : processDefinitionList) {
            String deploymentId = processDefinition.getDeploymentId();
            Deployment deployment = repositoryService.createDeploymentQuery().deploymentId(deploymentId).singleResult();
            Map map = MapHelper.toMap(/**/
                    "processDefinitionId", processDefinition.getId(), /**/
                    "processDefinitionCategory", processDefinition.getCategory(), /**/
                    "processDefinitionName", processDefinition.getName(), /**/
                    "processDefinitionKey", processDefinition.getKey(), /**/
                    "processDefinitionDescription", processDefinition.getDescription(), /**/
                    "processDefinitionVersion", processDefinition.getVersion(), /**/
                    "processDefinitionResourceName", processDefinition.getResourceName(), /**/
                    "processDefinitionDeploymentId", processDefinition.getDeploymentId(), /**/
                    "processDefinitionDiagramResourceName", processDefinition.getDiagramResourceName(), /**/
                    "processDefinitionHasStartFormKey", processDefinition.hasStartFormKey(), /**/
                    "processDefinitionHasGraphicalNotation", processDefinition.hasGraphicalNotation(), /**/
                    "processDefinitionIsSuspended", processDefinition.isSuspended(), /**/
                    "processDefinitionTenantId", processDefinition.getTenantId(), /**/
                    "deploymentId", deployment.getId(), /**/
                    "deploymentName", deployment.getName(), /**/
                    "deploymentTime", deployment.getDeploymentTime(), /**/
                    "deploymentCategory", deployment.getCategory(), /**/
                    "deploymentTenantId", deployment.getTenantId()/**/
            );
            objects.add(map);
        }
        page.setTotalCount(Long.valueOf(processDefinitionQuery.count()).intValue());
        page.setRows(objects);
        return page;
    }

    /**
     * 读取流程图，通过流程定义ID
     *
     * @param processDefinitionId 流程定义
     * @return
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 23, 2016
     */
    public byte[] loadImageByProcessDefinitionId(String processDefinitionId) {
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .processDefinitionId(processDefinitionId).singleResult();
        String resourceName = processDefinition.getDiagramResourceName();
        InputStream resourceAsStream = repositoryService.getResourceAsStream(processDefinition.getDeploymentId(),
                resourceName);
        return SocketHelper.getByte(resourceAsStream, false);
    }

    /**
     * 读取流程定义XML，通过流程定义ID
     *
     * @param processDefinitionId 流程定义
     * @return
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 23, 2016
     */
    public String loadXmlByProcessDefinitionId(String processDefinitionId) {
        ProcessDefinition processDefinition = getProcessDefinition(processDefinitionId);
        String resourceName = processDefinition.getResourceName();
        InputStream resourceAsStream = repositoryService.getResourceAsStream(processDefinition.getDeploymentId(),
                resourceName);
        return SocketHelper.getContent(resourceAsStream, false);
    }

    /**
     * 读取流程图，通过流程ID
     *
     * @param processInstanceId 流程ID
     * @return
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 23, 2016
     */
    public byte[] loadImageByProcessInstanceId(String processInstanceId) {
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
                .processInstanceId(processInstanceId).singleResult();
        ProcessDefinition processDefinition = getProcessDefinition(processInstance.getProcessDefinitionId());
        String resourceName = processDefinition.getDiagramResourceName();
        InputStream resourceAsStream = repositoryService.getResourceAsStream(processDefinition.getDeploymentId(),
                resourceName);
        return SocketHelper.getByte(resourceAsStream, false);
    }

    /**
     * 读取流程定义XML，通过流程ID
     *
     * @param processInstanceId 流程ID
     * @return
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 23, 2016
     */
    public String loadXmlByProcessInstanceId(String processInstanceId) {
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
                .processInstanceId(processInstanceId).singleResult();
        ProcessDefinition processDefinition = getProcessDefinition(processInstance.getProcessDefinitionId());
        String resourceName = processDefinition.getResourceName();
        InputStream resourceAsStream = repositoryService.getResourceAsStream(processDefinition.getDeploymentId(),
                resourceName);
        return SocketHelper.getContent(resourceAsStream, false);
    }

    /**
     * 删除部署的流程，级联删除流程实例
     *
     * @param deploymentId 流程部署ID
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 23, 2016
     */
    public void deleteDeploymentAndInstance(String deploymentId) {
        repositoryService.deleteDeployment(deploymentId, true);
    }

    /**
     * 删除部署的流程，不级联删除流程实例
     *
     * @param deploymentId 流程部署ID
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 23, 2016
     */
    public void deleteDeployment(String deploymentId) {
        repositoryService.deleteDeployment(deploymentId, false);
    }

    /**
     * 读取带跟踪的图片
     *
     * @param executionId
     * @return
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 23, 2016
     */
    public byte[] generateTraceImagePng(String executionId) {
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(executionId)
                .singleResult();
        BpmnModel bpmnModel = repositoryService.getBpmnModel(processInstance.getProcessDefinitionId());
        List<String> activeActivityIds = runtimeService.getActiveActivityIds(executionId);
		/* 不使用spring请使用下面的两行代码
		   ProcessEngineImpl defaultProcessEngine = (ProcessEngineImpl) ProcessEngines.getDefaultProcessEngine();
		   Context.setProcessEngineConfiguration(defaultProcessEngine.getProcessEngineConfiguration());
		*/
		/*使用spring注入引擎请使用下面的这行代码
			processEngineConfiguration = processEngine.getProcessEngineConfiguration();
			Context.setProcessEngineConfiguration((ProcessEngineConfigurationImpl) processEngineConfiguration);
			ProcessDiagramGenerator diagramGenerator = processEngineConfiguration.getProcessDiagramGenerator();
		 */

        ProcessDiagramGenerator diagramGenerator = new DefaultProcessDiagramGenerator();
        InputStream imageStream = diagramGenerator.generateDiagram(bpmnModel, "png", activeActivityIds);

        /*输出资源内容到相应对象*/
        return SocketHelper.getByte(imageStream, false);
    }

    /**
     * 部署打包流程（ZIP、BAR格式）
     *
     * @param exportDir
     * @param file
     * @return
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 23, 2016
     */
    public void deployZip(byte[] zipData) {
        InputStream fileInputStream = new ByteArrayInputStream(zipData);
        ZipInputStream zip = new ZipInputStream(fileInputStream);
        repositoryService.createDeployment().addZipInputStream(zip).deploy();
    }

    /**
     * 输出跟踪流程信息，流程跟踪图
     *
     * @param processInstanceId
     * @return 封装了各种节点信息
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 23, 2016
     */
    public List<Map<String, Object>> traceProcess(String processInstanceId) {
        Execution execution = runtimeService.createExecutionQuery().executionId(processInstanceId)
                .singleResult();/*执行实例*/
        String activityId = execution.getActivityId();
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
                .processInstanceId(processInstanceId).singleResult();
        ProcessDefinitionEntity processDefinition = (ProcessDefinitionEntity) ((RepositoryServiceImpl) repositoryService)
                .getDeployedProcessDefinition(processInstance.getProcessDefinitionId());
        List<ActivityImpl> activitiList = processDefinition.getActivities();//获得当前任务的所有节点

        List<Map<String, Object>> activityInfos = new ArrayList<Map<String, Object>>();
        for (ActivityImpl activity : activitiList) {
            boolean currentActiviti = false;
            String id = activity.getId();
            /*当前节点*/
            if (id.equals(activityId)) {
                currentActiviti = true;
            }
            Map<String, Object> activityImageInfo = packageSingleActivitiInfo(activity, processInstance,
                    currentActiviti);

            activityInfos.add(activityImageInfo);
        }

        return activityInfos;
    }

    /**
     * <pre>
     * 封装输出信息，包括：当前节点的X、Y坐标、变量信息、任务类型、任务描述
     * 结构:{
     * currentActiviti, x, y, width, height,
     * taskType, taskGroup, currentTaskAssignee,
     * documentation, description,
     * }
     * </pre>
     *
     * @param activity
     * @param processInstance
     * @param currentActiviti
     * @return
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 23, 2016
     */
    private Map<String, Object> packageSingleActivitiInfo(ActivityImpl activity, ProcessInstance processInstance,
                                                          boolean currentActiviti) {
        Map<String, Object> activityInfo = new HashMap<String, Object>();
        {
            activityInfo.put("currentActiviti", currentActiviti);
        }

        setPosition(activity, activityInfo);
        setWidthAndHeight(activity, activityInfo);

        Map<String, Object> properties = activity.getProperties();
        {
            activityInfo.put("taskType", properties.get("type"));
        }

        ActivityBehavior activityBehavior = activity.getActivityBehavior();
        Logger.debug(FCS.get("activityBehavior={0}", activityBehavior));
        if (activityBehavior instanceof UserTaskActivityBehavior) {
            Task currentTask = null;
            /* 当前节点的task */
            if (currentActiviti) {
                currentTask = getCurrentTaskInfo(processInstance);
            }

            /* 当前任务的分配角色 */
            UserTaskActivityBehavior userTaskActivityBehavior = (UserTaskActivityBehavior) activityBehavior;
            TaskDefinition taskDefinition = userTaskActivityBehavior.getTaskDefinition();
            Set<Expression> candidateGroupIdExpressions = taskDefinition.getCandidateGroupIdExpressions();
            if (!candidateGroupIdExpressions.isEmpty()) {
                /*任务的处理角色*/
                setTaskGroup(activityInfo, candidateGroupIdExpressions);
                /*当前处理人*/
                if (currentTask != null) {
                    setCurrentTaskAssignee(activityInfo, currentTask);
                }
            }
        }

        {
            activityInfo.put("documentation", properties.get("documentation"));
            String description = activity.getProcessDefinition().getDescription();
            activityInfo.put("description", description);
        }
        Logger.debug(FCS.get("trace variables: {0}", activityInfo));
        return activityInfo;
    }

    /**
     * 获取当前节点信息
     *
     * @param processInstance
     * @return
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 23, 2016
     */
    private Task getCurrentTaskInfo(ProcessInstance processInstance) {
        Task currentTask = null;
        try {
            String activitiId = processInstance.getActivityId();
            Logger.debug(FCS.get("current activity id: {0}", activitiId));

            currentTask = taskService.createTaskQuery().processInstanceId(processInstance.getId())
                    .taskDefinitionKey(activitiId).singleResult();
            Logger.debug(
                    FCS.get("current task for processInstance: {0}", ToStringBuilder.reflectionToString(currentTask)));

        } catch (Exception e) {
            Logger.debug(FCS.get("can not get property activityId from processInstance: {0}", processInstance));
        }
        return currentTask;
    }

    /**
     * 设置任务组
     *
     * @param activityInfo
     * @param candidateGroupIdExpressions
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 24, 2016
     */
    private void setTaskGroup(Map<String, Object> activityInfo, Set<Expression> candidateGroupIdExpressions) {
        List<String> roles = new ArrayList<String>();
        for (Expression expression : candidateGroupIdExpressions) {
            String expressionText = expression.getExpressionText();
            String roleName = identityService.createGroupQuery().groupId(expressionText).singleResult().getName();
            roles.add(roleName);
        }
        activityInfo.put("taskGroup", StringUtils.join(roles, ","));
    }

    /**
     * 设置当前处理人信息
     *
     * @param activityInfo
     * @param currentTask
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 23, 2016
     */
    private void setCurrentTaskAssignee(Map<String, Object> activityInfo, Task currentTask) {
        String assignee = currentTask.getAssignee();
        if (assignee != null) {
            User assigneeUser = identityService.createUserQuery().userId(assignee).singleResult();
            String userInfo = assigneeUser.getFirstName() + " " + assigneeUser.getLastName();
            activityInfo.put("currentTaskAssignee", userInfo);
        }
    }

    /**
     * 设置宽度、高度属性
     *
     * @param activity
     * @param activityInfo
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 23, 2016
     */
    private void setWidthAndHeight(ActivityImpl activity, Map<String, Object> activityInfo) {
        activityInfo.put("width", activity.getWidth());
        activityInfo.put("height", activity.getHeight());
    }

    /**
     * 设置坐标位置
     *
     * @param activity
     * @param activityInfo
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 23, 2016
     */
    private void setPosition(ActivityImpl activity, Map<String, Object> activityInfo) {
        activityInfo.put("x", activity.getX());
        activityInfo.put("y", activity.getY());
    }

    /**
     * 转换流程节点类型为中文说明
     *
     * @param type 英文名称
     * @return 翻译后的中文名称
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 23, 2016
     */
    public String parseToZhType(String type) {
        Map<String, String> types = new HashMap<String, String>();
        types.put("userTask", "用户任务");
        types.put("serviceTask", "系统任务");
        types.put("startEvent", "开始节点");
        types.put("endEvent", "结束节点");
        types.put("exclusiveGateway", "条件判断节点(系统自动根据条件处理)");
        types.put("inclusiveGateway", "并行处理任务");
        types.put("callActivity", "子流程");
        return types.get(type) == null ? type : types.get(type);
    }

    /**
     * 导出图片文件到硬盘
     *
     * @return 文件的全路径
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 23, 2016
     */
    public String exportDiagramToFile(String processDefinitionId, String exportDir) {
        String diagramPath = "";
        try {
            ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                    .processDefinitionId(processDefinitionId).singleResult();
            String diagramResourceName = processDefinition.getDiagramResourceName();
            String key = processDefinition.getKey();
            int version = processDefinition.getVersion();

            InputStream resourceAsStream = repositoryService.getResourceAsStream(processDefinition.getDeploymentId(),
                    diagramResourceName);
            byte[] bs = SocketHelper.getByte(resourceAsStream, false);

            /*create file if not exist*/
            String diagramDir = StringHelper.pathConcat(exportDir, key, Integer.valueOf(version).toString());
            File diagramDirFile = new File(diagramDir);
            if (!diagramDirFile.exists()) {
                diagramDirFile.mkdirs();
            }
            diagramPath = StringHelper.pathConcat(diagramDir, diagramResourceName);
            File file = new File(diagramPath);

            /*文件存在退出*/
            if (file.exists()) {
                /*文件大小相同时直接返回否则重新创建文件(可能损坏)*/
                Logger.debug(FCS.get("diagram exist, ignore... : {0}", diagramPath));
                return diagramPath;
            } else {
                file.createNewFile();
            }

            Logger.debug(FCS.get("export diagram to : {0}", diagramPath));

            /*wirte bytes to file*/
            FileUtils.writeByteArrayToFile(file, bs, true);
        } catch (Exception e) {
            Logger.debug(FCS.get("ERROR export diagram to : {0}", diagramPath), e);
        }
        return diagramPath;
    }

    /**
     * 待办任务--已经签收的任务
     * 结构:{taskId, taskName, taskCreateTime, processDefinitionId, processDefinitionNamem, processDefinitionVersion}
     *
     * @param userId
     * @return
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 24, 2016
     */
    public List<Map> findTaskAssignee(String userId) {
        List<Map> result = new ArrayList<Map>();
        /*已经签收的任务*/
        List<Task> todoList = taskService.createTaskQuery().taskAssignee(userId).active().list();
        for (Task task : todoList) {
            String processDefinitionId = task.getProcessDefinitionId();
            ProcessDefinition processDefinition = getProcessDefinition(processDefinitionId);
            result.add(packageTaskInfo(task, processDefinition));
        }
        return result;
    }

    /**
     * 待办任务--等待签收的任务
     * 结构:{taskId, taskName, taskCreateTime, processDefinitionId, processDefinitionNamem, processDefinitionVersion}
     *
     * @param userId
     * @return
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 24, 2016
     */
    public List<Map> findTaskCandidateUser(String userId) {
        List<Map> result = new ArrayList<Map>();
        /*等待签收的任务*/
        List<Task> toClaimList = taskService.createTaskQuery().taskCandidateUser(userId).active().list();
        for (Task task : toClaimList) {
            String processDefinitionId = task.getProcessDefinitionId();
            ProcessDefinition processDefinition = getProcessDefinition(processDefinitionId);
            result.add(packageTaskInfo(task, processDefinition));
        }
        return result;
    }

    /**
     * 封装任务信息，{taskId, taskName, taskCreateTime, processDefinitionId, processDefinitionNamem, processDefinitionVersion}
     *
     * @param task
     * @param processDefinition
     * @return
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 24, 2016
     */
    private Map<?, ?> packageTaskInfo(Task task, ProcessDefinition processDefinition) {
        return MapHelper.toMap(/**/
                "taskId", task.getId(), /**/
                "taskName", task.getName(), /**/
                "taskCreateTime", task.getCreateTime(), /**/
                "processDefinitionId", processDefinition.getId(), /**/
                "processDefinitionName", processDefinition.getName(), /**/
                "processDefinitionVersion", processDefinition.getVersion()/**/
        );
    }

    /**
     * 由流程定义ID查询流程定义
     *
     * @param processDefinitionId
     * @return
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 24, 2016
     */
    private ProcessDefinition getProcessDefinition(String processDefinitionId) {
        return repositoryService.createProcessDefinitionQuery().processDefinitionId(processDefinitionId).singleResult();
    }

    /**
     * 激活流程实例
     *
     * @param processDefinitionId
     * @return
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 24, 2016
     */
    public void activeProcessDefinition(String processDefinitionId) {
        repositoryService.activateProcessDefinitionById(processDefinitionId, true, null);
        Logger.debug(FCS.get("message", "已激活ID为[{0}]的流程定义。", processDefinitionId));
    }

    /**
     * 挂起流程实例
     *
     * @param processDefinitionId
     * @return
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 24, 2016
     */
    public void suspendProcessDefinition(String processDefinitionId) {
        repositoryService.suspendProcessDefinitionById(processDefinitionId, true, null);
        Logger.debug(FCS.get("message", "已挂起ID为[{0}]的流程定义。", processDefinitionId));
    }

    /**
     * 导出图片文件到硬盘
     *
     * @param exportDir
     * @return
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 24, 2016
     */
    public List<String> exportDiagrams(String exportDir) {
        List<String> files = new ArrayList<String>();
        List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().list();
        for (ProcessDefinition processDefinition : list) {
            files.add(exportDiagramToFile(processDefinition.getId(), exportDir));
        }
        return files;
    }

    /**
     * 模型列表
     *
     * @return
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 24, 2016
     */
    public Page pageFindModel(Page page) {
        List<Map> result = new ArrayList<Map>();
        List<Model> list = repositoryService.createModelQuery().listPage(page.getOffset(), page.getLimit());
        for (Model model : list) {
            Map map = MapHelper.toMap(/**/
                    "id", model.getId(), /**/
                    "name", model.getName(), /**/
                    "key", model.getKey(), /**/
                    "category", model.getCategory(), /**/
                    "createTime", model.getCreateTime(), /**/
                    "lastUpdateTime", model.getLastUpdateTime(), /**/
                    "version", model.getVersion(), /**/
                    "metaInfo", model.getMetaInfo(), /**/
                    "deploymentId", model.getDeploymentId(), /**/
                    "tenantId", model.getTenantId(), /**/
                    "hasEditorSource", model.hasEditorSource(), /**/
                    "hasEditorSourceExtra", model.hasEditorSourceExtra()/**/
            );
            result.add(map);
        }
        page.setRows(result);
        long count = repositoryService.createModelQuery().count();
        page.setTotalCount(Long.valueOf(count).intValue());
        return page;
    }

    /**
     * 创建模型
     *
     * @param name
     * @param key
     * @param description
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 24, 2016
     */
    public Map createModel(String name, String key, String description) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode editorNode = objectMapper.createObjectNode();
            {
                editorNode.put("id", "canvas");
                editorNode.put("resourceId", "canvas");
                ObjectNode stencilSetNode = objectMapper.createObjectNode();
                stencilSetNode.put("namespace", "http://b3mn.org/stencilset/bpmn2.0#");
                editorNode.set("stencilset", stencilSetNode);
            }
            Model model = repositoryService.newModel();

            ObjectNode modelObjectNode = objectMapper.createObjectNode();
            {
                modelObjectNode.put(ModelDataJsonConstants.MODEL_NAME, name);
                modelObjectNode.put(ModelDataJsonConstants.MODEL_REVISION, 1);
                description = StringUtils.defaultString(description);
                modelObjectNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION, description);
                model.setMetaInfo(modelObjectNode.toString());
                model.setName(name);
                model.setKey(StringUtils.defaultString(key));
            }
            repositoryService.saveModel(model);
            repositoryService.addModelEditorSource(model.getId(), editorNode.toString().getBytes("utf-8"));
            return MapHelper.toMap(/**/
                    "id", model.getId(), /**/
                    "name", model.getName(), /**/
                    "key", model.getKey(), /**/
                    "category", model.getCategory(), /**/
                    "createTime", model.getCreateTime(), /**/
                    "lastUpdateTime", model.getLastUpdateTime(), /**/
                    "version", model.getVersion(), /**/
                    "metaInfo", model.getMetaInfo(), /**/
                    "deploymentId", model.getDeploymentId(), /**/
                    "tenantId", model.getTenantId(), /**/
                    "hasEditorSource", model.hasEditorSource(), /**/
                    "hasEditorSourceExtra", model.hasEditorSourceExtra()/**/
            );
        } catch (Exception e) {
            Exceptions.runtime(FCS.get("ERROR to create model [{0}]!!", name), e);
        }
        return Collections.EMPTY_MAP;
    }

    /**
     * 根据Model部署流程
     *
     * @param modelId
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 24, 2016
     */
    public void deployModel(String modelId) {
        try {
            Model model = repositoryService.getModel(modelId);
            byte[] bpmnBytes = null;
            {
                ObjectNode modelNode = (ObjectNode) new ObjectMapper()
                        .readTree(repositoryService.getModelEditorSource(model.getId()));
                BpmnModel bpmnModel = new BpmnJsonConverter().convertToBpmnModel(modelNode);
                bpmnBytes = new BpmnXMLConverter().convertToXML(bpmnModel);
            }

            String processName = model.getName() + ".bpmn20.xml";
            Deployment deployment = repositoryService.createDeployment().name(model.getName())
                    .addString(processName, new String(bpmnBytes)).deploy();
            Logger.debug(FCS.get("Deploy success deploymentId=", deployment.getId()));
        } catch (Exception e) {
            Exceptions.runtime(FCS.get("ERROR to deploy model [{0}]!!", modelId), e);
        }
    }

    /**
     * 导出model对象为指定类型
     *
     * @param modelId 模型ID
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 24, 2016
     */
    public String exportModelToXml(String modelId) {
        try {
            Model modelData = repositoryService.getModel(modelId);
            BpmnJsonConverter jsonConverter = new BpmnJsonConverter();
            byte[] modelEditorSource = repositoryService.getModelEditorSource(modelData.getId());

            JsonNode editorNode = new ObjectMapper().readTree(modelEditorSource);
            BpmnModel bpmnModel = jsonConverter.convertToBpmnModel(editorNode);

            /*处理异常*/
            if (bpmnModel.getMainProcess() == null) {
                return null;
            }

            BpmnXMLConverter xmlConverter = new BpmnXMLConverter();
            return new String(xmlConverter.convertToXML(bpmnModel), "UTF-8");
        } catch (Exception e) {
            Exceptions.runtime(FCS.get("导出model的xml文件失败：modelId={0}, type=xml", modelId), e);
        }
        return null;
    }

    /**
     * 导出model对象为指定类型
     *
     * @param modelId 模型ID
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 24, 2016
     */
    public String exportModelToJson(String modelId) {
        try {
            Model modelData = repositoryService.getModel(modelId);
            byte[] modelEditorSource = repositoryService.getModelEditorSource(modelData.getId());
            return new String(modelEditorSource, "UTF-8");
        } catch (Exception e) {
            Exceptions.runtime(FCS.get("导出model的xml文件失败：modelId={0}, type=json", modelId), e);
        }
        return null;
    }

    /**
     * 删除model
     *
     * @param modelId
     * @return
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 24, 2016
     */
    public void deleteModelById(String modelId) {
        repositoryService.deleteModel(modelId);
    }
}
