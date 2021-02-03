package org.nf.mvc.view2;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @author 天文学
 */
public class JsonView extends View{
    private Object obj;

    public JsonView(Object obj) {
        this.obj = obj;
    }

    @Override
    public void response() throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        String json=new Gson().toJson(obj);
        response.getWriter().println(json);
    }
}
