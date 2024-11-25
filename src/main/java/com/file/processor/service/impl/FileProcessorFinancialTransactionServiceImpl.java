package com.file.processor.service.impl;

import com.file.processor.converter.FinancialTransactionConverter;
import com.file.processor.model.FinancialTransactionDto;
import com.file.processor.repository.FinancialTransactionRepository;
import com.file.processor.repository.entity.FinancialTransactionEntity;
import com.file.processor.service.FileProcessorService;
import com.file.processor.service.factory.FileProcessorFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileProcessorFinancialTransactionServiceImpl implements FileProcessorService<FinancialTransactionEntity> {

    private final FinancialTransactionConverter converter;
    private final FinancialTransactionRepository repository;
    private final FileProcessorFactory<FinancialTransactionDto> fileProcessorFactory;

    @Override
    public void processFile(final File file) {
        var list = fileProcessorFactory.getFileProcessor(file.getName())
                .getFileData(file)
                .stream()
                .map(converter::toEntity)
                .peek(System.out::println)
                .toList();

        save(list);
    }

    @Override
    public void save(final List<FinancialTransactionEntity> list) {
        repository.saveAll(list);
    }

}
