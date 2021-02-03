package edu.nf.ch10.interceptor;

import edu.nf.ch10.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 天文学
 * @date 2021/1/13
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 在调用controller方法之前执行
     * @param request 请求对象
     * @param response 响应对象
     * @param handler 目标控制器（Controller）实例
     * @return true 表示可以放行，那么postHandle和afterCompletion才会被执行
     * false 表示拒绝，那么后面两个方法将不被调用
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("执行控制器方法前...");
        User user=(User)request.getSession().getAttribute("user");
        if(user==null){
            response.sendRedirect("login.html");
            return false;
        }
        return true;
    }

    /**
     * 在调用controller方法后返回（ModelAndView）之前执行
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("请求到达方法之后...");
    }

    /**
     * 在调用controller方法并且放回（ModelAndView）之后执行
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("完成响应");
    }
}
