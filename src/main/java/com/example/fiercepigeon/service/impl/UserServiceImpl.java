package com.example.fiercepigeon.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.fiercepigeon.base.AbsCommonService;
import com.example.fiercepigeon.base.ICommonDao;
import com.example.fiercepigeon.common.utils.HttpClientUtil;
import com.example.fiercepigeon.common.utils.JwtUtil;
import com.example.fiercepigeon.config.WeiXinPostParamConstant;
import com.example.fiercepigeon.dao.UserDao;
import com.example.fiercepigeon.model.Code2Session;
import com.example.fiercepigeon.model.entity.User;
import com.example.fiercepigeon.service.intf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author： FardlyP
 * @description： TODO
 * @date： 2021/3/12 16:34
 * @version: 1.0
 */
@Service
public class UserServiceImpl extends AbsCommonService<User, Integer> implements UserService {


    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    protected ICommonDao<User> getDao() {
        return userDao;
    }

    /**
     * 获取openid session_key
     *
     * @param jsCode 小程序请求到的jsCode
     * @return 授权信息~
     */
    @Override
    public Code2Session getWinXinJson(String jsCode) {

        StringBuilder url = new StringBuilder();
        url.append("https://api.weixin.qq.com/sns/jscode2session?appid=");
        url.append(WeiXinPostParamConstant.APP_ID);
        url.append("&secret=");
        url.append(WeiXinPostParamConstant.SECRET);
        url.append("&js_code=");
        url.append(jsCode);
        url.append("&grant_type=authorization_code");

        try {
            String weiXinJson = HttpClientUtil.httpGetRequest(url.toString());
            return JSON.parseObject(weiXinJson, Code2Session.class);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public User getUserByOpenId(String openId) {

        User param = new User();
        param.setOpenId(openId);
        ArrayList<User> users = userDao.findByParam(param);
        if (users.size() != 0) {
            return users.get(0);
        }
        return null;

    }

    @Override
    public String doLogin(User user) throws Exception {

        return JwtUtil.createToken(user);

    }

    @Override
    public void addWeiXinUser(User user) {
        userDao.insert(user);
    }

    @Override
    public ArrayList<User> findByParam(User param) {
        return userDao.findByParam(param);
    }
}
