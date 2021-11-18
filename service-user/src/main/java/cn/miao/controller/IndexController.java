package cn.miao.controller;

import cn.miao.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @program: cloud-parent
 * @description:
 * @author: MiaoWei
 * @create: 2021-11-14 16:20
 **/
@RestController
public class IndexController {

    @Value("${server.port}")
    private Integer port;
    
    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable Integer id) {
        return new User(id, "zs", "我是张三,端口是:"+port);
    }
}
