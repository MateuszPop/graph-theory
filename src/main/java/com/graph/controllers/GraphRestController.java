package com.graph.controllers;

import com.graph.response.Lista1Zadanie1Response;
import com.graph.response.ResponseCode;
import com.graph.response.ResponseStatus;
import com.graph.services.GraphService;
import com.graph.services.UploadService;
import org.jgrapht.io.ExportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class GraphRestController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GraphService graphService;

    @Autowired
    private UploadService uploadService;


    @PostMapping(value = "/graph/lista1/zadanie1")
    public Lista1Zadanie1Response lista1Zadanie1(@RequestParam("file") MultipartFile uploadFile) {
        try {
            return graphService.lista1Zadanie1(uploadService.saveUploadedFile(uploadFile));
        } catch (IOException e) {
            e.printStackTrace();
            return new Lista1Zadanie1Response(ResponseStatus.FAILED, ResponseCode.FAILED);
        }
    }

    @PostMapping(value = "/graph/lista1/zadanie2")
    public String lista1Zadanie2(@RequestParam("file") MultipartFile uploadFile) {
        try {
            return graphService.lista1Zadanie2(uploadService.saveUploadedFile(uploadFile));
        } catch (IOException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    @PostMapping(value = "/graph/lista1/zadanie3")
    public String lista1Zadanie3(@RequestParam("file") MultipartFile uploadFile) {
        try {
            return graphService.lista1Zadanie3(uploadService.saveUploadedFile(uploadFile));
        } catch (IOException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    @PostMapping(value = "/graph/lista1/zadanie4")
    public String lista1Zadanie4(@RequestParam("file") MultipartFile uploadFile) {
        try {
            return graphService.lista1Zadanie4(uploadService.saveUploadedFile(uploadFile));
        } catch (IOException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    @PostMapping(value = "/graph/lista1/zadanie5")
    public String lista1Zadanie5(@RequestParam("file") MultipartFile uploadFile) {
        try {
            return graphService.lista1Zadanie5(uploadService.saveUploadedFile(uploadFile));
        } catch (IOException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    @PostMapping(value = "/graph/lista2/zadanie1")
    public String lista2Zadanie1(@RequestParam("file") MultipartFile uploadFile) {
        try {
            return graphService.lista2Zadanie1(uploadService.saveUploadedFile(uploadFile));
        } catch (IOException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    @PostMapping(value = "/graph/lista2/zadanie2")
    public String lista2Zadanie2(@RequestParam("file") MultipartFile uploadFile) {
        try {
            return graphService.lista2Zadanie2(uploadService.saveUploadedFile(uploadFile));
        } catch (IOException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    @PostMapping(value = "/graph/lista2/zadanie3")
    public String lista2Zadanie3(@RequestParam("file") MultipartFile uploadFile) {
        try {
            return graphService.lista2Zadanie3(uploadService.saveUploadedFile(uploadFile));
        } catch (IOException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    @PostMapping(value = "/graph/lista2/zadanie4")
    public String lista2Zadanie4(@RequestParam("file") MultipartFile uploadFile) {
        try {
            return graphService.lista2Zadanie4(uploadService.saveUploadedFile(uploadFile));
        } catch (IOException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    @PostMapping(value = "/graph/lista2/zadanie5")
    public String lista2Zadanie5(@RequestParam("file") MultipartFile uploadFile) {
        try {
            return graphService.lista2Zadanie5(uploadService.saveUploadedFile(uploadFile));
        } catch (IOException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    @PostMapping(value = "/graph/lista3/zadanie1")
    public String lista3Zadanie1(@RequestParam("file") MultipartFile uploadFile) {
        try {
            return graphService.lista3Zadanie1(uploadService.saveUploadedFile(uploadFile));
        } catch (IOException | ExportException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    @PostMapping(value = "/graph/lista3/zadanie2")
    public String lista3Zadanie2(@RequestParam("file") MultipartFile uploadFile,@RequestParam("vertexIndex1") String vertexIndex1,@RequestParam("vertexIndex2") String vertexIndex2) {
        try {
            return graphService.lista3Zadanie2(uploadService.saveUploadedFile(uploadFile),vertexIndex1,vertexIndex2);
        } catch (IOException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    @PostMapping(value = "/graph/lista3/zadanie3")
    public String lista3Zadanie3(@RequestParam("file") MultipartFile uploadFile) {
        try {
            return graphService.lista3Zadanie3(uploadService.saveUploadedFile(uploadFile));
        } catch (IOException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    @PostMapping(value = {"/graph/lista3/zadanie5", "/graph/lista3/zadanie4"})
    public String lista3Zadanie5(@RequestParam("file") MultipartFile uploadFile,@RequestParam("vertexNumber") Integer vertexNumber ) {
        try {
            return graphService.lista3Zadanie5(uploadService.saveUploadedFile(uploadFile),vertexNumber);
        } catch (IOException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

    @PostMapping(value = "/graph/lista4/zadanie1")
    public String lista4Zadanie1(@RequestParam("file") MultipartFile uploadFile,@RequestParam("vertexNumber") String vertexNumber ) {
        try {
            return graphService.lista4Zadanie1(uploadService.saveUploadedFile(uploadFile),vertexNumber);
        } catch (IOException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }

}
