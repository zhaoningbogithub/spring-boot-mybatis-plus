package cn.lsz.example.dataOperate.dto;

import lombok.Data;
import tk.mybatis.mapper.annotation.Version;

import javax.persistence.*;

@Data
public class Department {

    /*
    * @Id：通用mapper中***ByPrimaryKey()函数Primarykey标识
    * @GeneratedValue插入后返回id
    * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /*
    * @Column：示例用法可以将bean属性名otherDepartmentName映射到数据库字段名department_name，
    * 其他字段默认使用驼峰命名法,如departmentName可以默认匹配
    * */
    @Column(name="department_name")
    private String otherDepartmentName;

    private String departmentName;

    /*
    * @Transient：标识该字段不属于数据库字段，通用mapper操作不会带上这个字段
    * */
    @Transient
    private String testDepartmentName;

    /*
    * @Version：使用乐观锁，版本号字段
    * */
    @Version
    private Integer version;


    public Department(String departmentName) {
        this.departmentName = departmentName;
    }
}
