package edu.nf.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

/**
 * @author 天文学
 * @date 2021/1/10
 */
@Controller
public class DownController {

    @RequestMapping(value="/download")
    public String downloadResource(HttpSession session, HttpServletRequest request,HttpServletResponse response)
                                    throws Exception{
        String dataDirectory = request.
                getServletContext().getRealPath("/WEB-INF/data");
        System.out.println(dataDirectory);
        File file = new File(dataDirectory, "secret.pdf");
        if (file.exists()) {
            //设置响应类型，这里是下载pdf文件
            response.setContentType("application/pdf");
            //设置Content-Disposition，设置attachment，浏览器会激活文件下载框；filename指定下载后默认保存的文件名
            //不设置Content-Disposition的话，文件会在浏览器内打卡，比如txt、img文件
            response.addHeader("Content-Disposition",
                    "attachment; filename=secret.pdf");
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }

                if (bis != null) {
                        bis.close();
                }
                if (fis != null) {
                        fis.close();
                }
        }
        return null;
    }

}
