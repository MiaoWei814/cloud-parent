package cn.miao.feginclient;

import cn.miao.domain.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @program: cloud-parent
 * @description:
 * @author: MiaoWei
 * @create: 2021-11-18 15:52
 **/
@Component
public class UserClientFallback implements FallbackFactory<UserClient> {

    @Override
    public UserClient create(Throwable throwable) {
        return new UserClient() {
            @Override
            public User getUserById(Integer id) {
                throwable.printStackTrace();
                return new User(-1, "1", "你遇到错误啦!");
            }
        };
    }
}
