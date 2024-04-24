//
// Created by Xia on 2022/7/20.
//
#include <iostream>

#ifndef CPLUS_MYTEACHER_H
#define CPLUS_MYTEACHER_H
using namespace std;


class MyTeacher {

private:
    int m_age;
public:
    int getMAge() const;

    void setMAge(int mAge);

    const char *getMName() const;

private:
    char m_name[32];
    int *m_height;
public:
    int *getMHeight() const;

    void setMHeight(int *mHeight);

public:

    MyTeacher() {
        cout << "默认构造函数的调用\n";
    }

    MyTeacher(int age) {
        cout << "有参构造函数的调用 age=" << age << endl;
        m_age = age;
    }

    MyTeacher(const MyTeacher &teacher) {
        cout << "拷贝构造函数的调用" << endl;
        m_age = teacher.m_age;
        m_height = new int(*teacher.m_height);
    }

    MyTeacher(int age, int height) {
        cout << "有参构造函数的调用 age=" << age << endl;
        m_age = age;
        m_height = new int(height);
    }

    ~MyTeacher() {
        cout << "析构函数的调用 age=" << m_age << "   " << m_height << endl;
        if (m_height != nullptr) {
            delete m_height;
            m_height = nullptr;
        }
        cout << "析构函数的调用 age=" << m_age << "   " << m_height << endl;
    }
};


#endif //CPLUS_MYTEACHER_H
