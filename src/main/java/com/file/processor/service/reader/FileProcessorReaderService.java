package com.file.processor.service.reader;

import java.io.File;
import java.util.List;

public interface FileProcessorReaderService<T> {

    default List<T> getFileData(File file) {
        var result = readFile(file);
        validateFile(result);

        return result;
    }

    List<T> readFile(File file);

    default void validateFile(List<T> records) {
        if (records.isEmpty()) {
            throw new IllegalArgumentException("the file is empty");
        }
    }
}
