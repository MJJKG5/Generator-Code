package com.kg.code;

import com.kg.code.common.utils.ConvertUtils;
import org.junit.Test;

public class TestConvertUtils {
    @Test
    public void uppercaseHump() {
        String tableName = "sys_user";
        System.out.println(ConvertUtils.uppercaseHump(tableName));
    }

    @Test
    public void lowercaseHump() {
        String columnName = "sys_user";
        System.out.println(ConvertUtils.lowercaseHump(columnName));
    }
}