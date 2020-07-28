package com.itheima.controller;

import com.itheima.feign.UserClient;
import com.itheima.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



/**
 * @author 周盼龙
 * @date 2020/3/25 16:39
 */
@RestController
@RequestMapping("/consumer")
@DefaultProperties(defaultFallback = "defaultFailBack")
public class UserController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    UserClient userClient;
    @GetMapping("/{id}")
   /* @HystrixCommand(fallbackMethod = "failBack")*/
    @HystrixCommand
    public User findById(@PathVariable(value = "id") Integer id) {
        /*String url = "http://localhost:18081/user/find/"+id;*/
        /*ServiceInstance serviceInstance = discoveryClient.getInstances("user-provider").get(0);
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/user/find/" + id;*/
       /* String url = "http://user-provider/user/find/" + id;
        return restTemplate.getForObject(url, User.class);*/
        return userClient.findById(id);
    }

    public User failBack(Integer id){
        User user = new User();
        user.setUsername("服务降级,默认处理！");
        return  user;
    }

    /****
     * 全局的服务降级处理方法
     * @return
     */
    public User defaultFailBack(){
        User user = new User();
        user.setUsername("Default-服务降级,默认处理！");
        return  user;
    }
}
