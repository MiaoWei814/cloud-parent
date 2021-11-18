package cn.miao.feginclient;

import org.springframework.stereotype.Component;

/**
 * @program: cloud-parent
 * @description:
 * @author: MiaoWei
 * @create: 2021-11-18 22:25
 **/
@Component
public class HystrixFallback01 implements Hystrix01{
    @Override
    public Object getUserById(Integer id) {
        return "这是错误的!";
    }

}
