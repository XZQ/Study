//
// Created by Xia on 2022/7/20.
//

#include "MyTeacher.h"

int *MyTeacher::getMHeight() const {
    return m_height;
}

void MyTeacher::setMHeight(int *mHeight) {
    m_height = mHeight;
}

int MyTeacher::getMAge() const {
    return m_age;
}

void MyTeacher::setMAge(int mAge) {
    m_age = mAge;
}

const char *MyTeacher::getMName() const {
    return m_name;
}
