package cn.lsz.example.test.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * 
 * @author Mybatis Plus Generator
 * @since 2019-10-17
 */
@Data
@TableName("employee")
public class Employee {

    public static final String ID = "id";
    public static final String LAST_NAME = "lastName";
    public static final String GENDER = "gender";
    public static final String EMAIL = "email";
    public static final String DID = "did";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String lastName;

    private Integer gender;

    private String email;

    private Integer did;

}
