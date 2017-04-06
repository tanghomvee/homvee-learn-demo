package com.water.dao.domain;

/**
 * @author Tang.Homvee
 * @email Tanghomvee@QQ.COM
 * @PackageName:com.water.dao.domain
 * @Description:TODO
 * @Copyright:Homvee.Tang(c)2016
 * @date:2016年01月03日
 * @version:0.1
 */
public class Msg {
    public static final  String DEFAULT_CODE_SUCCESS="success";
    public static final  String DEFAULT_CODE_ERROR="error";
    private String code;//返回码
    private String msg;//信息描述
    private Object data;//返回数据

    public Msg(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public Msg(String code, String msg) {
        this(code, msg, null);
    }
    public Msg(String code) {
        this(code,null);
    }
    public Msg(){

    }

    public static  Msg error(){
        Object obj = null;
        return error(obj);
    }
    public static  Msg error(String msg){
        return new Msg(DEFAULT_CODE_ERROR,msg);
    }
    public static  Msg error(Object data){
        return new Msg(DEFAULT_CODE_ERROR,"操作失败",data);
    }
    public static Msg success(){
        Object obj = null;
        return success(obj);
    }
    public static Msg success(String msg){
        return new Msg(DEFAULT_CODE_SUCCESS,msg);
    }
    public static Msg success(Object data){
        return new Msg(DEFAULT_CODE_SUCCESS,"操作成功",data);
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
