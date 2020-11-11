package com.kg.code.model;

import java.io.Serializable;
import java.util.List;

public class Entity implements Serializable {
    private static final long serialVersionUID = 1651951077298417478L;
    /**
     * 类名
     */
    private String className;
    /**
     * 表名
     */
    private String tableName;
    /**
     * 表备注
     */
    private String tableComment;
    /**
     * 包名
     */
    private String packageName;
    /**
     * 引用名
     */
    private String referenceName;
    /**
     * 属性
     */
    private List<Attribute> attributes;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableComment() {
        return tableComment;
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getReferenceName() {
        return referenceName;
    }

    public void setReferenceName(String referenceName) {
        this.referenceName = referenceName;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }
}
