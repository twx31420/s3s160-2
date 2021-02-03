package edu.nf.ch01.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 天文学
 * @date 2020/12/30
 * 使用@Controller主机标识当前类为容器管理的控制器
 */
@Controller
@Scope("prototype")
public class HelloController {
    /**
     * 使用@RequestMapping注解标识方法，
     * 表示当前方法可以处理"/hello"的请求
     * @return
     */
    @RequestMapping(value = "/hello")
    public ModelAndView hello(){
        System.out.println("hello springmvc");
        //返回换一个ModelAndView，在构造方法中传入一个视图名称
//        这个视图名称就是内部资源的文件名，去掉了前缀和后缀部分
//        因为前后缀已经在配置文件中指定。这样spring的视图解析器
//        就会自动解析为/WEB-INF/jsp/index.jsp，找到这个jsp后就
//        执行转发的操作
        ModelAndView mv=new ModelAndView("index");
        return mv;
    }
}
