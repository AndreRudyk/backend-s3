package com.epam.edp.demo.controller;

import com.epam.edp.demo.response.FileResponse;
import com.epam.edp.demo.service.S3Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    private final S3Service service;

    public RootController(S3Service service) {
        this.service = service;
    }

    @GetMapping("/")
    public FileResponse getFileText() {
        return new FileResponse(service.readFile());
    }
}
