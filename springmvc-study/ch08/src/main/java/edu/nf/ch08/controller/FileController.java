package edu.nf.ch08.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 天文学
 * @date 2021/1/8
 */
@Controller
public class FileController {

    /**
     * 如果是表单文件上传，MultipartFile的参数名需要要和表单一样
     * @param readme
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/fileupload")
    public ModelAndView upload(String readme, MultipartFile[] file)throws IOException {
        //获取系统当前的用户目录
        String home=System.getProperty("user.home");
        //指定上传的文件夹目录
        File uploadDir=new File(home+"files");
        //如果files子目录不存在则创建出来
        if(!uploadDir.exists()){
            uploadDir.mkdirs();
        }
        ModelAndView mv=new ModelAndView("index");

        /*//获取上传的文件名
        String fileName = file.getOriginalFilename();
        //将路径和文件名通过文件系统对象（FileSystem）
        // 构建成一个完整（path）对象
        Path path = FileSystems.getDefault().getPath(uploadDir.getAbsolutePath(), fileName);
        //执行上传
        file.transferTo(path);
        System.out.println(path);

        //将文件名保存到Model中，转发到index页面显示
        mv.addObject("fileName", fileName);*/

        for (int i=0;i<file.length;i++) {
            //获取上传的文件名
            String fileName = file[i].getOriginalFilename();
            //将路径和文件名通过文件系统对象（FileSystem）
            // 构建成一个完整（path）对象
            Path path = FileSystems.getDefault().getPath(uploadDir.getAbsolutePath(), fileName);
            //执行上传
            file[0].transferTo(path);
            System.out.println(path);

            //将文件名保存到Model中，转发到index页面显示
            mv.addObject("fileName", fileName);
        }
        return mv;
    }

    /**
     * 多文件上传
     * @param files
     * @return
     * @throws IOException
     */
    @PostMapping("/filesupload")
    public ModelAndView upload2(MultipartFile[] files)throws IOException{
        //获取系统当前的用户目录
        String home=System.getProperty("user.home");
        //指定上传的文件夹目录
        File uploadDir=new File(home+"files");
        //如果files子目录不存在则创建出来
        if(!uploadDir.exists()){
            uploadDir.mkdirs();
        }
        ModelAndView mv=new ModelAndView("index2");
        List<String> fileNames=new ArrayList<>();
//        循环遍历多文件
        for (MultipartFile file:files){
            String fileName=file.getOriginalFilename();
            //构建成一个完整的
            Path path=FileSystems.getDefault().getPath(uploadDir.getAbsolutePath(),fileName);
            //上传
            file.transferTo(path);
            System.out.println(path);
            //保存文件名
            fileNames.add(fileName);
        }
        mv.addObject("fileNames",fileNames);
        return mv;
    }

    /* *
     * ajax上传
     * @return
     */
    @PostMapping("/ajaxupload")
    @ResponseBody
    public String upload3(String userName, MultipartFile file)throws IOException{
        //获取系统当前的用户目录
        String home=System.getProperty("user.home");
        //指定上传的文件夹目录
        File uploadDir=new File(home+"files");
        //如果files子目录不存在则创建出来
        if(!uploadDir.exists()){
            uploadDir.mkdirs();
        }
        String fileName =file.getOriginalFilename();
        System.out.println(fileName);
        Path path=FileSystems.getDefault().getPath(uploadDir.getAbsolutePath(),fileName);
        file.transferTo(path);
        return "上传成功";
    }

    /**
     * 文件下载
     * 读取服务器本地文件封装为ResponseEntity,里面保存的是一个资源输入流
     * 用于读取服务器的文件并以io的形式写会客户端，客户端即可下载
     * @param fileName 要下载的文件名
     * @return
     */
    @GetMapping("/download")
    public ResponseEntity<InputStreamResource> download(String fileName){
        //先获取服务器本地文件目录（也就是上传目录）,并构建成下载路径
        String filePath =System.getProperty("user.home")+"files/"+fileName;
        //依据路径构成一个File对象
        File file=new File(filePath);
        System.out.println(filePath);
        //创建响应头对象，并设置响应的信息
        HttpHeaders headers=new HttpHeaders();
        try{
            //对文件名进行重新编码，防止响应头中出现乱码
            String headerFileName= URLEncoder.encode(fileName,"UTF-8");
            //设置响应内容处理方式为附件，并指定文件名
            headers.setContentDispositionFormData("attachment",headerFileName);
            //设置响应头的类型为Application/octet-stream，表示是一个流的类型
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            //根据File对象构建一个输入流
            InputStream inputStream= FileUtils.openInputStream(file);
            //创建一个INputStreamResourc封装的而输入流对象，用于读取服务器文件
            InputStreamResource resource=new InputStreamResource(inputStream);
            //创建responseEntity对象，（inputstreamResource,响应头，响应转态码）
            ResponseEntity<InputStreamResource> entity=new ResponseEntity<>(resource,headers, HttpStatus.CREATED);
            //最后将整个responseEntity对象返回给dispatcherServlet
            return entity;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("文件下载失败",e);
        }
    }


}
