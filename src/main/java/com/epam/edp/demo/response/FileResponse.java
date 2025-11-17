package com.epam.edp.demo.response;

public class FileResponse {

    private String context;

    public FileResponse(String context) {
        this.context = context;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return "FileResponse{" +
                "context='" + context + '\'' +
                '}';
    }
}
