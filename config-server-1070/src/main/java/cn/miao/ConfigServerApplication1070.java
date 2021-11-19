package cn.miao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * 配置中心的启动类
 * @EnableConfigServer：开启配置中心
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ConfigServerApplication1070
{

    public static void main( String[] args )
    {
        SpringApplication.run(ConfigServerApplication1070.class);
    }
}
