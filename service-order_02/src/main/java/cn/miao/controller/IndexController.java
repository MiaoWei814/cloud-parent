package cn.miao.controller;

import cn.miao.domain.User;

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
    @GetMapping("/getUserById/{id}")
    public Object getUserById(@PathVariable Long id) {
//        // 获取微服务列表的清单
//        List<String> services = client.getServices();
//        System.out.println("discovery=>services:" + services);
//        // 得到一个具体的微服务信息,通过具体的微服务id，applicaioinName；
//        List<ServiceInstance> instances = client.getInstances("service-user");
//        for (ServiceInstance instance : instances) {
//            System.out.println(
//                    instance.getHost() + "\t" + // 主机名称
//                            instance.getPort() + "\t" + // 端口号
//                            instance.getUri() + "\t" + // uri
//                            instance.getServiceId() // 服务id
//            );
//        }
//        return this.client;

        String url = "http://SERVICE-USER/getUserById/" + id;
        return restTemplate.getForObject(url, User.class);
    }
}
