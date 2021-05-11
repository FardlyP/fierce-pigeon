package com.example.fiercepigeon.controller;

import com.example.fiercepigeon.common.Result;
import com.example.fiercepigeon.controller.base.BaseController;
import com.example.fiercepigeon.model.entity.Game;
import com.example.fiercepigeon.service.intf.GameService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author： FardlyP
 * @description： TODO
 * @date： 2021/3/13 12:45
 * @version: 1.0
 */
@Api(tags = "猛鸽球局管理")
@RestController
@RequestMapping("/game")
public class GameController extends BaseController {

    private GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @ApiOperation(value = "新增", notes = "新增")
    @PostMapping("/insert")
    public Result insert(@RequestBody Game game) {
        gameService.insertGame(game);
        return Result.success().msg("新增成功");
    }

    @ApiOperation(value = "详情", notes = "详情")
    @GetMapping("/findById")
    public Result findById(@RequestParam(value = "gameId") Integer id) {
        return Result.success().data(gameService.findById(id));
    }

    @ApiOperation(value = "删除", notes = "删除")
    @PostMapping("/deleteById/{id}")
    public Result deleteById(@PathVariable Integer id) {
        gameService.deleteById(id);
        return Result.success().msg("删除成功");
    }

    @ApiOperation(value = "修改", notes = "修改")
    @PostMapping("/update")
    public Result update(@RequestBody Game game) {
        gameService.updateGame(game);
        return Result.success().msg("修改成功");
    }

    @ApiOperation(value = "条件查找", notes = "条件查找")
    @PostMapping("/findByParam")
    public Result findByParam(@RequestBody Game param) {
        return Result.success().data(gameService.findByParam(param));
    }

    @ApiOperation(value = "球局列表", notes = "球局列表")
    @GetMapping("/listUndone")
    @ResponseBody
    public Result listUndone(@RequestParam String order) {
        return Result.success().data(gameService.listUndone(order));
    }

}
