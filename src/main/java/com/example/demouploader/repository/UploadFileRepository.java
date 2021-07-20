package com.example.demouploader.repository;

import com.example.demouploader.model.UploadFileModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UploadFileRepository extends JpaRepository<UploadFileModel, Long> {
}
