package com.file.processor.controller;

import com.file.processor.controller.response.UploadResponse;
import com.file.processor.repository.entity.FinancialTransactionEntity;
import com.file.processor.service.FileProcessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/v1/financial-transactions")
@RequiredArgsConstructor
public class FinancialTransactionController {

    private final FileProcessorService<FinancialTransactionEntity> service;

    @PostMapping("/upload")
    public ResponseEntity<UploadResponse> uploadFile(@RequestParam("file") final MultipartFile multipartFile) {
        if (multipartFile.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new UploadResponse("The file cannot be empty"));
        }

        try {
            var file = convertMultipartFileToFile(multipartFile);

            service.processFile(file);

            return ResponseEntity.ok(new UploadResponse("File processed successfully"));
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new UploadResponse(("Error processing the file: " + e.getMessage())));
        }
    }

    private File convertMultipartFileToFile(MultipartFile file) throws IOException {
        var tempFile = File.createTempFile("temp", file.getOriginalFilename());
        file.transferTo(tempFile);

        return tempFile;
    }
}
