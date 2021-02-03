package edu.nf.ch05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 天文学
 * @date 2021/1/5
 */
@Controller
public class ModelController {
    @GetMapping("/getdata")
    public ModelAndView test(){

//        将数据存放到model中并带回页面
        ModelAndView mv=new ModelAndView("index");
//      先创建一个map集合用于封装数据
        Map<String,Object>data=new HashMap<>();
        data.put("userName","user1");
        data.put("age",21);
//        将这个map放入mv中即可，springmvc会将这些数据自动放入请求作用域
        //然后转发会index.JSP页面
        mv.addAllObjects(data);
        return mv;
    }

    /**
     * 当方法参数声明一个map，ModelMap, Model时，springmvc会传入一个map对象进来
     * 用于保存数据
     * 这三个参数作用是一致的，使用任意一种即可
     * @param model
     * @return
     */
    @GetMapping("/getdata2")
    public ModelAndView test2(Model model, HttpSession session){
      /*  map.put("userName","user2");
        map.put("age",21);*/
        model.addAttribute("userName","lili ");
        model.addAttribute("age",23);
        //将数据直接放入会话作用域
        session.setAttribute("address","zhuhai");
        return new ModelAndView("index1");
    }


}
