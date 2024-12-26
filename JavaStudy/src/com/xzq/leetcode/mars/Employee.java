package com.xzq.leetcode.mars;

import org.jetbrains.annotations.NotNull;

public class Employee implements Comparable<Employee> {

    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(@NotNull Employee o) {
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return "Employee{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
