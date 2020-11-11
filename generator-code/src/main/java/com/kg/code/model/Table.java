package com.kg.code.model;

import java.io.Serializable;

public class Table implements Serializable {
    private static final long serialVersionUID = 8784450317046256017L;
    /**
     * 表名
     */
    private String tableName;
    /**
     * 备注
     */
    private String tableComment;

    public Table() { }

    public Table(String tableName, String tableComment) {
        this.tableName = tableName;
        this.tableComment = tableComment;
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

    @Override
    public String toString() {
        return "Table{" +
                "tableName='" + tableName + '\'' +
                ", tableComment='" + tableComment + '\'' +
                '}';
    }
}
