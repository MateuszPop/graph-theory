package com.graph.services;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Service
public class UploadService {

    private final String UPLOADED_FOLDER = "src/main/resources/";

    public Path saveUploadedFile(MultipartFile file) throws IOException {
        byte[] bytes = file.getBytes();
        Path path = Paths.get(UPLOADED_FOLDER + new Date().getTime()+".txt");
        Files.write(path, bytes);
        return path;
    }

}
