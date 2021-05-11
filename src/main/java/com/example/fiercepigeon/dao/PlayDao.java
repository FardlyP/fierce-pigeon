package com.example.fiercepigeon.dao;

import com.example.fiercepigeon.base.ICommonDao;
import com.example.fiercepigeon.model.entity.Play;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * @author： FardlyP
 * @description： TODO
 * @date： 2021/3/13 14:08
 * @version: 1.0
 */
@Repository
public interface PlayDao extends ICommonDao<Play> {

    ArrayList<Play> findByParam(Play param);

    Integer countPlayed(@Param("openId") String openId, @Param("deleted") Integer deleted);

}
