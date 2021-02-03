package edu.nf.ch04.converter;

import edu.nf.ch04.entity.User;
import org.springframework.core.convert.converter.Converter;
/**
 * @author 天文学
 * @date 2021/1/4
 * 方式二：实现Converter接口,这里将string类型转换为user类型
 */
public class MyConverter implements Converter<String, User> {
    /**
     * 核心转换方法
     * @param s
     * @return
     */
    @Override
    public User convert(String s) {
        User user=new User();
        if(s!=null&&!"".equals(s)){
            String [] params =s.split("-");
            if(params.length==2){
                user.setUserName(params[0]);
                user.setAge(Integer.valueOf(params[1]));
            }
        }
        return user;
    }
}
