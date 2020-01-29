package com.zipcode.controllers;

import com.zipcode.services.AmazonS3BucketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class S3BucketController {

    private AmazonS3BucketService amazonS3BucketService;


    S3BucketController(AmazonS3BucketService amazonS3BucketService) {
        this.amazonS3BucketService = amazonS3BucketService;
    }

    @PostMapping("/work-orders/upload-file")
    public String uploadFile(@RequestPart(value = "file") MultipartFile file) {
        return this.amazonS3BucketService.uploadFile(file);
    }

    @PostMapping("/work-orders/delete-file")
    public String deleteFile(@RequestBody String fileURL) {
        return this.amazonS3BucketService.deleteFileFromBucket(fileURL);
    }
}
