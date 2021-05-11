package com.example.fiercepigeon.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import com.alibaba.fastjson.JSON;
import com.example.fiercepigeon.common.Result;
import com.example.fiercepigeon.controller.base.BaseController;
import com.example.fiercepigeon.model.entity.Play;
import com.example.fiercepigeon.model.vo.GameHisVo;
import com.example.fiercepigeon.service.intf.PlayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * @author： FardlyP
 * @description： TODO
 * @date： 2021/3/13 14:16
 * @version: 1.0
 */
@Api(tags = "猛鸽报名管理")
@RestController
@RequestMapping("/play")
public class PlayController extends BaseController {

    private PlayService playService;

    @Autowired
    public PlayController(PlayService playService) {
        this.playService = playService;
    }

    @ApiOperation(value = "新增", notes = "新增")
    @PostMapping("/insert")
    public Result insert(@RequestBody Play play) {

        play.setUpdateTime(LocalDateTime.now());
        play.setCreateTime(LocalDateTime.now());
        play.setDeleted(0);
        play.setZanCnt(0);
        play.setYouCnt(0);
        playService.insert(play);
        return Result.success().msg("新增成功");
    }

    @ApiOperation(value = "删除", notes = "删除")
    @PostMapping("/delete")
    public Result delete(@RequestBody Play play) {
        play.setDeleted(0);
        Play tmpPlay = playService.findByParam(play).get(0);
        tmpPlay.setDeleted(1);
        tmpPlay.setUpdateTime(LocalDateTime.now());
        playService.update(tmpPlay);
        return Result.success().msg("修改成功");
    }

    @ApiOperation(value = "修改", notes = "修改")
    @PostMapping("/update")
    public Result update(@RequestBody Play play) {
        Play param = new Play();
        param.setDeleted(0);
        param.setGameId(play.getGameId());
        param.setOpenId(play.getOpenId());
        Play tmpPlay = playService.findByParam(param).get(0);
        BeanUtil.copyProperties(play, tmpPlay, CopyOptions.create().setIgnoreNullValue(true));
        tmpPlay.setUpdateTime(LocalDateTime.now());
        playService.update(tmpPlay);
        return Result.success().msg("修改成功");
    }

    @ApiOperation(value = "查重", notes = "查重")
    @PostMapping("/check")
    public Result check(@RequestBody Play play) {
        return Result.success().data(playService.check(play));
    }

    @ApiOperation(value = "用户数据统计", notes = "用户数据统计")
    @GetMapping("/statistic")
    public Result getUserData(@RequestParam(value = "openId") String openId) {
        return Result.success().data(playService.getUserData(openId));
    }

    @ApiOperation(value = "条件查询", notes = "条件查询")
    @PostMapping("/findByParam")
    @ResponseBody
    public Result findByParam(@RequestBody Play param) {
        return Result.success().data(playService.findByParam(param));
    }

    @ApiOperation(value = "成员列表", notes = "成员列表")
    @GetMapping("/listPlayer")
    @ResponseBody
    public Result listPlayer(@RequestParam(value = "gameId") Integer gameId) {
        return Result.success().data(playService.listPlayer(gameId));
    }

    @ApiOperation(value = "历史球局", notes = "历史球局")
    @GetMapping("/gameHistory")
    @ResponseBody
    public Result getHistory(String str) {
        System.out.println(str);
        GameHisVo gameHisVo = JSON.parseObject(str, GameHisVo.class);
        Play param = gameHisVo.getParam();
        Integer done = gameHisVo.getDone();
        return Result.success().data(playService.getHistory(param, done));
    }
}
