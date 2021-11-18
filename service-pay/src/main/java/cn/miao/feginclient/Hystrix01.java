package cn.miao.feginclient;

import cn.miao.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program: cloud-parent
 * @description:
 * @author: MiaoWei
 * @create: 2021-11-18 22:24
 **/
@FeignClient(value = "SERVICE-USER",fallback = HystrixFallback01.class)
public interface Hystrix01 {

    @GetMapping("/getUserById/{id}")
    Object getUserById(@PathVariable Integer id);
}
