package com.file.processor.service;

import java.io.File;
import java.util.List;

public interface FileProcessorService<T> {

    void processFile(File file);

    void save(List<T> list);
}
