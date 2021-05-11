package com.example.fiercepigeon.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author： FardlyP
 * @description： TODO
 * @date： 2021/3/25 15:11
 * @version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Code2Session {

    //用户唯一标识
    private String openId;
    //会话秘钥
    private String sessionKey;
    //用户在开放平台的唯一标识
    private String unionId;
    //错误码
    private Integer errCode;
    //错误信息
    private String errMsg;
}
