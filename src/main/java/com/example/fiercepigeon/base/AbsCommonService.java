package com.example.fiercepigeon.base;

import tk.mybatis.mapper.entity.Example;

import java.util.Collections;
import java.util.List;

public abstract class AbsCommonService<T, K> implements ICommonService<T, K> {

    protected abstract ICommonDao<T> getDao();

    @Override
    public int insert(T t) {
        return getDao().insert(t);
    }

    @Override
    public int update(T t) {
        return getDao().updateByPrimaryKey(t);
    }

    @Override
    public void deleteById(K id) {
        getDao().deleteByPrimaryKey(id);
    }

    @Override
    public void delete(T t) {
        getDao().delete(t);
    }

    @Override
    public T findById(K id) {
        return getDao().selectByPrimaryKey(id);
    }

    @Override
    public List<T> getAll() {
        return getDao().selectAll();
    }

    /**
     * 条件查询由实现类自行实现，否则默认返回空列表
     */
    @Override
    public List<T> searchByExample(Example example) {
        return Collections.emptyList();
    }

}
