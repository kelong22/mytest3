package com.itheima.feign;

import com.itheima.feign.fallback.UserClientFallback;
import com.itheima.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 周盼龙
 * @date 2020/3/26 9:35
 */
@FeignClient(value = "user-provider",fallback = UserClientFallback.class)
public interface UserClient {

    @GetMapping("/user/find/{id}")
    public User findById(@PathVariable(value = "id") Integer id);

}
