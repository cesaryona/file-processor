package com.file.processor.service.factory.impl;

import com.file.processor.model.FinancialTransactionDto;
import com.file.processor.service.reader.FileProcessorReaderService;
import com.file.processor.service.factory.FileProcessorFactory;
import com.file.processor.service.reader.impl.JsonFileProcessorService;
import com.file.processor.service.reader.impl.XmlFileProcessorService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class FileProcessorFinancialTransactionDtoFactoryImpl implements FileProcessorFactory<FinancialTransactionDto> {

    private final Map<String, FileProcessorReaderService<FinancialTransactionDto>> processors = new HashMap<>();
    private final JsonFileProcessorService jsonFileProcessorService;
    private final XmlFileProcessorService xmlFileProcessorService;

    @PostConstruct
    public void init() {
        processors.put(".json", jsonFileProcessorService);
        processors.put(".xml", xmlFileProcessorService);
        // processors.put(".csv", csvFileProcessorService);
    }

    @Override
    public FileProcessorReaderService<FinancialTransactionDto> getFileProcessor(String fileName) {
        return processors.entrySet().stream()
                .filter(entry -> fileName.toLowerCase().endsWith(entry.getKey()))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unsupported file format: " + fileName));
    }


}
