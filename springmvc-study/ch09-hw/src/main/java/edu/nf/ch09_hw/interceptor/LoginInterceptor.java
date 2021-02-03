package edu.nf.ch09_hw.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import edu.nf.ch09_hw.vo.ResultVO;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 天文学
 * @date 2021/1/13
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("调用执行之前。。。");
        Object user=request.getSession().getAttribute("user");
        System.out.println(user);
        if(user==null){
//          throw new LoginException("请登入");
            ResultVO vo=new ResultVO();
            vo.setCode(HttpStatus.UNAUTHORIZED.value());
            String json=new Gson().toJson(vo);
            String js=new ObjectMapper().writeValueAsString(vo);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().println(json);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
