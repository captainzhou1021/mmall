package com.mmall.common;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//保证序列化Json的时候，如果是null的对象，key也会消失
public class ServerResponse<T> implements Serializable {

    private int status;
    private String msg;
    private T date;

    private ServerResponse(int status){
        this.status = status;
    }
    private ServerResponse(int status, T date){
        this.status = status;
        this.date = date;
    }
    private ServerResponse(int status, String msg){
        this.status = status;
        this.msg = msg;
    }
    private ServerResponse(int status, String msg, T date){
        this.status = status;
        this.msg = msg;
        this.date = date;
    }
    @JsonIgnore
    //保证不在json序列化当中
    public boolean isSuccess(){
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    public int getStatus() {
        return status;
    }

    public T getDate() {
        return date;
    }

    public String getMsg() {
        return msg;
    }
    public static <T> ServerResponse<T> createBySuccess(){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
    }
    public static <T> ServerResponse<T> createBySuccessMessage(String msg){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg);
    }
    public static <T> ServerResponse<T> createBySuccess(T date){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),date);
    }
    public static <T> ServerResponse<T> createBySuccess(String msg, T date){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg,date);
    }
    public static <T> ServerResponse<T> createByError(){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
    }
    public static <T> ServerResponse<T> createByErrorMessage(String errorMessage){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),errorMessage);
    }
    public static <T> ServerResponse<T> createByErrorCodeMessage(int ErrorCode, String errorMessage){
        return new ServerResponse<T>(ErrorCode,errorMessage);
    }


}
