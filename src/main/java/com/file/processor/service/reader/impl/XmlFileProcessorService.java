package com.file.processor.service.reader.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
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
public class XmlFileProcessorService implements FileProcessorReaderService<FinancialTransactionDto> {

    private final XmlMapper xmlMapper;

    public List<FinancialTransactionDto> readFile(File file) {
        try {
            return xmlMapper.readValue(file, new TypeReference<List<FinancialTransactionDto>>() {});
        } catch (Exception e) {
            throw new RuntimeException("Erro ao ler o arquivo XML: " + e.getMessage(), e);
        }
    }
}
