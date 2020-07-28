package com.itheima.service.imp;

import com.itheima.dao.UserDao;
import com.itheima.pojo.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 周盼龙
 * @date 2020/3/25 16:17
 */
@Service
public class UserServiceImp implements UserService {


    @Autowired
    UserDao userDao;

    @Override
    public User findById(Integer id) {
        return userDao.findById(id).get();
    }
}
