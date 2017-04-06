package com.homvee.dao.domain.common;

/**
 * @Package: com.homvee.dao.domain.common
 * @Description: TODO
 * @date:2016/11/3
 * @author: Hongwei.tang
 * @email: Hongwei.Tang@DMall.com
 * @Copyright: Copyright(c) 2016, DMall All Rights Reserved.
 */
public class Message {
    private static String SUCCESS = "success";
    private static String FAILURE = "success";
    private String code;
    private String msg;
    private Object data;

    public Message() {
    }
    public Message(String code, String msg) {
        this(code,msg,null);
    }

    public Message(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public <E> E getData() {
        return (E) data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static Message success(){
        return success("操作成功");
    }
    public static Message success(String msg){
        return success(msg,null);
    }
    public static Message success(Object data){
        return success(null,data);
    }
    public static Message success(String msg,Object data){
        Message message = new Message(SUCCESS,msg,data);
        return message;
    }
    public static Message failure(){
        return success("操作失败");
    }
    public static Message failure(String msg){
        return success(msg,null);
    }
    public static Message failure(Object data){
        return success(null,data);
    }
    public static Message failure(String msg,Object data){
        Message message = new Message(FAILURE,msg,data);
        return message;
    }

}
