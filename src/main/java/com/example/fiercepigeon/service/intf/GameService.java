package com.example.fiercepigeon.service.intf;

import com.example.fiercepigeon.base.ICommonService;
import com.example.fiercepigeon.model.entity.Game;

import java.util.ArrayList;

/**
 * @author： FardlyP
 * @description： TODO
 * @date： 2021/3/13 12:43
 * @version: 1.0
 */
public interface GameService extends ICommonService<Game, Integer> {

    ArrayList<Game> listUndone(String order);

    ArrayList<Game> findByParam(Game param);

    void insertGame(Game game);

    void updateGame(Game game);
}
