package com.example.fiercepigeon.dao;

import com.example.fiercepigeon.base.ICommonDao;
import com.example.fiercepigeon.model.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * @author： FardlyP
 * @description： TODO
 * @date： 2021/3/12 16:18
 * @version: 1.0
 */
@Repository
public interface UserDao extends ICommonDao<User> {

    ArrayList<User> findByParam(User param);

}
