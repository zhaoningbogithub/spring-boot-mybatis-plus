package cn.lsz.example.dataOperate.mapper;

import cn.lsz.example.dataOperate.dto.Department;
import core.mapper.BaseMapper;


public interface DepartmentMapper extends BaseMapper<Department> {

    void insertDep(Department department);

    Department getDepById(int id);

}
