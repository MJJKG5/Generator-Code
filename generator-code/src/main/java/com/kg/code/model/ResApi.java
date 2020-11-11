package com.kg.code.model;

import java.io.Serializable;

public class ResApi<T> implements Serializable {
    private static final long serialVersionUID = -6119010070288281470L;
    /**
     * 编码
     */
    private String code;
    /**
     * 信息
     */
    private String msg;
    /**
     * 结果
     */
    private T result;

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

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
