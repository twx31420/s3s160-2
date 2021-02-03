package edu.nf.ch09.controller;

import edu.nf.ch09.vo.ResultVO;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * @author 天文学
 * @date 2021/1/12
 */
public class BaseController {


    public <T> ResultVO<T> success(T data){
        ResultVO<T> vo=new ResultVO<>();
        vo.setCode(HttpStatus.OK.value());
        vo.setData(data);
        return vo;
    }

    public  ResultVO success(){
        ResultVO vo=new ResultVO<>();
        vo.setCode(HttpStatus.OK.value());
        return vo;
    }

    public ResultVO fail(int code,String message){
        ResultVO vo=new ResultVO<>();
        vo.setCode(code);
        vo.setMessage(message);
        return vo;
    }

    /**
     *
     * @param file 封装的上传的文件
     * @param home
     * @throws IOException
     */
    protected String  upload(MultipartFile file,String home)throws IOException{
        File uploadDir=new File(home+"files");
        if(!uploadDir.exists()){
            uploadDir.mkdirs();
        }
        String fileName =file.getOriginalFilename();
        Path path= FileSystems.getDefault().getPath(uploadDir.getAbsolutePath(),fileName);
        file.transferTo(path);
        System.out.println(path);
        return fileName;
    }

    /**
     * 文件下载
     * @param path
     * @param fileName
     * @return
     */
    public ResponseEntity<InputStreamResource> download(String path,String fileName){
        //先获取服务器本地文件目录（也就是上传目录）,并构建成下载路径
        String filePath =path+fileName;
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
