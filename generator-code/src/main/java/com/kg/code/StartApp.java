package com.kg.code;

import com.kg.code.service.impl.MysqlGenerator;
import com.kg.code.service.Generator;

public class StartApp {
    public static void main(String[] args) {
        Generator generator = new MysqlGenerator();
        generator.generatorCode();
    }
}
