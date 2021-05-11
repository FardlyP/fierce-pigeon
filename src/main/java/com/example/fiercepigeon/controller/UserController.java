package com.example.fiercepigeon.controller;

import com.example.fiercepigeon.common.Result;
import com.example.fiercepigeon.controller.base.BaseController;
import com.example.fiercepigeon.model.entity.User;
import com.example.fiercepigeon.service.intf.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * @author： FardlyP
 * @description： TODO
 * @date： 2021/3/12 16:49
 * @version: 1.0
 */
@Api(tags = "猛鸽用户管理")
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "获取WinXinJson", notes = "获取WinXinJson")
    @GetMapping("/getCode")
    @ResponseBody
    public Result getWinXinJson(@RequestParam(value = "code") String jsCode) {
        System.out.println(jsCode);
        return Result.success().data(userService.getWinXinJson(jsCode));
    }

    @ApiOperation(value = "登录", notes = "登录")
    @PostMapping("/login")
    @ResponseBody
    public Result doLogin(@RequestBody User user) throws Exception {

        User tmpUser = userService.getUserByOpenId(user.getOpenId());

        //存在，登录
        if (tmpUser != null) {
            return Result.success().data(userService.doLogin(user));
        } else {
            // 不存在，注册
            user.setCreateTime(LocalDateTime.now());
            userService.addWeiXinUser(user);
            return Result.success().msg("注册成功");
        }
    }

}
