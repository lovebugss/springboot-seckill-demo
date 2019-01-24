package com.itrjp.seckill.result;/**
 * Created by renjp on 2019/1/24.
 */

/**
 * @author renjp
 * @Date 2019/1/24 9:21
 * @Version 1.0
 */
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    private Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    private Result() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> Result success(Integer code, String message, T data) {
        return new Result(code, message, data);
    }

    public static <T> Result success(String message, T data) {
        return success(1, message, data);
    }

    public static <T> Result success(T data) {
        return success(1, "success", data);
    }

    public static <T> Result error(Integer code, String message, T data) {
        return new Result(code, message, data);
    }

    public static <T> Result error(String message, T data) {
        return error(0, message, data);
    }

    public static <T> Result error(T data) {
        return error(0, "error", data);
    }

    @Override
    public String toString() {
        return "{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
