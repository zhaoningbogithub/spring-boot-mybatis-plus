package cn.lsz.example;

import cn.lsz.example.dataOperate.dto.Department;
import cn.lsz.example.dataOperate.mapper.DepartmentMapper;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	DepartmentMapper departmentMapper;

	@Test
	public void contextLoads() {
		Department department = new Department("研发部");
		/*
		* 通用mapper插入有值的列insertSelective
		* */
		departmentMapper.insertSelective(department);
		System.out.println("通用mappper插入数据id："+department.getId());
		/*
		* 引入通用mappper不影响自定义sql使用
		* */
		System.out.println("自定义sql查询结果："+departmentMapper.getDepById(department.getId()).getDepartmentName());
		/*
		* 使用分页插件分页，可以通过控制器日志发现sql语句加上了分页
		* */
		PageHelper.startPage(1,20);
		System.out.println("使用分页插件sql查询结果："+departmentMapper.getDepById(department.getId()).getDepartmentName());


	}

}
