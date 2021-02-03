package edu.nf.ch04.homework;

import edu.nf.ch04.entity.City;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 天文学
 * @date 2021/1/4
 */
@Controller
public class CityController {
    @PostMapping("/c")
    public ModelAndView getFormatter(City city){
        System.out.println(city.getProvince());
        System.out.println(city.getC());
        System.out.println(city.getStreet());
        return new ModelAndView("index");
    }
}
