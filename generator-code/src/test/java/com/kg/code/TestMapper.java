package com.kg.code;

import com.kg.code.common.mapper.ColumnMapper;
import com.kg.code.common.mapper.TableMapper;
import com.kg.code.model.Table;
import org.junit.Test;

import java.util.List;

public class TestMapper {
    @Test
    public void queryTable() {
        List<Table> tables = new TableMapper().queryTable();
        tables.forEach(System.out::println);
    }

    @Test
    public void queryColumn() {
        new TableMapper().queryTable().forEach(table ->
                new ColumnMapper().queryColumn(table.getTableName()).forEach(System.out::println));
    }
}
