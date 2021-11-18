package cn.miao.feginclient;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @program: cloud-parent
 * @description:
 * @author: MiaoWei
 * @create: 2021-11-18 22:25
 **/
@Component
public class HystrixFallbacFactoryk02 implements FallbackFactory<Hystrix02> {
    @Override
    public Hystrix02 create(Throwable throwable) {
        return new Hystrix02() {
            @Override
            public Object getUserById(Integer id) {
                return "这是第二种错误!";
            }
        };
    }
}
