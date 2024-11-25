package com.file.processor.service.factory;

import com.file.processor.service.reader.FileProcessorReaderService;

    public interface FileProcessorFactory<T> {

        FileProcessorReaderService<T> getFileProcessor(String fileExtension);

    }
