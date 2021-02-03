package org.nf.spring.core;

import org.springframework.context.annotation.Bean;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author 天文学
 * @date 2020/12/3
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CSRID {
    public String id() default "";
    public String scope() default "singleton";
    public String init() default "";    public String[] wired() default {};

    public String destory() default "";
}
