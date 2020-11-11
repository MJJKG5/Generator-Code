package ${packageName}.model;

import java.io.Serializable;

public class ${className} implements Serializable {
    private static final long serialVersionUID = 1L;
<#list attributes as attribute>
    /**
     * ${attribute.comment}
     */
    private ${attribute.type} ${attribute.name};
</#list>
<#list attributes as attribute>

    public ${attribute.type} get${attribute.methodName}() {
        return ${attribute.name};
    }

    public void set${attribute.methodName}(${attribute.type} ${attribute.name}) {
        this.${attribute.name} = ${attribute.name};
    }
</#list>
}
