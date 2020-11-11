package com.kg.code.model;

import java.io.Serializable;

public class Column implements Serializable {
    private static final long serialVersionUID = -834651183258817318L;
    /**
     * 列名
     */
    private String columnName;
    /**
     * 列类型
     */
    private String dataType;
    /**
     * 列备注
     */
    private String columnComment;
    /**
     * 列主键
     */
    private String columnKey;
    /**
     * 列自增
     */
    private String extra;

    public Column() {
    }

    public Column(String columnName, String dataType, String columnComment, String columnKey, String extra) {
        this.columnName = columnName;
        this.dataType = dataType;
        this.columnComment = columnComment;
        this.columnKey = columnKey;
        this.extra = extra;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    public String getColumnKey() {
        return columnKey;
    }

    public void setColumnKey(String columnKey) {
        this.columnKey = columnKey;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    @Override
    public String toString() {
        return "Column{" +
                "columnName='" + columnName + '\'' +
                ", dataType='" + dataType + '\'' +
                ", columnComment='" + columnComment + '\'' +
                ", columnKey='" + columnKey + '\'' +
                ", extra='" + extra + '\'' +
                '}';
    }
}
