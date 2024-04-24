//
// Created by Xia on 2022/7/25.
//

#include "Student.h"

char *Student::getName() const {
    return name;
}

void Student::setName(char *name) {
    Student::name = name;
}

int Student::getAge() const {
    return age;
}

void Student::setAge(int age) {
    Student::age = age;
}
