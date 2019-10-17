package core.service.impl;

import com.github.pagehelper.PageHelper;
import core.exception.RowVersionException;
import core.mapper.BaseMapper;
import core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 通用mapper还有很多api，目前先做了这些常用的
 * 
 * @author LSZ 2019/10/17 11:58
 * @contact 648748030@qq.com
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    protected BaseMapper<T> mapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<T> select(T condition, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return mapper.select(condition);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public T insert(T record) {
        mapper.insert(record);
        return record;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public T insertSelective(T record) {
        mapper.insertSelective(record);
        return record;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public T updateByPrimaryKey(T record) {
        int ret = mapper.updateByPrimaryKey(record);
        checkVersion(ret);
        return record;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public T updateByPrimaryKeySelective(T record) {
        int ret = mapper.updateByPrimaryKeySelective(record);
        checkVersion(ret);
        return record;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public T selectByPrimaryKey(T record) {
        return mapper.selectByPrimaryKey(record);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByPrimaryKey(T record) {
        int ret = mapper.deleteByPrimaryKey(record);
        checkVersion(ret);
        return ret;
    }


    @Override
    @Deprecated
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<T> selectAll() {
        return mapper.selectAll();
    }

    private void checkVersion(int rowVersionNum){
        if(rowVersionNum ==0){
            throw new RuntimeException(new RowVersionException("数据版本号不一致"));
        }
    }

}
