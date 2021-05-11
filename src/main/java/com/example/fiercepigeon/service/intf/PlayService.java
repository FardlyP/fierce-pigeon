package com.example.fiercepigeon.service.intf;

import com.example.fiercepigeon.base.ICommonService;
import com.example.fiercepigeon.model.entity.Game;
import com.example.fiercepigeon.model.entity.Play;
import com.example.fiercepigeon.model.vo.Player;
import com.example.fiercepigeon.model.vo.UserData;

import java.util.ArrayList;

/**
 * @author： FardlyP
 * @description： TODO
 * @date： 2021/3/13 14:09
 * @version: 1.0
 */
public interface PlayService extends ICommonService<Play, Integer> {

    ArrayList<Play> findByParam(Play param);

    Integer countPlayed(String openId, Integer deleted);

    UserData getUserData(String openId);

    Boolean check(Play play);

    ArrayList<Player> listPlayer(Integer gameId);

    ArrayList<Game> getHistory(Play param, Integer done);

}
