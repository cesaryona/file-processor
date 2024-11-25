package com.file.processor.service.reader.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.file.processor.model.FinancialTransactionDto;
import com.file.processor.service.reader.FileProcessorReaderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class JsonFileProcessorService implements FileProcessorReaderService<FinancialTransactionDto> {

    private final ObjectMapper objectMapper;

    @Override
    public List<FinancialTransactionDto> readFile(File file) {
        try {
            return objectMapper.readValue(file, new TypeReference<List<FinancialTransactionDto>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Error trying to read JSON file: " + e.getMessage(), e);
        }
    }
}
