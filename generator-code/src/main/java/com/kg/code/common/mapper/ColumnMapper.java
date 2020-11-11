package com.kg.code.common.mapper;

import com.kg.code.common.handle.ConnectionHandle;
import com.kg.code.common.mapper.enums.SQL;
import com.kg.code.model.Column;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ColumnMapper {
    /**
     * 查询表的列
     *
     * @param tableName 表名
     * @return
     */
    public List<Column> queryColumn(String tableName) {
        List<Column> columns = new ArrayList<>();
        // 查询sql语句
        String sql = SQL.QUERY_TABLE_FILED_SQL_1 + tableName + SQL.QUERY_TABLE_FILED_SQL_2;
        try {
            ResultSet result = ConnectionHandle.getConnection()
                    .createStatement()
                    .executeQuery(sql);
            while (result.next()) {
                // 列名
                String columnName = result.getString("COLUMN_NAME");
                // 列类型
                String dataType = result.getString("DATA_TYPE");
                // 列备注
                String columnComment = result.getString("COLUMN_COMMENT");
                // 列主键
                String columnKey = result.getString("COLUMN_KEY");
                // 列自增
                String extra = result.getString("EXTRA");

                Column column = new Column(columnName, dataType, columnComment, columnKey, extra);
                columns.add(column);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return columns;
    }
}
