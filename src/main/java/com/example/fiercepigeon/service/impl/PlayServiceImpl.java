package com.example.fiercepigeon.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.example.fiercepigeon.base.AbsCommonService;
import com.example.fiercepigeon.base.ICommonDao;
import com.example.fiercepigeon.dao.PlayDao;
import com.example.fiercepigeon.model.entity.Game;
import com.example.fiercepigeon.model.entity.Play;
import com.example.fiercepigeon.model.vo.Player;
import com.example.fiercepigeon.model.vo.UserData;
import com.example.fiercepigeon.service.intf.GameService;
import com.example.fiercepigeon.service.intf.PlayService;
import com.example.fiercepigeon.service.intf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * @author： FardlyP
 * @description： TODO
 * @date： 2021/3/13 14:10
 * @version: 1.0
 */
@Service
public class PlayServiceImpl extends AbsCommonService<Play, Integer> implements PlayService {

    private PlayDao playDao;

    private UserService userService;

    private GameService gameService;

    @Autowired
    public PlayServiceImpl(PlayDao playDao, UserService userService, GameService gameService) {
        this.playDao = playDao;
        this.userService = userService;
        this.gameService = gameService;
    }

    @Override
    protected ICommonDao<Play> getDao() {
        return playDao;
    }

    @Override
    public ArrayList<Play> findByParam(Play param) {
        return playDao.findByParam(param);
    }

    @Override
    public Boolean check(Play play) {
        ArrayList<Play> list = findByParam(play);
        if (list.size() == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public ArrayList<Player> listPlayer(Integer gameId) {
        Play param = new Play();
        param.setGameId(gameId);
        param.setDeleted(0);
        ArrayList<Play> playList = findByParam(param);
        ArrayList<Player> players = new ArrayList<>(playList.size());
        for (Play play : playList) {
            String openId = play.getOpenId();
            String nickname = userService.getUserByOpenId(openId).getNickname();
            Player player = new Player();
            BeanUtil.copyProperties(play, player, CopyOptions.create().setIgnoreNullValue(true));
            player.setNickname(nickname);
            player.setZanImg("/images/赞.png");
            player.setYouImg("/images/加油.png");
            players.add(player);
        }
        return players;
    }

    @Override
    public Integer countPlayed(String openId, Integer deleted) {
        return playDao.countPlayed(openId, deleted);
    }

    @Override
    public UserData getUserData(String openId) {
        UserData userData = new UserData();
        Integer playedCnt = countPlayed(openId, 0);
        userData.setPlayedCnt(playedCnt);
        Integer gedCnt = countPlayed(openId, 1);
        userData.setGedCnt(gedCnt);
        Integer totalCnt = playedCnt + gedCnt;
        userData.setTotalCnt(totalCnt);
        if (totalCnt == 0) {
            userData.setGeRate(0.0);
        } else {
            double f = 1.0 / totalCnt * gedCnt;
            BigDecimal b = new BigDecimal(f);
            double f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            userData.setGeRate(f1);
        }
        return userData;
    }

    @Override
    public ArrayList<Game> getHistory(Play param, Integer done) {
        ArrayList<Game> result = new ArrayList<>();
        ArrayList<Play> playList = findByParam(param);
        if (playList.size() == 0) {
            return result;
        }
        for (Play play : playList) {
            Game game = gameService.findById(play.getGameId());
            if (!result.contains(game) && game != null) {
                if (done == null || (done != null && game.getDone() == done)) {
                    result.add(game);
                }
            }
        }
        return result;
    }
}
