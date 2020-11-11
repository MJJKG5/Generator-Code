package com.kg.code.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {
    private static Properties properties;

    // 加载属性文件
    static {
        InputStream input = ClassLoader.getSystemResourceAsStream("database-config.properties");
        properties = new Properties();
        try {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取属性
     *
     * @return 属性值
     */
    public static Object properties(String key) {
        return properties.get(key);
    }
}
