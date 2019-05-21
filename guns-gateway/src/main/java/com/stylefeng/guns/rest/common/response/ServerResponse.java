package com.stylefeng.guns.rest.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.stylefeng.guns.rest.Enum.ResponseCode;

/**
 * @program: guns-parent
 * @description: controller层调用统一的返回格式
 * @author: Zwb
 * @create: 2019-04-28 13:20
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServerResponse<T> {
    private int status;

    private String msg;

    private String imgPre;



    private int nowPage;

    private int totalPage;

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

    public String getImgPre() {
        return imgPre;
    }

    public void setImgPre(String imgPre) {
        this.imgPre = imgPre;
    }

    public int getNowPage() {
        return nowPage;
    }

    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
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

    public ServerResponse(int status, String msg, String imgPre, T data) {
        this.status = status;
        this.msg = msg;
        this.imgPre = imgPre;
        this.data = data;
    }

    public ServerResponse(int status, String msg, String imgPre, int nowPage, int totalPage, T data) {
        this.status = status;
        this.msg = msg;
        this.imgPre = imgPre;
        this.nowPage = nowPage;
        this.totalPage = totalPage;
        this.data = data;
    }

    public ServerResponse(int status, String msg, T data){
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

    public static <T>ServerResponse<T> success(String imgPre, T data){
        return new ServerResponse(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getMsg(),imgPre,data);
    }

    public static <T>ServerResponse<T> success(String imgPre,int nowPage,int totalPage, T data){
        return new ServerResponse(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getMsg(),imgPre,nowPage,totalPage,data);
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
