package com.itheima.controller;

import com.itheima.pojo.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 周盼龙
 * @date 2020/3/25 16:39
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/find/{id}")
    public User findById(@PathVariable(value = "id") Integer id) {

        if (id == 1) {
            throw new RuntimeException("运行时异常!!!");
        }
        User user = userService.findById(id);
        user.setName("user-provider:" + user.getName());
        try {
            Thread.sleep(1000*3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return user;
    }
}
