package org.nf.project.controller;

import org.nf.project.entity.User;
import org.nf.project.service.UserService;
import org.nf.project.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * @author 天文学
 * @date 2021/1/12
 */
@RestController
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @PostMapping("/regist")
    public ResultVo regist(User ser, MultipartFile file)throws IOException {
        String home= System.getProperty("user.home");
        String fileName=upload(file,home);
        ser.setImage(fileName);
        try {
            userService.addUser(ser);
            return success();
        } catch (Exception e) {
            e.printStackTrace();
            return fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), "注册失败");
        }
    }

    @GetMapping("/user/{uid}")
    public ResultVo getUser(@PathVariable("uid") int uid){
           User user= userService.getUserById(uid);
           return success(user);
    }

    @GetMapping("/viewIcon")
    public ResponseEntity<InputStreamResource> getIcon(String fileName){
        String path=System.getProperty("user.home")+"files/";
        return download(path,fileName);
    }
}
