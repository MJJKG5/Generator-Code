package ${packageName}.service.impl;

import ${packageName}.model.${className};
import ${packageName}.model.entity.ResApi;
import ${packageName}.repository.${className}Mapper;
import ${packageName}.service.${className}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("${referenceName}Service")
public class ${className}ServiceImpl implements ${className}Service {
    @Autowired
    private ${className}Mapper ${referenceName}Mapper;

    /**
     * 查询${tableComment}
     *
     * @param pageNo   页码
     * @param pageSize 页大小
     * @return
     */
    @Override
    public ResApi<Map<String, Object>> query${className}(Integer pageNo, Integer pageSize) {
        return new ResApi<>();
    }

    /**
     * 添加${tableComment}
     *
     * @param ${referenceName} ${tableComment}
     * @return
     */
    @Override
    public ResApi<String> add${className}(${className} ${referenceName}) {
        return new ResApi<>();
    }

    /**
     * 修改${tableComment}
     *
     * @param ${referenceName} ${tableComment}
     * @return
     */
    @Override
    public ResApi<String> update${className}(${className} ${referenceName}) {
        return new ResApi<>();
    }

    /**
     * 删除${tableComment}
     *
     * @param id ${tableComment}id
     * @return
     */
    @Override
    public ResApi<String> delete${className}(Long id) {
        return new ResApi<>();
    }
}
