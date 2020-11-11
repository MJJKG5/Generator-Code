package ${packageName}.controller;

import ${packageName}.model.${className};
import ${packageName}.model.entity.ResApi;
import ${packageName}.service.${className}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api")
public class ${className}Controller {
    @Autowired
    private ${className}Service ${referenceName}Service;

    /**
     * 查询${tableComment}
     *
     * @param pageNo   页码
     * @param pageSize 页大小
     * @return
     */
    @RequestMapping(value = "${referenceName}", method = RequestMethod.GET)
    public ResApi<Map<String, Object>> query${className}(@RequestParam Integer pageNo, @RequestParam Integer pageSize) {
        return ${referenceName}Service.query${className}(pageNo, pageSize);
    }

    /**
     * 添加${tableComment}
     *
     * @param ${referenceName} ${tableComment}
     * @return
     */
    @RequestMapping(value = "${referenceName}", method = RequestMethod.POST)
    public ResApi<String> add${className}(@RequestBody ${className} ${referenceName}) {
        return ${referenceName}Service.add${className}(${referenceName});
    }

    /**
     * 修改${tableComment}
     *
     * @param ${referenceName} ${tableComment}
     * @return
     */
    @RequestMapping(value = "${referenceName}", method = RequestMethod.PUT)
    public ResApi<String> update${className}(@RequestBody ${className} ${referenceName}) {
        return ${referenceName}Service.update${className}(${referenceName});
    }

    /**
     * 删除${tableComment}
     *
     * @param id ${tableComment}id
     * @return
     */
    @RequestMapping(value = "${referenceName}", method = RequestMethod.DELETE)
    public ResApi<String> delete${className}(@RequestParam Long id) {
        return ${referenceName}Service.delete${className}(id);
    }
}
