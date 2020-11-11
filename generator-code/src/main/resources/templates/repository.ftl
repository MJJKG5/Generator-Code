package ${packageName}.repository;

import ${packageName}.model.${className};
import ${packageName}.model.entity.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ${className}Mapper {
    /**
     * 查询
     *
     * @param page 分页
     * @return
     */
    List<${className}> queryByList(@Param("page") Page page);

    /**
     * 添加
     *
     * @param ${referenceName} ${tableComment}
     */
    void add(@Param("${referenceName}") ${className} ${referenceName});

    /**
     * 修改
     *
     * @param ${referenceName} ${tableComment}
     */
    void update(@Param("${referenceName}") ${className} ${referenceName});

    /**
     * 删除
     *
     * @param id ${tableComment}id
     */
    void delete(Long id);

    /**
     * 查询数量
     *
     * @return
     */
    Long count();
}
