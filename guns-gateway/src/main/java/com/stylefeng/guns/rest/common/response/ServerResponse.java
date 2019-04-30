package com.stylefeng.guns.rest.common.response;

import com.stylefeng.guns.rest.Enum.ResponseCode;

/**
 * @program: guns-parent
 * @description: controller层调用统一的返回格式
 * @author: Zwb
 * @create: 2019-04-28 13:20
 **/

public class ServerResponse<T> {
    private int status;

    private String msg;

    private T data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ServerResponse(String msg){
        this.msg = msg;
    }

    public ServerResponse(T data){
        this.data = data;
    }

    public ServerResponse(int status,String msg){
        this.status = status;
        this.msg = msg;
    }

    public ServerResponse(int status,String msg,T data){
        this.status = status;
        this.msg = msg;
        this.data = data;
    }


    public static <T>ServerResponse<T> success(){
        return new ServerResponse(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getMsg());
    }

    public static <T>ServerResponse<T> success(String msg){
        return new ServerResponse(ResponseCode.SUCCESS.getCode(),msg);
    }

    public static <T>ServerResponse<T> success(T data){
        return new ServerResponse(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getMsg(),data);
    }
    public static <T>ServerResponse<T> success(int code,String msg){
        return new ServerResponse(code,msg);
    }

    public static <T>ServerResponse<T> success(int code,String msg,T data){
        return new ServerResponse(code,msg,data);
    }

    public static <T>ServerResponse<T> error(){
        return new ServerResponse(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getMsg());
    }

    public static <T>ServerResponse<T> error(String msg){
        return new ServerResponse(ResponseCode.ERROR.getCode(),msg);
    }

    public static <T>ServerResponse<T> error(int code,String msg){
        return new ServerResponse(code,msg);
    }

    public static <T>ServerResponse<T> error(int code,String msg,T data){
        return new ServerResponse(code,msg,data);
    }


}
