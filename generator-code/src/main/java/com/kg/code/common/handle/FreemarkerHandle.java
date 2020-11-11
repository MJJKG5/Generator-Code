package com.kg.code.common.handle;

import com.kg.code.common.utils.PropertiesUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FreemarkerHandle {
    private static Configuration config;

    public FreemarkerHandle() {
        config = new Configuration(Configuration.getVersion());
    }

    /**
     * 配置模板引擎
     *
     * @return 模板引擎
     */
    public FreemarkerHandle config() {
        try {
            // 模板目录
            File file = file();
            // 加载模板
            config.setDirectoryForTemplateLoading(file);
            // 字符集
            config.setDefaultEncoding("UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    /**
     * 获取模板
     *
     * @return 模板列表
     */
    public List<Template> template() {
        List<Template> templates = new ArrayList<>();
        try {
            File[] files = file().listFiles();
            if (null != files) {
                for (File file : files) {
                    String name = file.getName();
                    Template template = config.getTemplate(name);
                    templates.add(template);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return templates;
    }

    /**
     * 获取配置
     *
     * @return 配置中心
     */
    public static Configuration getConfig() {
        return config;
    }

    /**
     * 获取模板目录
     *
     * @return 模板目录
     */
    private File file() {
        String directory = PropertiesUtils.properties("template").toString();
        URL url = FreemarkerHandle.class.getResource(directory);
        return new File(url.getFile());
    }
}
