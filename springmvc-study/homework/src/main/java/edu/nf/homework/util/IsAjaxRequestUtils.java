package edu.nf.homework.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 天文学
 * @date 2021/1/15
 */
public class IsAjaxRequestUtils {

    public static boolean isAjaxRequest(HttpServletRequest request) {
        String requestedWith = request.getHeader("x-requested-with");
        if (requestedWith != null && requestedWith.equalsIgnoreCase("XMLHttpRequest")) {
            return true;
        } else {
            return false;
        }
    }
}
