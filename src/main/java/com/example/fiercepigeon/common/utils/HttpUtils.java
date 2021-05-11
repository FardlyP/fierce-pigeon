package com.example.fiercepigeon.common.utils;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;

import java.util.Map;

/**
 * description <br>
 * 〈http远程调用封装〉
 *
 * @author yanbiao6
 * @create 2018/12/18
 * @since 1.0.0
 */
public class HttpUtils {

    //请求超时时间
    private static final int TIME_OUT = 3000;

    /**
     * 简单get
     */
    public static String get(String url, Map paramMap) {
        return get(url, paramMap, null).body();
    }

    /**
     * 简单post
     */
    public static String post(String url, Map paramMap) {
        return post(url, paramMap, null).body();
    }

    /**
     * get请求
     */
    public static HttpResponse get(String url, Map paramMap, Map header) {
        return HttpRequest.get(url)
                .addHeaders(header)
                .form(paramMap)
                .timeout(TIME_OUT)
                .execute();
    }

    /**
     * post请求
     */
    public static HttpResponse post(String url, Map paramMap, Map header) {
        return HttpRequest.post(url)
                .addHeaders(header)
                .form(paramMap)
                .timeout(TIME_OUT)
                .execute();
    }

    /**
     * post请求
     */
    public static HttpResponse post(String url, String body, Map header) {
        return HttpRequest.post(url)
                .addHeaders(header)
                .body(body)
                .timeout(TIME_OUT)
                .execute();
    }

}
