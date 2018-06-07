package com.izu.hatavar.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService
{
    void init() throws IOException;

    String store(MultipartFile[] file);

    Stream <Path> loadAll() throws IOException;

    Path load(String filename);

    Resource loadAsResource(String filename) throws Exception;

    void deleteAll();
}
