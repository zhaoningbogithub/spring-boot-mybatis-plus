package cn.lsz.example.utils;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.Properties;

/**
 * description
 * 
 * @author LSZ 2019/10/17 10:47
 * @contact 648748030@qq.com
 */
public class YmlPropertiesUtil {

    static Resource resource = null;
    static Properties properties = null;

    public static String get(String name){
        if(resource == null){
            resource = new ClassPathResource("application.yml");
            YamlPropertiesFactoryBean yamlFactory = new YamlPropertiesFactoryBean();
            yamlFactory.setResources(resource);
            properties =  yamlFactory.getObject();
        }
       return properties.getProperty(name);
    }

}
