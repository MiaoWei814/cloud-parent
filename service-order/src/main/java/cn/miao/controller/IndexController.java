package cn.miao.controller;

import cn.miao.domain.User;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @program: cloud-parent
 * @description:
 * @author: MiaoWei
 * @create: 2021-11-14 16:20
 **/
@RestController
public class IndexController {

    /**
     * DiscoveryClient 可以用来获取一些配置的信息，得到具体的微服务！
     */
    @Autowired
    private DiscoveryClient client;
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallbackMethod")   //方法熔断
    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable Long id) {
        String url = "http://SERVICE-USER/getUserById/" + id;
        return restTemplate.getForObject(url, User.class);
    }

    /**
     * //降级方法 ， 参数和返回值必须和被熔断的方法一致 ，方法名要和  fallbackMethod 的值一致
     *
     * @param id id
     * @return {@link User}
     */
    public User fallbackMethod(@PathVariable Long id) {
        //返回托底数据
        return new User(-1 ,"无此用户","用户服务不可用");
    }
}
