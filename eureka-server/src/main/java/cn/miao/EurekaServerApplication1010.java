package cn.miao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 注册中心启动类
 * @EnableEurekaServer : 开启EurekaServer服务端
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication1010
{
    public static void main( String[] args )
    {
        SpringApplication.run(EurekaServerApplication1010.class);
    }
}