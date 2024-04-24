//
// Created by Xia on 2022/7/20.
//

#include "Test.h"
#include <iostream>
// https://www.jianshu.com/p/81f876353c53
using namespace std;

#define MYFUNC(a, b) ((a) <(b)) ? (a) :(b)

void boolTest();

void pointTest();


struct Teacher {
    char name[20];
    int age;
};

int swap(int *a, int *b);


/**
 * 通过指针获取结构体参数
 * @param pT
 */
void printT1(const Teacher *teacher) {
    cout << teacher->age << endl;
}

void printT2(Teacher &teacher) {
    cout << "printT2 start:" << teacher.age << endl;
    teacher.age = 36;
    cout << "printT2 end:" << teacher.age << endl;
}

void printT3(Teacher teacher) {
    cout << "printT3 start:" << teacher.age << endl;
    teacher.age = 37;
    cout << "printT3 end:" << teacher.age << endl;
}

// 1、引用(本质是常量指针)
// 2、引用和指针的异同就是:常量指针和指针的异同

// 1 引用修改
void modifyA1(int &a) {
    a = 11;
    cout << "modifyA1= " << a << endl;
}

// 2 指针常量修改
void modifyA2(int *const a) {
    *a = 12;
    cout << "modifyA2= " << *a << endl;
}

//3 指针修改
void modifyA3(int *a) {
    *a = 13;
    cout << "modifyA3= " << *a << endl;
}

void pr() {
    int a = 10;
    int b = a;// 定义一个引用b, b像一个常量
    modifyA1(b);
    modifyA2(&a);
    modifyA3(&a);
}

//引用做函数参数
void swap(int &a, int &b);

void swap(int &a, int &b) {
    cout << &a << "  " << a << "  " << endl;
    cout << &b << "  " << b << "  " << endl;
    int temp = a;
    a = b;
    b = a;
}

void testSwap() {
    int a = 100;
    int b = 200;
    swap(a, b);
}

// 引用做函数返回值
//int getA1() {
//    int a = 10;
//    return a;
//}
//
//int &getA2() {
//    int a = 20;
//    return a;
//}
//
//int *getA3() {
//    int a = 30;
//    return &a;
//}

void testA123() {
  /*  int a1 = getA1();
    cout << "a1: " << a1 << endl;

    //当我们把栈上的引用或者指针返回出来的时候,是有问题的，因为栈的变量和方法调用完之后会被系统自动回收
    int a2 = getA2();
//    cout<< "a2: " << a2 <<endl;

   // int *a3 = *getA3();
//    cout << "a3: " << a3 << endl
}

inline void printB(int x = 10) {
    int a = 10;
}


int main() {
//    pointTest();
//    int a = 10;
//    int b = 22;
//    swap(&a, &b);
//    cout << a << "   " << b << endl;

//    Teacher teacher{};
//    teacher.age = 32;
//    printT1(&teacher);
//    printT2(teacher);
//    pr();
//    testSwap();
//    testA123();

    return 0;
}


int swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
    cout << "temp" << temp << endl;
    return 0;
}


/***
 *
 * #define 是在编译预处理阶段，只是简单的文本替换
 * const 是由编译器处理的，提供类型检查和作用域检查
 *
 * 常量指针，表示是一种输入参数,保护原来的参数内容不被修改
 */
void operatorT1(Teacher const *teacher) {
    cout << teacher->age << endl;
    teacher = nullptr;
}

/***
 *
 *指针常量,指向地址不能修改,内容可以修改
 *
 **/
int operatorT2(Teacher *const teacher) {
    teacher->age = 2;
    return 0;

}

void pointTest() {
    const int a = 10;
    std::cout << a << std::endl;

    int const *c = &a; // 常量指针 常量不可变，指针可变
    // *c = 112;
    c = &a;
    std::cout << *c << std::endl;

    int a1 = 110;
    int *const d = &a1;// 指针常量，指针不可变，内容可变
    // d = &a;
    *d = 112;

    int const *const e = &a; //常量指针常量; 指针的指向不能改变，所指向的内存空间也不能改变

}

void boolTest() {
    bool b1 = true;
    std::cout << "sizeof(bool) " << sizeof(b1) << std::endl;
    //c++编译器会在赋值的时候将非0转换为true,
    b1 = 10;//要么是1，要么是0
    std::cout << "b1: " << b1 << std::endl;
    //c++编译器会在赋值的时候将非0转换为true,
    b1 = -1;
    std::cout << "b1: " << b1 << std::endl;
    //c++编译器会在赋值的时候将0转化给false
    b1 = 0;
    std::cout << "b1: " << b1 << std::endl;
}

