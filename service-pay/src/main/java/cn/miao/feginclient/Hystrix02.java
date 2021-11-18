package cn.miao.feginclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program: cloud-parent
 * @description:
 * @author: MiaoWei
 * @create: 2021-11-18 22:24
 **/
@FeignClient(value = "SERVICE-USER",fallbackFactory = UserClientFallback.class)
public interface Hystrix02 {

    @GetMapping("/getUserById/{id}")
    Object getUserById(@PathVariable Integer id);
}
