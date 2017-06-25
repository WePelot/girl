package com.imooc.domain;

/**
 * http请求的最外层
 * Created by hongcj on 2017/6/25.
 */
public class Result<T>{
    //错误码
    public Integer code;
    //错误信息
    public String msg;
    //返回内容，有结果放回object，无结果返回null
    public T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
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
}
