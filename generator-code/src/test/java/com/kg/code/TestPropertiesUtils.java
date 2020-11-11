package com.kg.code;

import com.kg.code.common.utils.PropertiesUtils;
import org.junit.Test;

public class TestPropertiesUtils {
    @Test
    public void test() {
        System.out.println(PropertiesUtils.properties("mysql.localhost").toString());
    }
}
