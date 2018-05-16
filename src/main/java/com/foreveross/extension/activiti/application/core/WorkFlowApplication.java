/*******************************************************************************
 * Copyright (c) Jun 23, 2016 @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>.
 * All rights reserved.
 *
 * Contributors:
 *     <a href="mailto:iffiff1@gmail.com">Tyler Chen</a> - initial API and implementation
 ******************************************************************************/
package com.foreveross.extension.activiti.application.core;

import org.iff.infra.util.mybatis.plugin.Page;

import java.util.List;
import java.util.Map;

/**
 * 工作流应用服务
 *
 * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
 * @since Jun 23, 2016
 */
@SuppressWarnings("rawtypes")
public interface WorkFlowApplication {

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
    Page pageFindProcessDefinition(Page page);

    /**
     * 读取流程图，通过流程定义ID
     *
     * @param processDefinitionId 流程定义
     * @return
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 24, 2016
     */
    byte[] loadImageByProcessDefinitionId(String processDefinitionId);

    /**
     * 读取流程定义XML，通过流程定义ID
     *
     * @param processDefinitionId 流程定义
     * @return
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 24, 2016
     */
    String loadXmlByProcessDefinitionId(String processDefinitionId);

    /**
     * 读取流程图，通过流程ID
     *
     * @param processInstanceId 流程ID
     * @return
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 24, 2016
     */
    byte[] loadImageByProcessInstanceId(String processInstanceId);

    /**
     * 读取流程定义XML，通过流程ID
     *
     * @param processInstanceId 流程ID
     * @return
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 24, 2016
     */
    String loadXmlByProcessInstanceId(String processInstanceId);

    /**
     * 删除部署的流程，级联删除流程实例
     *
     * @param deploymentId 流程部署ID
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 24, 2016
     */
    void deleteDeploymentAndInstance(String deploymentId);

    /**
     * 删除部署的流程，不级联删除流程实例
     *
     * @param deploymentId 流程部署ID
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 24, 2016
     */
    void deleteDeployment(String deploymentId);

    /**
     * 读取带跟踪的图片
     *
     * @param executionId
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 23, 2016
     */
    byte[] generateTraceImagePng(String executionId);

    /**
     * 部署打包流程（ZIP、BAR格式）
     *
     * @param exportDir
     * @param file
     * @return
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 23, 2016
     */
    void deployZip(byte[] zipData);

    /**
     * 输出跟踪流程信息，流程跟踪图
     *
     * @param processInstanceId
     * @return 封装了各种节点信息
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 24, 2016
     */
    List<Map<String, Object>> traceProcess(String processInstanceId);

    /**
     * 转换流程节点类型为中文说明
     *
     * @param type 英文名称
     * @return 翻译后的中文名称
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 24, 2016
     */
    String parseToZhType(String type);

    /**
     * 导出图片文件到硬盘
     *
     * @param processDefinitionId
     * @param exportDir
     * @return 文件的全路径
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 24, 2016
     */
    String exportDiagramToFile(String processDefinitionId, String exportDir);

    /**
     * 待办任务--已经签收的任务
     *
     * @param userId
     * @return
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 24, 2016
     */
    List<Map> findTaskAssignee(String userId);

    /**
     * 待办任务--等待签收的任务
     *
     * @param userId
     * @return
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @see #packageTaskInfo
     * @since Jun 24, 2016
     */
    List<Map> findTaskCandidateUser(String userId);

    /**
     * 激活流程实例
     *
     * @param processDefinitionId
     * @return
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 24, 2016
     */
    void activeProcessDefinition(String processDefinitionId);

    /**
     * 挂起流程实例
     *
     * @param processDefinitionId
     * @return
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 24, 2016
     */
    void suspendProcessDefinition(String processDefinitionId);

    /**
     * 导出图片文件到硬盘
     *
     * @param exportDir
     * @return
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 24, 2016
     */
    List<String> exportDiagrams(String exportDir);

    /**
     * 模型列表
     *
     * @return
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 24, 2016
     */
    Page pageFindModel(Page page);

    /**
     * 创建模型
     *
     * @param name
     * @param key
     * @param description
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 24, 2016
     */
    Map createModel(String name, String key, String description);

    /**
     * 根据Model部署流程
     *
     * @param modelId
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 24, 2016
     */
    void deployModel(String modelId);

    /**
     * 导出model对象为指定类型
     *
     * @param modelId 模型ID
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 24, 2016
     */
    String exportModelToXml(String modelId);

    /**
     * 导出model对象为指定类型
     *
     * @param modelId 模型ID
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 24, 2016
     */
    String exportModelToJson(String modelId);

    /**
     * 删除model
     *
     * @param modelId
     * @return
     * @author <a href="mailto:iffiff1@gmail.com">Tyler Chen</a>
     * @since Jun 24, 2016
     */
    void deleteModelById(String modelId);
}
