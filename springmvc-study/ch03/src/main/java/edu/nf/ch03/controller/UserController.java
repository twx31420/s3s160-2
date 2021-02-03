package edu.nf.ch03.controller;

import edu.nf.ch03.config.UserConfig;
import edu.nf.ch03.entity.User;
import edu.nf.ch03.service.UserService;
import edu.nf.ch03.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author 天文学
 * @date 2020/12/31
 */
@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/adduser")
    public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response){
//        获取页面信息，将信息保存到数据库
//        ...
        String name=request.getParameter("userName");
        String age =request.getParameter("age");
        System.out.println(name+ " : "+age);
        request.getSession().setAttribute("user",name);
        User user=new User();
        user.setName(name);
        userService.add(user);
        //        成功后转发到index.jsp
        return new ModelAndView("index");
    }
    @PostMapping("/update")
    public ModelAndView update(User user){
        userService.update(user);
        return new ModelAndView("index");
    }
    @PostMapping("/delete")
    public ModelAndView delete(int uid){
        userService.delete(uid);
        return new ModelAndView("index");
    }
}
