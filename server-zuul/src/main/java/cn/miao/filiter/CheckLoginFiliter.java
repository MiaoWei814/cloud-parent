package cn.miao.filiter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: cloud-parent
 * @description:
 * @author: MiaoWei
 * @create: 2021-11-19 10:28
 **/
@Component
public class CheckLoginFiliter extends ZuulFilter {

    /**
     * 过滤器类型
     *
     * @return {@link String}
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器执行顺序-数值越小表示执行顺序就越前,越小越先执行
     *
     * @return int
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断请求路径是否符合,比如登录或者注册那么就放行
     *
     * @return boolean
     */
    @Override
    public boolean shouldFilter() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        String requestURI = requestContext.getRequest().getRequestURI();
        if (requestURI.endsWith("login") || requestURI.endsWith("registered")) {
            //如果是登录或者注册那么就不会往下执行run方法
            return false;
        }
        return true;
    }

    /**
     * 运行
     *
     * @return {@link Object}
     * @throws ZuulException zuul例外
     */
    @Override
    public Object run() throws ZuulException {
        //获取请求对象
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            //token为空则返回错误
            //响应对象
            HttpServletResponse response = requestContext.getResponse();
            //中文编码
            response.setContentType("application/json;charset=utf-8");
            try {
                response.getWriter().write("你发生错误啦");
            } catch (IOException e) {
                e.printStackTrace();
            }
            //阻止filter继续往后执行,直接返回!
            requestContext.setSendZuulResponse(false);
        }

        //这里返回并没有任何意义,也就是说返回任何东西都是无效的!
        return null;
    }
}
