package cn.miao.controller;

import cn.miao.domain.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @program: cloud-parent
 * @description:
 * @author: MiaoWei
 * @create: 2021-11-18 22:17
 **/
@DefaultProperties(defaultFallback = "")
@RestController
public class HystrixController {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand
    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable Long id) {
        String url = "http://SERVICE-USER/getUserById/" + id;
        return restTemplate.getForObject(url, User.class);
    }

    /**
     * 默认的降级,不需要请求参数
     *
     * @return {@link Object}
     */
    public Object defaultFallBack(){
        return new User(1, "1", "错误");
    }
}
