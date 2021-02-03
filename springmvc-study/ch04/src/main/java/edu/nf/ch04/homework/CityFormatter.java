package edu.nf.ch04.homework;

import edu.nf.ch04.entity.City;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

/**
 * @author 天文学
 * @date 2021/1/4
 */
public class CityFormatter implements Formatter<City> {
    @Override
    public City parse(String s, Locale locale) throws ParseException {
        City city=new City();
        if (s!=null && !"".equals(s)){
            String [] params=s.split("/");
            if(params.length==3){
                city.setProvince(params[0]);
                city.setC(params[1]);
                city.setStreet(params[2]);
            }
        }
        return city;
    }

    @Override
    public String print(City city, Locale locale) {
        return city.getProvince()+"-"+city.getC()+"-"+city.getStreet();
    }
}
