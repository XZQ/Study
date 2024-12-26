package com.xzq.design.proxy.jdk.staticproxy;

public class ProxyFileUploader implements FileUploader {

    private FileUploader fileUploader;

    public ProxyFileUploader(FileUploader fileUploader) {
        this.fileUploader = fileUploader;
    }

    @Override
    public void upload(String file) {
        System.out.println("Before uploading: " + file);
        // 调用真实主题的上传方法
        fileUploader.upload(file);
        // 额外的处理，比如记录日志
        System.out.println("After uploading: " + file);
    }
}
