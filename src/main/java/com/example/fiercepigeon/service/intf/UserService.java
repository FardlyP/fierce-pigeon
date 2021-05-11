package com.example.fiercepigeon.service.intf;

import com.example.fiercepigeon.base.ICommonService;
import com.example.fiercepigeon.model.Code2Session;
import com.example.fiercepigeon.model.entity.User;

import java.util.ArrayList;

/**
 * @author： FardlyP
 * @description： TODO
 * @date： 2021/3/12 16:32
 * @version: 1.0
 */
public interface UserService extends ICommonService<User, Integer> {

    Code2Session getWinXinJson(String jsCode);

    User getUserByOpenId(String openId);

    String doLogin(User user) throws Exception;

    void addWeiXinUser(User user);

    ArrayList<User> findByParam(User param);

}
