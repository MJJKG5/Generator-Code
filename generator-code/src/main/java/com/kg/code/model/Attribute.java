package com.kg.code.model;

import java.io.Serializable;

public class Attribute implements Serializable {
    private static final long serialVersionUID = -1063046046694902290L;
    /**
     * 类型
     */
    private String type;
    /**
     * 属性名
     */
    private String name;
    /**
     * 方法名
     */
    private String methodName;
    /**
     * 列名
     */
    private String columnName;
    /**
     * 主键
     */
    private String primaryKey;
    /**
     * 自增
     */
    private String extra;
    /**
     * 备注
     */
    private String comment;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
