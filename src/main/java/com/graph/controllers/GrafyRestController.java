package com.graph.controllers;

import com.graph.services.GrafyService;
import org.jgrapht.io.ExportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class GrafyRestController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final String UPLOADED_FOLDER = "src/main/resources/";

    @Autowired
    private GrafyService grafyService;


    @PostMapping(value = "/graph/lista1/zadanie1")
    public String lista1Zadanie1(@RequestParam("file") MultipartFile uploadfile) {
        try {
            return grafyService.lista1Zadanie1(saveUploadedFiles(Arrays.asList(uploadfile)).toString());
        } catch (IOException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    @PostMapping(value = "/graph/lista1/zadanie2")
    public String lista1Zadanie2(@RequestParam("file") MultipartFile uploadfile) {
        try {
            return grafyService.lista1Zadanie2(saveUploadedFiles(Arrays.asList(uploadfile)).toString());
        } catch (IOException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    @PostMapping(value = "/graph/lista1/zadanie3")
    public String lista1Zadanie3(@RequestParam("file") MultipartFile uploadfile) {
        try {
            return grafyService.lista1Zadanie3(saveUploadedFiles(Arrays.asList(uploadfile)).toString());
        } catch (IOException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    @PostMapping(value = "/graph/lista1/zadanie4")
    public String lista1Zadanie4(@RequestParam("file") MultipartFile uploadfile) {
        try {
            return grafyService.lista1Zadanie4(saveUploadedFiles(Arrays.asList(uploadfile)).toString());
        } catch (IOException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    @PostMapping(value = "/graph/lista1/zadanie5")
    public String lista1Zadanie5(@RequestParam("file") MultipartFile uploadfile) {
        try {
            return grafyService.lista1Zadanie5(saveUploadedFiles(Arrays.asList(uploadfile)).toString());
        } catch (IOException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    @PostMapping(value = "/graph/lista2/zadanie1")
    public String lista2Zadanie1(@RequestParam("file") MultipartFile uploadfile) {
        try {
            return grafyService.lista2Zadanie1(saveUploadedFiles(Arrays.asList(uploadfile)).toString());
        } catch (IOException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    @PostMapping(value = "/graph/lista2/zadanie2")
    public String lista2Zadanie2(@RequestParam("file") MultipartFile uploadfile) {
        try {
            return grafyService.lista2Zadanie2(saveUploadedFiles(Arrays.asList(uploadfile)).toString());
        } catch (IOException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    @PostMapping(value = "/graph/lista2/zadanie3")
    public String lista2Zadanie3(@RequestParam("file") MultipartFile uploadfile) {
        try {
            return grafyService.lista2Zadanie3(saveUploadedFiles(Arrays.asList(uploadfile)).toString());
        } catch (IOException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    @PostMapping(value = "/graph/lista2/zadanie4")
    public String lista2Zadanie4(@RequestParam("file") MultipartFile uploadfile) {
        try {
            return grafyService.lista2Zadanie4(saveUploadedFiles(Arrays.asList(uploadfile)).toString());
        } catch (IOException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    @PostMapping(value = "/graph/lista2/zadanie5")
    public String lista2Zadanie5(@RequestParam("file") MultipartFile uploadfile) {
        try {
            return grafyService.lista2Zadanie5(saveUploadedFiles(Arrays.asList(uploadfile)).toString());
        } catch (IOException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    @PostMapping(value = "/graph/lista3/zadanie1")
    public String lista3Zadanie1(@RequestParam("file") MultipartFile uploadfile) {
        try {
            return grafyService.lista3Zadanie1(saveUploadedFiles(Arrays.asList(uploadfile)).toString());
        } catch (IOException | ExportException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    @PostMapping(value = "/graph/lista3/zadanie2")
    public String lista3Zadanie2(@RequestParam("file") MultipartFile uploadfile) {
        try {
            return grafyService.lista3Zadanie2(saveUploadedFiles(Arrays.asList(uploadfile)).toString());
        } catch (IOException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    @PostMapping(value = "/graph/lista3/zadanie3")
    public String lista3Zadanie3(@RequestParam("file") MultipartFile uploadfile) {
        try {
            return grafyService.lista3Zadanie3(saveUploadedFiles(Arrays.asList(uploadfile)).toString());
        } catch (IOException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    @PostMapping(value = "/graph/lista3/zadanie4")
    public String lista3Zadanie4(@RequestParam("file") MultipartFile uploadfile) {
        try {
            return grafyService.lista3Zadanie3(saveUploadedFiles(Arrays.asList(uploadfile)).toString());
        } catch (IOException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    @PostMapping(value = "/graph/lista3/zadanie5")
    public String lista3Zadanie5(@RequestParam("file") MultipartFile uploadfile,@RequestParam("vertexNumber") Integer vertexNumber ) {
        try {
            return grafyService.lista3Zadanie5(saveUploadedFiles(Arrays.asList(uploadfile)).toString(),vertexNumber);
        } catch (IOException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    @PostMapping(value = "/graph/lista4/zadanie1")
    public String lista4Zadanie1(@RequestParam("file") MultipartFile uploadfile,@RequestParam("vertexNumber") Integer vertexNumber ) {
        try {
            return grafyService.lista4Zadanie1(saveUploadedFiles(Arrays.asList(uploadfile)).toString(),vertexNumber);
        } catch (IOException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    private Path saveUploadedFiles(List<MultipartFile> files) throws IOException {
        Path path = Paths.get("");
        for (MultipartFile file : files) {
            if (file.isEmpty()) {
                continue;
            }
            byte[] bytes = file.getBytes();
            path = Paths.get(UPLOADED_FOLDER + new Date().getTime()+".txt");
            Files.write(path, bytes);
        }
        return path;
    }
}
