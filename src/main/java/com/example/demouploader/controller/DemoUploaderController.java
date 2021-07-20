package com.example.demouploader.controller;

import com.example.demouploader.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;



@Controller
@RequestMapping("api/v1")
public class DemoUploaderController {

    private final UploadService uploadService;

    @Autowired
    public DemoUploaderController(UploadService uploadService) {
        this.uploadService = uploadService;
    }

    @ResponseBody
    @RequestMapping(value = "/upload/local", method = RequestMethod.GET)
    public String uploadLocal() {
        return "received GET request";
    }

    @ResponseBody
    @RequestMapping(value = "/upload/local", method = RequestMethod.POST)
    public String uploadLocal(@RequestParam("file") MultipartFile multipartFile) {
        uploadService.uploadToLocal(multipartFile);
        return "file : " + multipartFile.getOriginalFilename() + "file size is : " + multipartFile.getSize();
    }

    @ResponseBody
    @RequestMapping(value = "/upload/db", method = RequestMethod.POST)
    public String uploadDB(@RequestParam("file") MultipartFile multipartFile) {
        uploadService.uploadToDB(multipartFile);
        return "file : " + multipartFile.getOriginalFilename() + "file size is : " + multipartFile.getSize();
    }
}