package cn.miao.feginclient;

import cn.miao.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * 用户client02
 *
 * @author MiaoDaWei
 * @date 2021/11/18
 */
@FeignClient(value = "SERVICE-USER")
public interface UserClient_fegin02 {

    @GetMapping("/getUserById/{id}")
    User getOpenFigin(@PathVariable Integer id);
}
