package com.kg.code;

import com.kg.code.service.impl.MysqlGenerator;
import org.junit.Test;

public class TestStartApp {
    @Test
    public void generatorCode() {
        new MysqlGenerator().generatorCode();
    }
}
