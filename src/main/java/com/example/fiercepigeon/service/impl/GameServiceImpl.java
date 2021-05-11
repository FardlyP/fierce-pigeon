package com.example.fiercepigeon.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.example.fiercepigeon.base.AbsCommonService;
import com.example.fiercepigeon.base.ICommonDao;
import com.example.fiercepigeon.dao.GameDao;
import com.example.fiercepigeon.model.entity.Game;
import com.example.fiercepigeon.service.intf.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author： FardlyP
 * @description： TODO
 * @date： 2021/3/13 12:44
 * @version: 1.0
 */
@Service
public class GameServiceImpl extends AbsCommonService<Game, Integer> implements GameService {

    private GameDao gameDao;

    @Autowired
    public GameServiceImpl(GameDao gameDao) {
        this.gameDao = gameDao;
    }

    @Override
    protected ICommonDao<Game> getDao() {
        return gameDao;
    }


    @Override
    public void insertGame(Game game) {
        if (game.getDeclaration() == "") {
            game.setDeclaration("猛男球局，鸽不再来！");
        }
        game.setDone(0);
        game.setNum(0);
        game.setCreateTime(LocalDateTime.now());
        game.setUpdateTime(LocalDateTime.now());
        insert(game);
        return;
    }

    @Override
    public void updateGame(Game game) {
        Game game1 = findById(game.getId());
        BeanUtil.copyProperties(game, game1, CopyOptions.create().setIgnoreNullValue(true));
        game.setUpdateTime(LocalDateTime.now());
        update(game1);
        return;
    }

    @Override
    public ArrayList<Game> listUndone(String order) {
        ArrayList<Game> games = gameDao.listUndone(order);
        ArrayList<Game> ret = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String today = sdf.format(new Date());
        for (Game game : games) {
            String gameDate = sdf.format(game.getDate());
            if (gameDate.compareTo(today) < 0) {
                game.setDone(1);
                update(game);
            } else {
                ret.add(game);
            }
        }
        return ret;
    }

    @Override
    public ArrayList<Game> findByParam(Game param) {
        return gameDao.findByParam(param);
    }

}
