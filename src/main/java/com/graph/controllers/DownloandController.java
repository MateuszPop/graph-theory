package com.graph.controllers;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class DownloandController {

    private final String DOWNLOAND_FOLDER = "src/main/resources/";

    @GetMapping(path = "/download/{fileName:.+}")
    public ResponseEntity<Resource> download(@PathVariable("fileName") String fileName) throws IOException {
        Path path = Paths.get(DOWNLOAND_FOLDER + fileName);
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(Files.size(path))
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(resource);
    }

}
