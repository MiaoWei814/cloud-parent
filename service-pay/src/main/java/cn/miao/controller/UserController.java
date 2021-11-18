package cn.miao.controller;

import cn.miao.domain.User;
import cn.miao.feginclient.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: cloud-parent
 * @description:
 * @author: MiaoWei
 * @create: 2021-11-18 10:40
 **/
@RestController
public class UserController {
    @Autowired
    private UserClient userClient;

    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userClient.getUserById(id);
    }
}
