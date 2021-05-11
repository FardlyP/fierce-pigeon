package com.example.fiercepigeon.base;

import tk.mybatis.mapper.common.Mapper;

/**
 * description <dao层统一封装>
 * 所有dao都要继承这个BaseDao
 * 继承Mapper,如有需要，继续继承InsertListMapper,IdsMapper等
 *
 * @author yanbiao6
 * @create 2020/4/21
 * @since 1.0.0
 */
public interface ICommonDao<T> extends Mapper<T> {

}
