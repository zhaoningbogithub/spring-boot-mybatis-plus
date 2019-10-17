package ${package.Entity};

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * ${table.comment!}
 * @author ${author}
 * @since ${date}
 */
@Data
@TableName("${table.name}")
public class ${entity} {

<#-- ----------  BEGIN 字段循环遍历  ---------->
<#if entityColumnConstant>
<#-- 常量 -->
    <#list table.fields as field>
    public static final String ${field.name?upper_case} = "${field.propertyName}";
    </#list>
</#if>

<#list table.fields as field>
    <#if field.keyFlag>
        <#assign keyPropertyName="${field.propertyName}"/>
    </#if>
    <#if field.comment!?length gt 0>
        <#if swagger2>
    @ApiModelProperty(value = "${field.comment}")
        <#else>
    /**
     * ${field.comment}
     */
        </#if>
    </#if>
    <#if field.keyFlag>
     <#-- 主键 -->
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    </#if>
    <#-- 乐观锁注解 -->
    <#if (versionFieldName!"") == field.name>
    @Version
    </#if>
    private ${field.propertyType} ${field.propertyName};

</#list>
<#------------  END 字段循环遍历  ---------->
}
