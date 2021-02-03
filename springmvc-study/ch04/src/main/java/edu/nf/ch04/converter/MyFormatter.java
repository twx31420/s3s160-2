package edu.nf.ch04.converter;

import edu.nf.ch04.entity.User;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

/**
 * @author 天文学
 * @date 2021/1/4
 * 方式一：实现Formatter接口，这种方式只用于即将string类型的数据(推荐)
 * 转换创业能够任意对象
 * 自定义类型转换器，将自定义的表单数据转换成user对象
 */
public class MyFormatter  implements Formatter<User> {
    /**
     * 核心转换方法
     * @param s 页面数据
     * @param locale 本地国际转换资源
     * @return
     * @throws ParseException
     */
    @Override
    public User parse(String s, Locale locale) throws ParseException {
        User user=new User();
        if(s!=null&& !"".equals(s)){
            String [] params=s.split("-");
            if (params.length==2){
                user.setUserName(params[0]);
                user.setAge(Integer.valueOf(params[1]));
            }
        }
        return user;
    }

    @Override
    public String print(User user, Locale locale) {
        return user.getUserName()+" - "+user.getAge();
    }
}
