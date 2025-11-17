package com.epam.edp.demo.response;

public class FileResponse {

    private String content;

    public FileResponse(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "FileResponse{" +
                "content='" + content + '\'' +
                '}';
    }
}
