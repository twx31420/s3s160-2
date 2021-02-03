package edu.nf.ch08_hw.controller;

import edu.nf.ch08_hw.entity.User;
import edu.nf.ch08_hw.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * @author 天文学
 * @date 2021/1/11
 */
@Controller
public class UserController {

    @PostMapping("/add")
    @ResponseBody
    public String add(User user, MultipartFile file){
        System.out.println(user);
        System.out.println(file);
        try {
            try {
               String fileName=uploadFileName(file);
               user.setImage(fileName);
            }catch (Exception e){
                throw e;
            }
            new UserServiceImpl().save(user);
            return "注册成功";
        } catch (Exception e) {
            e.printStackTrace();
            return "注册失败";
        }
    }

    public String uploadFileName(MultipartFile file)throws Exception{
        String home= System.getProperty("user.name");
        File uploadDir=new File(home+"files");
        if(!uploadDir.exists()){
            uploadDir.mkdirs();
        }
        String fileName =file.getOriginalFilename();
        Path path=FileSystems.getDefault().getPath(uploadDir.getAbsolutePath(),fileName);
        file.transferTo(path);
        return fileName;
    }



}
