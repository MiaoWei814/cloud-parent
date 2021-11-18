package cn.miao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @program: cloud-parent
 * @description:
 * @author: MiaoWei
 * @create: 2021-11-18 10:36
 **/
@SpringBootApplication
//开启Feign
@EnableFeignClients(basePackages = "cn.miao.feginclient")
public class PayApplication {


    public static void main(String[] args) {
        SpringApplication.run(PayApplication.class);
    }
}
