package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import org.springframework.stereotype.Service;

/**
 * ${table.comment!} 服务实现类
 * @author mybatisPlus generator
 * @since ${date}
 */
@Service
public class ${table.serviceImplName} extends ${superServiceImplClass}<${entity}> implements ${table.serviceName} {

}

