package com.hong.musichqend.tools;

import lombok.Data;

import java.io.Serializable;

/**
 * 统一返回结果
 * @param <T>
 */
@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private int code;  // 状态码 200 成功 400 失败
    private String message; // 返回值消息提示
    private Object data; // 数据


    // 成功的状态 -- 空参
    public static<T> Result<T> success(){
        Result result = new Result();
        result.code = 200;
        return result;
    }

    //异常
    public static<T> Result<T> fatal(String msg){
        Result result = error(msg);
        result.code = 500;
        return result;
    }

    // 成功的状态 -- 全参
    public static<T> Result<T> success(T object) {
        Result result = new Result();
        result.code = 200;
        result.data = object;
        return result;
    }

    // 成功的状态 -- 全参
    public static<T> Result<T> success(String msg,T object){
        Result result = new Result();
        result.code = 200;
        result.message = msg;
        result.data = object;
        return result;
    }


    // 错误返回状态
    public static <T> Result<T> error(String msg){
        Result result = new Result();
        result.code = 400;
        result.message = msg;
        return result;
    }

//    //  错误返回状态
//    public static <T> Result<T> fatal(String msg){
//        Result r = error(msg);
//    }

}

