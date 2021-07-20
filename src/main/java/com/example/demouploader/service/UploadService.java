package com.example.demouploader.service;
import org.springframework.web.multipart.MultipartFile;


public interface UploadService {

    void uploadToLocal(MultipartFile multipartFile);

    void uploadToDB(MultipartFile multipartFile);
}
