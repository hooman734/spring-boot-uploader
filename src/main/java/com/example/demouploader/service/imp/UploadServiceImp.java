package com.example.demouploader.service.imp;

import com.example.demouploader.model.UploadFileModel;
import com.example.demouploader.repository.UploadFileRepository;
import com.example.demouploader.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service("primary")
public class UploadServiceImp implements UploadService {


    private final UploadFileRepository uploadFileRepository;

    @Autowired
    public UploadServiceImp(UploadFileRepository uploadFileRepository) {
        this.uploadFileRepository = uploadFileRepository;
    }

    @Override
    public void uploadToLocal(MultipartFile multipartFile) {
        Path localPath;
        byte[] context;
        try {
            localPath = Paths.get("/ws/uploaded_file_" + multipartFile.getOriginalFilename());
             context = multipartFile.getBytes();
            Files.write(localPath, context);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void uploadToDB(MultipartFile multipartFile) {
        UploadFileModel uploadFileModel = new UploadFileModel();
        uploadFileModel.setName(multipartFile.getOriginalFilename());
        uploadFileModel.setType(multipartFile.getContentType());
        try {
            uploadFileModel.setContext(multipartFile.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        uploadFileRepository.save(uploadFileModel);
    }
}
