package com.kg.code.common.mapper;

import com.kg.code.common.handle.ConnectionHandle;
import com.kg.code.common.mapper.enums.SQL;
import com.kg.code.model.Table;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TableMapper {
    /**
     * 查询表
     *
     * @return
     */
    public List<Table> queryTable() {
        List<Table> tables = new ArrayList<>();
        try {
            ResultSet result = ConnectionHandle.getConnection()
                    .createStatement()
                    .executeQuery(SQL.QUERY_TABLE_SQL);
            while (result.next()) {
                // 表名
                String tableName = result.getString("TABLE_NAME");
                // 表备注
                String tableComment = result.getString("TABLE_COMMENT");

                Table table = new Table(tableName, tableComment);
                tables.add(table);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tables;
    }
}
