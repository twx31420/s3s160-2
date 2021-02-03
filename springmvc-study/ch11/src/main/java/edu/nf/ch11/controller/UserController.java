package edu.nf.ch11.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 天文学
 * @date 2021/1/14
 */
@Controller
public class UserController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello world";
    }

    @GetMapping("/hello2")
    public String  index(){
        return "index";
    }
}
