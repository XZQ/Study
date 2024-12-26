package com.xzq.kotlin;

import java.util.List;

public class JavaPerson {

    public int age;
    public String name;

    public JavaPerson(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public JavaPerson(int age) {
        this(age, "person");
    }

    public void typeTest(List<? super JavaPerson> out, List<? extends JavaPerson> in) {

    }
}
