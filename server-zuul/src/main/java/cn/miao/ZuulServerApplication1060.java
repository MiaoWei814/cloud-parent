package cn.miao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 用户的启动类
 * @EnableEurekaClient： 标记该应用是 Eureka客户端
 * @EnableZuulProxy ： 开启zuul 可以看做是 @EnableZuulServer 的增强版 ，一般用这个
 * @EnableZuulServer : 这个标签也可以开启zuul，但是这个标签开启的Filter更少
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZuulServerApplication1060
{

    public static void main( String[] args )
    {
        SpringApplication.run(ZuulServerApplication1060.class);
    }
}
