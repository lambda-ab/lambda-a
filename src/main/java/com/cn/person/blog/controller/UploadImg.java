package com.cn.person.blog.controller;

import com.cn.person.blog.config.WangEditor;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author moment
 * @date 2019/9/27 15:13
 * @describe
 */
@Controller
@CrossOrigin
public class UploadImg {
    /**
     * 图片上传
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public WangEditor uploadFile(@RequestParam("myFile") MultipartFile multipartFile,
                                 HttpServletRequest request) {
        try {
            // 获取项目路径
            String realPath = request.getSession().getServletContext()
                    .getRealPath("");
            InputStream inputStream = multipartFile.getInputStream();
            String contextPath = request.getContextPath();
            // 服务器根目录的路径

            //String path = realPath.replace(contextPath.substring(1), "");
            String path = "D:";
            // 根目录下新建文件夹upload，存放上传图片
            String uploadPath = path + "upload";
            // 获取文件名称
            String filename = multipartFile.getOriginalFilename();
            // 将文件上传的服务器根目录下的upload文件夹
            File file = new File(uploadPath, filename);
            FileUtils.copyInputStreamToFile(inputStream, file);
            // 返回图片访问路径(网络)
            /*String url = request.getScheme() + "://" + request.getServerName()
                    + ":" + request.getServerPort() + "/upload/" + filename;*/
            String url = path + "/upload/" + filename;

            String[] str = {url};
            WangEditor we = new WangEditor(str);
            return we;
        } catch (IOException e) {
            System.out.println("上传文件失败");
        }
        return null;
    }


}
