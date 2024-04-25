package com.xzq.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction


class SayTask extends DefaultTask {

    @Input
    String msg = "default name"
    @Input
    int age = 18


    //构造函数必须用@javax.inject.Inject注解标识
    @javax.inject.Inject
    SayTask(int age) {
        this.age = age
    }

    //通过@TaskAction注解来标识该Task要执行的动作
    @TaskAction
    void sayHello() {
        println "Hello $msg ! age is ${age}"
    }

}