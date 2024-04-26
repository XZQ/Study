package com.xzq.java;

import java.util.Arrays;
import java.util.Optional;

public class Client {

    public static void main(String[] args) {
        String[] list = {"143551781-staging", "333095986-staging", "314208281-staging", "325405068-staging", "389949466-staging"};

        Optional<String> result = Arrays.stream(list).filter("31421018281-staging"::equals).findFirst();

        if (result.isPresent()) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}