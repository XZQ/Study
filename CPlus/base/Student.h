//
// Created by Xia on 2022/7/25.
//

#ifndef CPLUS_STUDENT_H
#define CPLUS_STUDENT_H

//https://juejin.cn/post/7017983182003765284

#include <iostream>
#include <cstring>

using namespace std;


class Student {
private:
    char *name{};
    int age{};
public:
    char *getName() const;

    void setName(char *name);

    int getAge() const;

    void setAge(int age);

    Student() {
        cout << "无参构造函数" << endl;
    }

    Student(const char *name, int age) {
        cout << "带参的构造函数:" << age << endl;
        this->setAge(age);
        this->name = (char *) malloc(sizeof(strlen(name)));
//        this->name = new char(*name);
        strcpy(this->name, name); //复制到this.name中去
    }

    Student(const Student &student) {
        cout << "拷贝构造函数1:" << endl;
        this->age = student.age;
        this->name = (char *) malloc(sizeof(strlen(student.name)));//在堆区申请了一块内存
        strcpy(this->name, student.name);//复制到this.name中去
    }

    Student(Student &student) {
        cout << "拷贝构造函数2:" << endl;
    }

    // 当对象被销毁时调用，在该方法中释放class中的成员及对象
    ~Student() {
        cout << "析构函数" << endl;
        if (this->name != nullptr) {
            free(this->name);
            this->name = nullptr;
        }
    }
};


#endif //CPLUS_STUDENT_H
