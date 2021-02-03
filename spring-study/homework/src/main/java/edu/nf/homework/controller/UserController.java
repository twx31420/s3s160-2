package edu.nf.homework.controller;


import edu.nf.homework.service.Service;
import org.springframework.stereotype.Controller;

/**
 * @author 天文学
 * @date 2020/12/21
 */
public class UserController {

    private Service service;

    public void setService(Service service) {
        this.service = service;
    }

    public void query(){
        service.query().forEach(user -> {
            System.out.println(user.getName());
        });
    }

}
