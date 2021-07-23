package com.example.demouploader.repository;

import com.example.demouploader.model.UploadFileModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UploadFileRepository extends JpaRepository<UploadFileModel, UUID> {
}
