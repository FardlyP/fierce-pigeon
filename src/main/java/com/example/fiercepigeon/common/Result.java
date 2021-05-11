package com.example.fiercepigeon.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * description <br>
 * 〈返回结果集封装〉
 */
@Data
public class Result {

    //状态码
    private String code;

    private String msg;

    private Object data = null;

    public Result() {
    }

    /**
     * 以下三个方法使用类似builder模式
     *
     * @param msg
     * @return
     */
    public com.example.fiercepigeon.common.Result msg(String msg) {
        this.msg = msg;
        return this;
    }

    public com.example.fiercepigeon.common.Result data(Object results) {
        this.data = results;
        return this;
    }

    public com.example.fiercepigeon.common.Result data(String key, Object results) {
        Map<String, Object> map = new HashMap<>();
        map.put(key, results);
        this.data = map;
        return this;
    }

    /**
     * 正常返回
     *
     * @return
     */
    public static com.example.fiercepigeon.common.Result success() {
        com.example.fiercepigeon.common.Result result = new com.example.fiercepigeon.common.Result();
        result.setCode(ErrorCodeEnum.SUCCESS.getCode());
        return result;
    }

    /**
     * 错误返回-无参
     *
     * @return
     */
    public static com.example.fiercepigeon.common.Result error() {
        com.example.fiercepigeon.common.Result result = new com.example.fiercepigeon.common.Result();
        result.setCode(ErrorCodeEnum.UNKNOWN_EXCEPTION.getCode());
        result.setMsg(ErrorCodeEnum.UNKNOWN_EXCEPTION.getMsgCN());
        return result;
    }

    /**
     * 错误返回-中文
     *
     * @return
     */
    public static com.example.fiercepigeon.common.Result error(ErrorCodeEnum errorCodeEnum) {
        com.example.fiercepigeon.common.Result result = new com.example.fiercepigeon.common.Result();
        result.setCode(Constants.ERROR_CODE_PREFIX + errorCodeEnum.getCode());
        result.setMsg(errorCodeEnum.getMsgCN());
        return result;
    }

    /**
     * 错误返回-英文
     *
     * @return
     */
    public static com.example.fiercepigeon.common.Result errorEN(ErrorCodeEnum errorCodeEnum) {
        com.example.fiercepigeon.common.Result result = new com.example.fiercepigeon.common.Result();
        result.setCode(Constants.ERROR_CODE_PREFIX + errorCodeEnum.getCode());
        result.setMsg(errorCodeEnum.getMsgEN());
        return result;
    }

    /**
     * 自定义成功码返回
     *
     * @return
     */
    public static com.example.fiercepigeon.common.Result success(String code) {
        com.example.fiercepigeon.common.Result result = new com.example.fiercepigeon.common.Result();
        result.setCode(code);
        return result;
    }

}
