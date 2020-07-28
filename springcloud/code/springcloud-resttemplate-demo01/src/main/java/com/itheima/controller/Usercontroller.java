package com.itheima.controller;

import com.itheima.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 周盼龙
 * @date 2020/3/24 23:16
 */
@RestController
@RequestMapping("user")
public class Usercontroller {

    @RequestMapping("findAll")
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();

        userList.add(new User("老王","杭州",22));
        userList.add(new User("老周","珠州",23));
        userList.add(new User("老宋","柳州",24));

        return userList;
    }
}
