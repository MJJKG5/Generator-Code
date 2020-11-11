package com.kg.code.service.impl;

import com.kg.code.common.handle.ConnectionHandle;
import com.kg.code.common.handle.FreemarkerHandle;
import com.kg.code.common.mapper.ColumnMapper;
import com.kg.code.common.mapper.TableMapper;
import com.kg.code.common.utils.ConvertUtils;
import com.kg.code.common.utils.PropertiesUtils;
import com.kg.code.model.Attribute;
import com.kg.code.model.Column;
import com.kg.code.model.Entity;
import com.kg.code.model.Table;
import com.kg.code.service.Generator;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class MysqlGenerator implements Generator {
    /**
     * 生成代码
     */
    @Override
    public void generatorCode() {
        try {
            // 配置模板引擎
            FreemarkerHandle freemarker = new FreemarkerHandle().config();
            // 查询表
            List<Table> tables = new TableMapper().queryTable();
            tables.forEach(table -> {
                // 获取模板
                List<Template> templates = freemarker.template();
                // 获取实体
                Entity entity = getEntity(table);
                // 执行
                execute(templates, entity);
            });
        } finally {
            ConnectionHandle.close();
        }
    }

    /**
     * 获取实体
     *
     * @param table 表
     * @return
     */
    private Entity getEntity(Table table) {
        // 查询列
        List<Column> columns = new ColumnMapper().queryColumn(table.getTableName());
        // 获取类属性
        List<Attribute> attributes = new ArrayList<>();
        columns.forEach(column -> {
            Attribute attribute = new Attribute();
            // 类型
            attribute.setType(type(column.getDataType()));
            // 属性名
            attribute.setName(ConvertUtils.lowercaseHump(column.getColumnName()));
            // 方法名
            attribute.setMethodName(ConvertUtils.uppercaseHump(column.getColumnName()));
            // 列名
            attribute.setColumnName(column.getColumnName());
            // 主键
            attribute.setPrimaryKey(column.getColumnKey());
            // 自增
            attribute.setExtra(column.getExtra());
            // 备注
            attribute.setComment(column.getColumnComment());
            attributes.add(attribute);
        });
        // 实体类
        Entity entity = new Entity();
        // 包名
        entity.setPackageName(PropertiesUtils.properties("package").toString());
        // 表名
        entity.setTableName(table.getTableName());
        // 类名
        entity.setClassName(ConvertUtils.uppercaseHump(table.getTableName()));
        // 引用名
        entity.setReferenceName(ConvertUtils.lowercaseHump(table.getTableName()));
        // 表备注
        entity.setTableComment(table.getTableComment());
        // 属性
        entity.setAttributes(attributes);

        return entity;
    }

    /**
     * 执行
     *
     * @param templates 模板
     * @param entity    实体
     */
    private void execute(List<Template> templates, Entity entity) {
        // 获取目录
        String directory = PropertiesUtils.properties("directory").toString();
        templates.forEach(template -> {
            switch (template.getName()) {
                case "model.ftl":
                    check(directory + "model/");
                    generatorCode(template, entity, directory + "model/" + entity.getClassName() + ".java");
                    break;
                case "repository.ftl":
                    check(directory + "repository/");
                    generatorCode(template, entity, directory + "repository/" + entity.getClassName() + "Mapper.java");
                    break;
                case "mapper.ftl":
                    check(directory + "mapper/");
                    generatorCode(template, entity, directory + "mapper/" + entity.getClassName() + "Mapper.xml");
                    break;
                case "service.ftl":
                    check(directory + "service/");
                    generatorCode(template, entity, directory + "service/" + entity.getClassName() + "Service.java");
                    break;
                case "impl.ftl":
                    check(directory + "service/impl/");
                    generatorCode(template, entity, directory + "service/impl/" + entity.getClassName() + "ServiceImpl.java");
                    break;
                case "controller.ftl":
                    check(directory + "controller/");
                    generatorCode(template, entity, directory + "controller/" + entity.getClassName() + "Controller.java");
                    break;
            }
        });
    }

    /**
     * 生成代码
     *
     * @param template 模板
     * @param entity   实体
     * @param file     文件
     */
    private void generatorCode(Template template, Entity entity, String file) {
        Writer writer = null;
        try {
            writer = new FileWriter(file);
            template.process(entity, writer);
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != writer) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 属性类型
     *
     * @param type 列类型
     * @return String
     */
    private String type(String type) {
        switch (type) {
            case "id":
            case "bigint":
            case "integer":
                return "Long";
            case "set":
            case "char":
            case "text":
            case "enum":
            case "varchar":
            case "tinytext":
                return "String";
            case "int":
            case "tinyint":
            case "mediumint":
                return "Integer";
            case "bit":
                return "Boolean";
            case "year":
            case "date":
            case "time":
            case "datetime":
            case "timestamp":
                return "Date";
            case "numeric":
            case "decimal":
                return "BigDecimal";
            case "real":
            case "double":
                return "Double";
            case "float":
                return "Float";
            case "smallint":
                return "Short";
            case "blob":
            case "binary":
            case "tinyblob":
            case "longblob":
            case "varbinary":
            case "mediumblob":
                return "byte[]";
            default:
                return null;
        }
    }

    /**
     * 检测目录
     *
     * @param directory 目录
     */
    public void check(String directory) {
        // 验证目录(不存在就创建)
        File file = new File(directory);
        if (!file.exists()) {
            file.mkdirs();
        }
    }
}
