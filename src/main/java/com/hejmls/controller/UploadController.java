package com.hejmls.controller;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.hejmls.pojo.Result;
import com.hejmls.utils.AliOSSProperties;
import com.hejmls.utils.AliOSSUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user/upload")
public class UploadController {

    @Autowired
    private AliOSSUtils aliOSSUtils;

    @Autowired
    private AliOSSProperties aliOSSProperties;

    @PostMapping
    public Result uploadFile(@RequestParam("file") MultipartFile file) {
        String fileUrl = aliOSSUtils.uploadFile(file);

        return Result.success(fileUrl);

    }
    public void deleteImg(String url) {
// 填写文件完整路径。文件完整路径中不能包含Bucket名称。（这里根据自己的地址改）
        //https://sky-waimai112.oss-cn-beijing.aliyuncs.com/bc01b153-1212-4b97-a213-dd45f9c40ee5.jpg
        url = url.replace("https://openspeak.oss-cn-chengdu.aliyuncs.com/", "");
        int index = url.indexOf("?");
        if (index != -1) {
            url = url.substring(0, index);
        }
        System.out.println("拆分后的路径"+url);

// 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(aliOSSProperties.getEndpoint(),aliOSSProperties.getAccessKeyId(),aliOSSProperties.getAccessKeySecret());
// 删除文件或目录。如果要删除目录，目录必须为空。
        ossClient.deleteObject(aliOSSProperties.getBucketName(), url);
// 关闭OSSClient。
        ossClient.shutdown();
    }
}
