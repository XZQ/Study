//
// Created by zhiqiang.xia1 on 2024/8/8.
//

#include "Student1.h"
#include <iostream>

using namespace std;

char *Student1::getName() const {
    return name;
}

void Student1::setName(char *name) {
    this->name = name;
}

int Student1::getAge() const {
    return age;
}

void Student1::setAge(int age) {
    this->age = age;
}

Student1::Student1() {
    cout << "无参构造" << endl;
}

Student1::Student1(char *name) : name(name) {
    this->name = name;
    cout << "1个参数的构造" << endl;
}

Student1::Student1(char *name, int age) : name(name), age(age) {
    cout << "两个参数的构造" << endl;
}

Student1::~Student1() {
    cout << "析构函数"<< endl;
}
