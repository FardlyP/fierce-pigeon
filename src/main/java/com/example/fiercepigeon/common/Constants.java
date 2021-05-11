package com.example.fiercepigeon.common;

public interface Constants {

    /**
     * 错误码前缀=组件标识+"0"
     */
    String ERROR_CODE_PREFIX = "0x0000";
    /**
     * 默认日期时间格式
     */
    String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 默认日期格式
     */
    String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    /**
     * 默认时间格式
     */
    String DEFAULT_TIME_FORMAT = "HH:mm:ss";

    /**
     * 分页查询默认排序
     */
    String DEFAULT_ORDERBY = "update_time DESC";

    String FIELD_NAME_REGEX = "^\\w+$";

    /**
     * gsub需要转义的控制字符
     */
    String CONTROL_CHARACTER = "+ ? . * ^ $ ( ) [ ] { } | \\";

}
