package com.epam.edp.demo.service;

import com.epam.edp.demo.config.S3ClientConfig;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;

import java.nio.charset.StandardCharsets;

@Service
public class S3Service {

    private final S3Client s3Client;

    private final S3ClientConfig s3ClientConfig;

    public S3Service(S3Client s3Client, S3ClientConfig s3ClientConfig) {
        this.s3Client = s3Client;
        this.s3ClientConfig = s3ClientConfig;
    }

    public String readFile() {
        var request = GetObjectRequest.builder()
                .bucket(s3ClientConfig.getBucket())
                .key(s3ClientConfig.getFile())
                .build();
        try (var s3Object = s3Client.getObject(request)) {
            return new String(s3Object.readAllBytes(), StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException("Unable to read S3 file", e);
        }
    }
}
