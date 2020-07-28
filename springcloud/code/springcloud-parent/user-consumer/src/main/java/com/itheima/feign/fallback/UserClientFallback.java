package com.itheima.feign.fallback;

import com.itheima.feign.UserClient;
import com.itheima.pojo.User;
import org.springframework.stereotype.Component;

/**
 * @author 周盼龙
 * @date 2020/3/26 21:23
 */
@Component
public class UserClientFallback implements UserClient {

    /***
     * 服务降级处理方法
     * @param id
     * @return
     */
    @Override
    public User findById(Integer id) {
        User user = new User();
        user.setUsername("Feign Fallback，服务降级。。。");
        return user;
    }
}
