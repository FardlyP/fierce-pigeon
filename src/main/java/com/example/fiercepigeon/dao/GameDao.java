package com.example.fiercepigeon.dao;

import com.example.fiercepigeon.base.ICommonDao;
import com.example.fiercepigeon.model.entity.Game;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * @author： FardlyP
 * @description： TODO
 * @date： 2021/3/13 12:40
 * @version: 1.0
 */
@Repository
public interface GameDao extends ICommonDao<Game> {

    ArrayList<Game> listUndone(String order);

    ArrayList<Game> findByParam(Game param);
}
