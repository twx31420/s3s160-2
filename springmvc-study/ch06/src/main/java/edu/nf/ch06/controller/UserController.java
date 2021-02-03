package edu.nf.ch06.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @author 天文学
 * @date 2021/1/5
 */
@Controller
public class UserController {

    /**
     * 转发视图
     * @return
     */
    @GetMapping("/forward")
    public ModelAndView forward(){
        return new ModelAndView("index");
    }

    /**
     * 另一种转发方式，直接返回String
     * @return
     */
    @GetMapping("/forward2")
    public String forwar2(){
        return "index";
    }

    /**
     * 转发url,使用“forward：”前缀
     * 注意：这里的转发和上面两种转发是不一样的，上面转发的
     * 是一个视图逻辑名称，是通过InternalResourceViewResolver
     * 解析后转发到的页面资源，如果加上"forward："前缀，这是转发当前指定url，
     * 此时url路径借必须写完整
     * @return
     */
    @GetMapping("/forward3")
    public String forward3(){
        return "forward:forward2";
    }

    /**
     * 重定向url,注意：不能重定向内部资源
     * @return
     */@GetMapping("/redirect")
    public ModelAndView redirect(){
        //在ModelAndView的构造方法中传入一个redirectView 的视图对象
//        return new ModelAndView(new RedirectView("index2.jsp"));
//        简化
        return new ModelAndView("redirect:index2.jsp");
    }

    /**
     * 也可以直接使用redirect：前缀来重定向
     * 返回一个String类型的url地址
     * @return
     */
    @GetMapping("/redirect2")
    public String redirect2(){
         return "redirect:index2.jsp";
    }

}
