package com.bds.vue.bean;

/**
 * Created by guoyu on 2018/1/29.
 */
public class Result implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    //返回码
    private int code;
    //返回消息
    private String msg;
    //返回数据对象
    private Object data;
    //返回的记录数
    private int total;

    public Result() {
    }

    public Result(int code, String message) {
        this.code = code;
        this.msg = message;
    }

    public Result(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public void setResult(int code, String message) {
        this.code = code;
        this.msg = message;
    }

    public void setResult(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
