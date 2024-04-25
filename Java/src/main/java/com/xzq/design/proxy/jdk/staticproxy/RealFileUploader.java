package com.xzq.design.proxy.jdk.staticproxy;

public class RealFileUploader implements FileUploader {

    @Override
    public void upload(String file) {
        System.out.println("Uploading file: " + file);
    }
}
