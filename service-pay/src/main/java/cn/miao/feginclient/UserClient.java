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
//用户服务的:远程调用的,Feign的客户端接口 value是要调用的服务名
@FeignClient(value = "SERVICE-USER",fallbackFactory = UserClientFallback.class)
public interface UserClient {

    /**
     * 该方法对应了目标服务的Controller的方法,一模一样,那么这是什么意思呢?
     * 1.根据SERVICE-USER服务名,能去服务注册表中找到对应的集群,也就是说能找到多个服务实例
     * 2.底层使用Ribbon,那么也就是说使用负载均衡的算法选择其中一个实例
     * 3.找到具体的实例后就会组装请求地址和参数,最终就是: http://服务地址:端口/getById/123
     * 4.注意:
     *      1. 服务名和调用的一模一样,如:SERVICE-USER
     *      2. URL必须和调用的一模一样,如:http://服务地址:端口/getById/123
     *      3. 请求参数必须和调用的一模一样,如: id
     *      4. 返回值必须和调用的一模一样, 如: User
     *      5. 方法名可以不用和调用的一模一样
     *
     * @param id id
     * @return {@link User}
     */
    @GetMapping("/getUserById/{id}")
    User getUserById(@PathVariable Integer id);
}
