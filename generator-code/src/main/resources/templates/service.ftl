package ${packageName}.service;

import ${packageName}.model.${className};
import ${packageName}.model.entity.ResApi;

import java.util.Map;

public interface ${className}Service {
    /**
     * 查询${tableComment}
     *
     * @param pageNo   页码
     * @param pageSize 页大小
     * @return
     */
    ResApi<Map<String, Object>> query${className}(Integer pageNo, Integer pageSize);

    /**
     * 添加${tableComment}
     *
     * @param ${referenceName} ${tableComment}
     * @return
     */
    ResApi<String> add${className}(${className} ${referenceName});

    /**
     * 修改${tableComment}
     *
     * @param ${referenceName} ${tableComment}
     * @return
     */
    ResApi<String> update${className}(${className} ${referenceName});

    /**
     * 删除${tableComment}
     *
     * @param id ${tableComment}id
     * @return
     */
    ResApi<String> delete${className}(Long id);
}
