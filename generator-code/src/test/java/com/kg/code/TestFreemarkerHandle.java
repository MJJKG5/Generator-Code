package com.kg.code;

import com.kg.code.common.handle.FreemarkerHandle;
import org.junit.Test;

public class TestFreemarkerHandle {
    @Test
    public void config() {
        new FreemarkerHandle();
    }

    @Test
    public void createTemplate() {
        new FreemarkerHandle()
                .config()
                .template()
                .forEach(template -> System.out.println(template.getName()));
    }
}
