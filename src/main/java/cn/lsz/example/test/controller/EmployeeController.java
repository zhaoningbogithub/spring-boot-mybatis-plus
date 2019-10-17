package cn.lsz.example.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import cn.lsz.example.test.dto.Employee;
import cn.lsz.example.test.service.IEmployeeService;

/**
 *  前端控制器
 * @author mybatisPlus generator
 * @since 2019-10-17
 */

@RestController
@RequestMapping("/test/employee")
public class EmployeeController {

  @Autowired
  private IEmployeeService service;


  @RequestMapping(value = "/query")
  @ResponseBody
  public List<Employee> query(@RequestBody Employee dto, @RequestParam(defaultValue = "1") int page,
     @RequestParam(defaultValue = "10") int pageSize, HttpServletRequest request) {
     return service.select(dto,page,pageSize);
   }

   @RequestMapping(value = "/insert")
   @ResponseBody
     public Employee insert(@RequestBody Employee dto, HttpServletRequest request){
     return  service.insert(dto);
   }

   @RequestMapping(value = "/update")
   @ResponseBody
   public Employee update(@RequestBody Employee dto, HttpServletRequest request){
     return  service.updateByPrimaryKeySelective(dto);
   }

   @RequestMapping(value = "/delete")
   @ResponseBody
   public void delete(@RequestBody Employee dto, HttpServletRequest request){
     service.deleteByPrimaryKey(dto);
   }

}

