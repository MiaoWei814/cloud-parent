package cn.miao;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.sql.ResultSet;

/**
 * @program: cloud-parent
 * @description:
 * @author: MiaoWei
 * @create: 2021-11-14 14:45
 **/
@SpringBootApplication
//@EnableEurekaClient 可打可不打  因为导包的时候就已经注册到服务中心去了,只支持Eureka环境
//开启服务发现客户端,可以不加
//@EnableDiscoveryClient  可以支持其他的注册中心
//@EnableEurekaClient 开启服务发现客户端的注解，可以用来获取一些配置的信息，得到具体的微服务
@EnableEurekaClient
@EnableDiscoveryClient
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class);
    }

    @Bean
    @LoadBalanced  //开启让有负载均衡的能力
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
