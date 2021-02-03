package edu.nf.ch13.filter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @author 天文学
 * @date 2021/1/15
 */
@WebServlet(urlPatterns = "/*")
public class CorsFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filter) throws IOException, ServletException {
        //设置允许跨域访问,*号表示允许所有其他域名来访问
//        resp.setHeader("Access-Control-Allow-Origin","*");
        //允许跨域访问的请求方法
//        resp.setHeader("Access-Control-Allow-Origin","GET,POST");
    }
}
