package org.zhouhy.springboot.upload.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zhouhy.springboot.upload.entity.UploadStatus;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@Controller
public class FileController {

    @Value("${file.upload.directory}")
    private String filePath;

    @ResponseBody
    @RequestMapping(value="/upload",method=RequestMethod.POST)
    public UploadStatus uploadFile(@RequestParam("head_img")MultipartFile file
            , @RequestParam("name")String name){

        UploadStatus status = new UploadStatus();
        log.info("用户名："+name);

        String fileName = file.getOriginalFilename();
        log.info("文件名："+fileName);

        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        log.info("后缀名："+suffixName);

        fileName = UUID.randomUUID()+suffixName;
        log.info("转换后的文件名："+fileName);

        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            status.setStatus(0);
            status.setMsg("上传成功");
            return status;
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
            status.setStatus(1);
            status.setMsg("上传失败");
            return status;
        }
    }
}
