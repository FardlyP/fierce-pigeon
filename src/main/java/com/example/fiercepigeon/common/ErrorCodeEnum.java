package com.example.fiercepigeon.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 自定义错误码范围为四位数字
 */
@Getter
@AllArgsConstructor
public enum ErrorCodeEnum {

    RECORD_NOT_FOUND("00001", "记录不存在", ""),

    SUCCESS("0", "成功", "success"),
    UNKNOWN_EXCEPTION("9999", "未知异常", "unknown exception"),

    //通用异常
    INVALID_PATH("1001", "无效地址", "invalid path"),
    PARAM_NULL("1002", "必填参数为空", "required parameters null"),
    PARAM_TYPE_MISSMATCH("1003", "参数类型不匹配", "parameter type miss match"),
    PARAM_VALIDATE_FAIL("1004", "参数校验失败", "parameter validate failed"),
    SOCKET_TIMEOUT_ERROR("1005", "连接超时", "socket timeout"),
    JSON_ERROR("1006", "json转化异常", "json parse error"),
    SQL_EXECUTE_ERROR("1007", "sql执行异常", "sql execute error"),
    KEY_DUPLICATE_ERROR("1008", "主键冲突", "key duplicate"),
    OPERATE_SERVER_FAILED("1009", "操作远程服务器失败", "operate remote server failed"),
    CONNECTION_SERVER_FAILED("1010", "连接远程服务器失败", "connect remote server failed"),
    VERIFY_FILE_AUTH_FAILED("1011", "验证文件权限失败", "verify file auth failed"),
    NO_FILE_AUTH("1012", "用户无路径权限", "file auth failed"),
    VERIFY_FILE_PATH_FAILED("1013", "获取目录文件失败", "get path file failed"),
    RM_FILE_FAILED("1014", "删除文件失败", "rm file failed"),
    RM_DIR_FAILED("1015", "删除文件夹失败", "rm dir failed"),
    GET_PORT_FAILED("1016", "获取端口失败", "get port failed"),
    UNZIP_FILE_FAILED("1017", "解压文件失败", "unzip file failed"),
    FILE_NOT_FOUND("1018", "文件未找到", "file not found"),
    UPLOAD_FILE_FAILED("1019", "上传文件或修改权限失败", "sftp put or chmod failed"),
    SERVER_EXIT("1020", "服务器存在", "server exist"),
    SERVER_NAME_EXIT("1021", "服务器不能重名", "SERVER_NAME_EXIT"),
    CONNECTION_SERVER_IP_EXIT("1022", "服务器IP已存在", "CONNECTION_SERVER_IP_EXIT"),
    SSH_SESSION_OPEN_FAILED("1023", "ssh会话开启失败", "open ssh session failed"),
    SERVER_INSTALLED_NODE_OR_NODE_IS_RUNING("1024", "此服务器上配置有采集器或正在进行采集", "node install or node is running"),


    //采集节点及实例配置
    NODE_TYPE_UNKNOWN("2001", "未知节点类型", "unknown nodeType"),
    NODE_DELETE_REJECT("2002", "节点未卸载成功，禁止删除", "deleteServer reject, server is occupy"),
    DOWNLOAD_FAIL("2003", "下载失败", "download fail"),
    SERVER_NOT_EXIT("2004", "服务器不存在", "server not exist"),
    INSTALL_UNLOAD_REJECT("2005", "当前节点禁止安装或卸载", "install or unload reject, node is installing or unload fail"),
    NODE_INSTALL_PATH_ILLEGAL("2006", "节点安装路径下已存在安装包", "node install path illegal"),
    INSTANCE_DELETE_REJECT("2007", "实例运作中，禁止删除", "deleteInstance reject, instance is occupy"),
    INSTANCE_START_ERROR("2008", "实例启动失败", "start instance fail"),
    INSTANCE_STOP_ERROR("2009", "实例停止失败", "stop instance fail"),

    //标准化模板
    TEMPLATE_DELETE_REJECT("3001", "标准化模板被引用，禁止删除", "delete reject, template is occupy"),

    PORT_DUPLICATE_ERROR("3002", "输出至logstash端口冲突", "logstash output port duplicate"),
    FILEBEAT_NOT_EXIST("3003", "filebeat节点不存在", "filebeat not exist"),
    LOGSTASH_NOT_EXIST("3004", "logstash节点不存在", "logstash not exist"),
    MODIFY_YML_ERROR("3005", "修改filebeat配置文件失败", "update yml file fail"),
    PORT_REJECT("3006", "暂无可用端口", "get port fail"),
    TEMPLATE_UPDATE_REJECT("3001", "标准化模板被引用，禁止更新", "update reject, template is occupy"),

    //采集器
    STOP_ERROR("4001", "停止采集器失败", "stop harvester fail"),
    HARVESTER_STATUS_ERROR("4002", "获取采集器状态失败", "get harvester status fail"),
    HARVESTER_DELETE_REJECT("4003", "采集器运行中，禁止删除", "deleteServer reject, harvester is running"),
    TEMPLATE_NOT_EXIT("4004", "接入模板不存在", "access template not exist"),
    HARVESTER_BIND_TEMPLATE_ERROR("4005", "绑定接入模板失败，该接入模板已被其他采集器引用", "harvester bind template fail"),
    HARVESTER_NOT_EXIT("4005", "采集器不存在", "harvester not exist"),
    HARVESTER_PIPELINE_NAME_EXIST("4006", "采集器分组名称存在", "harvester pipeline name exist"),
   // 采集器分组名称


    //策略
    STRATEGY_NOT_FOUND("5001", "策略模板不存在", "strategy template not found");

    private String code;
    private String msgCN;
    private String msgEN;

}
