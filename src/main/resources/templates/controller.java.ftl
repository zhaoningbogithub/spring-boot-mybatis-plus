package ${package.Controller};

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};

/**
 * ${table.comment!} 前端控制器
 * @author mybatisPlus generator
 * @since ${date}
 */

@RestController
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
public class ${table.controllerName} {

  @Autowired
  private ${table.serviceName} service;


  @RequestMapping(value = "/query")
  @ResponseBody
  public List<${entity}> query(@RequestBody ${entity} dto, @RequestParam(defaultValue = "1") int page,
     @RequestParam(defaultValue = "10") int pageSize, HttpServletRequest request) {
     return service.select(dto,page,pageSize);
   }

   @RequestMapping(value = "/insert")
   @ResponseBody
     public ${entity} insert(@RequestBody ${entity} dto, HttpServletRequest request){
     return  service.insert(dto);
   }

   @RequestMapping(value = "/update")
   @ResponseBody
   public ${entity} update(@RequestBody ${entity} dto, HttpServletRequest request){
     return  service.updateByPrimaryKeySelective(dto);
   }

   @RequestMapping(value = "/delete")
   @ResponseBody
   public void delete(@RequestBody ${entity} dto, HttpServletRequest request){
     service.deleteByPrimaryKey(dto);
   }

}

