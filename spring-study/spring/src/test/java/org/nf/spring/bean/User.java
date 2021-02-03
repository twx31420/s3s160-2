package org.nf.spring.bean;

import org.nf.spring.core.CSRID;

/**
 * @author 天文学
 * @date 2020/12/4
 */
@CSRID(id = "user",init = "say",destory = "destory",scope = "prototype")

public class User {


    public void say(){
        System.out.println("执行初始化方法");
    }

    public void destory(){
        System.out.println("执行销毁的方法");
    }
}
