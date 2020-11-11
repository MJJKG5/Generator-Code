package com.kg.code.common.utils;

public class ConvertUtils {
    /**
     * 首字母大写驼峰
     *
     * @param string 字符串
     * @return 格式：SysUser
     */
    public static String uppercaseHump(String string) {
        StringBuilder builder = new StringBuilder();
        String[] elements = string.split("_");
        for (String ele : elements) {
            char[] chars = ele.toCharArray();
            lowerCaseToUpperCase(builder, ele, chars);
        }
        return builder.toString();
    }

    /**
     * 首字母小写驼峰
     *
     * @param string 字符串
     * @return 格式：sysUser
     */
    public static String lowercaseHump(String string) {
        StringBuilder builder = new StringBuilder();
        String[] elements = string.split("_");
        // 记录下标(下标为0的字符串首字母小写，其它字符串首字母大写)
        int index = 0;
        for (String ele : elements) {
            char[] chars = ele.toCharArray();
            if (index == 0) {
                upperCaseToLowerCase(builder, ele, chars);
                index++;
            } else {
                lowerCaseToUpperCase(builder, ele, chars);
            }
        }
        return builder.toString();
    }

    /**
     * 首字母大写转小写
     *
     * @param builder 字符串
     * @param ele     字符
     * @param chars   字节
     */
    private static void upperCaseToLowerCase(StringBuilder builder, String ele, char[] chars) {
        if (Character.isUpperCase(chars[0])) {
            builder.append(Character.toLowerCase(chars[0]));
            int i = 1;
            while (i < chars.length) {
                builder.append(chars[i]);
                i++;
            }
        } else {
            builder.append(ele);
        }
    }

    /**
     * 首字母小写转大写
     *
     * @param builder 字符串
     * @param ele     字符
     * @param chars   字节
     */
    private static void lowerCaseToUpperCase(StringBuilder builder, String ele, char[] chars) {
        if (Character.isLowerCase(chars[0])) {
            builder.append(Character.toUpperCase(chars[0]));
            int i = 1;
            while (i < chars.length) {
                builder.append(chars[i]);
                i++;
            }
        } else {
            builder.append(ele);
        }
    }
}
