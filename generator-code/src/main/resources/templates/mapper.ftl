<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${packageName}.repository.${className}Mapper">
    <resultMap id="${referenceName}Map" type="${packageName}.model.${className}">
<#list attributes as attribute>
    <#if attribute.primaryKey != "">
        <id column="${attribute.columnName}" property="${attribute.name}"/>
    <#else>
        <result column="${attribute.name}" property="${attribute.columnName}"/>
    </#if>
</#list>
    </resultMap>

    <sql id="${referenceName}List"><#list attributes as attribute>${attribute.columnName}<#if attribute_has_next == true>, </#if></#list></sql>

    <sql id="${referenceName}Where">
        <where>
    <#list attributes as attribute>
        <#if attribute.type == "String">
            <if test="null != ${attribute.name} and '' != ${attribute.name}">
                <#if attribute_has_next == true>AND</#if> ${attribute.columnName} = ${"#"}{${attribute.name}}
            </if>
        <#else>
            <if test="null != ${attribute.name}">
                <#if attribute_has_next == true>AND</#if> ${attribute.columnName} = ${"#"}{${attribute.name}}
            </if>
        </#if>
    </#list>
        </where>
    </sql>

    <select id="queryByList" resultMap="${referenceName}Map">
        SELECT
            <include refid="${referenceName}List"/>
        FROM
            ${tableName}
        LIMIT
            ${"#"}{page.index}, ${"#"}{page.pageSize}
    </select>

    <insert id="add" useGeneratedKeys="true" keyProperty="id">
        INSERT INTO ${tableName}
            (<#list attributes as attribute><#if attribute.extra != "auto_increment">${attribute.columnName}<#if attribute_has_next == true>, </#if></#if></#list>)
        VALUES
            (<#list attributes as attribute><#if attribute.extra != "auto_increment">${"#"}{${referenceName}.${attribute.name}}<#if attribute_has_next == true>, </#if></#if></#list>)
    </insert>

    <update id="update">
        UPDATE ${tableName}
        <set>
    <#list attributes as attribute>
        <#if attribute.type == "String">
            <if test="null != ${referenceName}.${attribute.name} and '' != ${referenceName}.${attribute.name}">
                ${attribute.columnName} = ${"#"}{${referenceName}.${attribute.name}}<#if attribute_has_next == true>,</#if>
            </if>
        <#else>
            <if test="null != ${referenceName}.${attribute.name}">
                ${attribute.columnName} = ${"#"}{${referenceName}.${attribute.name}}<#if attribute_has_next == true>,</#if>
            </if>
        </#if>
    </#list>
        </set>
        WHERE
            id = ${"#"}{${referenceName}.id}
    </update>

    <delete id="delete">
        DELETE FROM ${tableName} WHERE id = ${"#"}{id}
    </delete>

    <select id="count" resultType="java.lang.Long">
        SELECT COUNT(id) FROM ${tableName}
    </select>
</mapper>