package core.service;

import java.util.List;

/**
 * 通用mapper还有很多api，目前先做了这些常用的
 * 
 * @author LSZ 2019/10/17 11:57
 * @contact 648748030@qq.com
 */
public interface BaseService<T>{

    List<T> select(T condition, int pageNum, int pageSize);

    T insert(T record);

    T insertSelective(T record);

    T updateByPrimaryKey(T record);

    T updateByPrimaryKeySelective(T record);

    T selectByPrimaryKey(T record);

    int deleteByPrimaryKey(T record);

    List<T> selectAll();



}
