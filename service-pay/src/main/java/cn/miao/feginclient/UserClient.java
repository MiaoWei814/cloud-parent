package cn.miao.feginclient;

import cn.miao.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program: cloud-parent
 * @description:
 * @author: MiaoWei
 * @create: 2021-11-18 10:38
 **/
@FeignClient(value = "SERVICE-USER",fallbackFactory = UserClientFallback.class)
public interface UserClient {

    @GetMapping("/getUserById/{id}")
    User getUserById(@PathVariable Integer id);
}
