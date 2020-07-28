package com.itheima.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * @author 周盼龙
 * @date 2020/3/25 8:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ResttemplateTestApplication {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testRestTemplateFindAll() {
        String url = "http://localhost:18081/user/findAll";
        String result = restTemplate.getForObject(url, String.class);
        System.out.println(result);

    }
}
