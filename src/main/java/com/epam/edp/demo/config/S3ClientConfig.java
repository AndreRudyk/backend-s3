package com.epam.edp.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.WebIdentityTokenFileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
public class S3ClientConfig {

    @Value("${could.aws.region}")
    private String region;

    @Value("${could.aws.bucket}")
    private String bucket;

    @Value("${could.aws.file}")
    private String file;

    public String getRegion() {
        return region;
    }

    public String getBucket() {
        return bucket;
    }

    public String getFile() {
        return file;
    }

    @Bean
    S3Client s3Client() {
        return S3Client.builder()
                .region(Region.of(region))
                .credentialsProvider(WebIdentityTokenFileCredentialsProvider.create())
                .build();
    }
}
