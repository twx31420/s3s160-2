package edu.nf.ch13.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 天文学
 * @date 2021/1/15
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置允许跨域访问,*号表示允许所有其他域名来访问
        resp.setHeader("Access-Control-Allow-Origin","*");
        //允许跨域访问的请求方法
        resp.setHeader("Access-Control-Allow-Origin","GET,POST");
        //跨域时允许发送cookie信息
//        resp.setHeader("Access-Control-Allow-Credentials","true");
        String userName=req.getParameter("userName");
        String passward =req.getParameter("passward");
        if("wangl".equals(userName)&& "123".equals(passward)){
            req.getSession().setAttribute("user",userName);
            resp.getWriter().print("login seccuss");
        }else {
            resp.getWriter().println("login fail");
        }
    }
}
