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
//开启Feign支持
/**
 * 默认会扫描当前包的及其子包中的有@FeignClient的接口,进行动态处理
 * basePackages: 可以指定要扫描的路径,如果要指定多个包下路径:basePackages = {"cn.miao.feginclient","cn.miao.xxx"}
 */
@EnableFeignClients(basePackages = "cn.miao.feginclient")
public class PayApplication {
    public static void main(String[] args) {
        SpringApplication.run(PayApplication.class);
    }
}
