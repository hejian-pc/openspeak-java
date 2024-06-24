package com.hejmls.utils;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.PutObjectRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Data
@AllArgsConstructor
@Slf4j
@Component
public class AliOSSUtils {
    @Autowired
    private AliOSSProperties aliOSSProperties;

//    @Value("${aliyun.oss.endpoint}")
//    private String endpoint;
//
//    @Value("${aliyun.oss.accessKeyId}")
//    private String accessKeyId;
//
//    @Value("${aliyun.oss.accessKeySecret}")
//    private String accessKeySecret;
//
//    @Value("${aliyun.oss.bucketName}")
//    private String bucketName;

    /**
     * 文件上传
     *
     * @param
     * @param
     * @return
     */
    public String uploadFile(MultipartFile file) {
        // 创建OSSClient实例
        OSS ossClient = new OSSClientBuilder().build(aliOSSProperties.getEndpoint(), aliOSSProperties.getAccessKeyId(), aliOSSProperties.getAccessKeySecret());

        try {
            // 获取文件输入流
            InputStream inputStream = file.getInputStream();
            // 生成唯一文件名
            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
            // 创建PutObjectRequest对象
            PutObjectRequest putObjectRequest = new PutObjectRequest(aliOSSProperties.getBucketName(), fileName, inputStream);
            // 上传文件
            ossClient.putObject(putObjectRequest);

            // 返回文件URL
            return "https://" + aliOSSProperties.getBucketName() + "." + aliOSSProperties.getEndpoint() + "/" + fileName;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            // 关闭OSSClient
            ossClient.shutdown();
        }
    }
}