package edu.nf.ch04.controller;

import edu.nf.ch04.entity.Address;
import edu.nf.ch04.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 天文学
 * @date 2020/12/31
 */
@Controller
public class UserController {
    /**
     * 使用请求对象接收前端数据
     * @param request
     * @return
     */
    @PostMapping("/adduser")
    public ModelAndView addUser(HttpServletRequest request){
        String name =request.getParameter("userName");
        Integer age =Integer.valueOf(request.getParameter("age"));
        System.out.println(name+" : "+age);
        return new ModelAndView("index");
    }

    /**
     * 使用参数映射接收数据,注意：参数名需要和input的name属性一致
     * 如果name和参数名不一致时，可以使用@RrequestParam注解来映射
     * @return
     */
    @PostMapping("/adduser2")
    public ModelAndView addUser2(@RequestParam("userName") String userName,@RequestParam("age") int age){
        System.out.println(userName+ " : " +age);
        return new ModelAndView("index");
    }

    /**
     * 映射到实体对象中，实体字段名必须和input的name一致
     * ,当映射复杂类型的数据，列如list集合，那么需要将它声明在实体中
     * @param user
     * @return
     */
    @PostMapping("/adduser3")
    public ModelAndView addUser3(User user){
        System.out.println(user.getUserName()+ " : " +user.getAge());
        System.out.println(user.getBirth());
        for (Address address:user.getAddresses()){
            System.out.println(address.getAddr());
        }
        return new ModelAndView("index");
    }


    /**
     * 映射到数组中
     * @param ids
     * @return
     */
    @PostMapping("/delete")
    public ModelAndView delete(int [] ids){
        for (int id:ids){
            System.out.println(id);
        }
        return new ModelAndView("index");
    }

    /**
     * 将路径映射到参数中
     * 列如：http://localhost:8080/user/1001
     * 中的1001就是需要获取的参数，并且它作为url地址的一部分
     * 使用{}表达式来声明需要映射的变量名，通过@PathVariable
     * 注解来将这个变量赋值到方法参数上
     */
    @GetMapping("/user/{id}")
    public ModelAndView getUserByid(@PathVariable("id") int uid){
        System.out.println("用户ID："+uid);
        return new ModelAndView("index");
    }

    /**
     * 自定义转换器
     * @param user 注意：此时的参数名称需要和input的name对应
     * @return
     */
    @PostMapping("/converterUser")
    public ModelAndView convert(User user){
        System.out.println(user.getUserName());
        System.out.println(user.getAge());
        return  new ModelAndView("index");
    }
}
