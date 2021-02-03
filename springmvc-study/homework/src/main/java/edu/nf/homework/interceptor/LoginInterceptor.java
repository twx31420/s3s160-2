package edu.nf.homework.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.nf.homework.util.IsAjaxRequestUtils;
import edu.nf.homework.vo.ResultVO;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 天文学
 * @date 2021/1/14
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object admin=request.getSession().getAttribute("admin");
        if(admin==null){
            if(IsAjaxRequestUtils.isAjaxRequest(request)){
                ResultVO vo=new ResultVO();
                vo.setCode(HttpStatus.UNAUTHORIZED.value());
                ObjectMapper mapper=new ObjectMapper();
                String json=mapper.writeValueAsString(vo);
                response.getWriter().println(json);
            }else {
                response.sendRedirect("/login.html");

            }
            return false;
        }
        return true;
    }
}
