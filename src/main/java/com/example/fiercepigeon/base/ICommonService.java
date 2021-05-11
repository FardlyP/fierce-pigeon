package com.example.fiercepigeon.base;

import tk.mybatis.mapper.entity.Example;

import java.util.List;

public interface ICommonService<T, K> {

    /**
     * 即使有字段为null也在插入语句中
     */
    int insert(T t);

    /**
     * 插入语句只含有值的字段
     */
    //insertSelective(T t)

    /**
     * 批量插入，按需
     * @return
     */
//    void insertList(List<T> list);

    int update(T t);

    void deleteById(K id);

    /**
     * 批量删除，按需
     */
//    void deleteByIds(String ids);

    void delete(T t);

    T findById(K id);

    List<T> getAll();

    /**
     * 按需开启
     */
//    List<T> findByIds(String ids);

    List<T> searchByExample(Example example);

    /**
     * 根据条件查找,按需
     */
//    List<T> findByCondition(Condition condition);

}
