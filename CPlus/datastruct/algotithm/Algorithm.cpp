//
// Created by zhiqiang.xia1 on 2024/5/11.
//

#include "Algorithm.h"
#include <iostream>
#include <cstring>
#include "Student1.h"

using namespace std;

// 正确性，易读性，健壮性，高效性

//int main() {
//    testStu();
//    return 0;
//}

void testStu() {
    //栈空间开辟 的对象
//    Student1 stu1; //   执行无参构造，析构函数
//    Student1 student2((char *) "大傻春");//执行了一个参数的构造

//    stu1.setAge(18);
//    stu1.setName((char *) "夏洛");
//    cout << stu1.getName() << " " << stu1.getAge() << endl;

    auto *student1 = new Student1();
    student1->setName((char *) "马冬梅");
    student1->setAge(18);
    cout << student1->getName() << " " << student1->getAge() << endl;
    delete student1; //释放堆空间内存
    student1 = nullptr;

}

void test() {
    int a = 33;
    int &a1 = a;
    int *c = &a1;
    int d = 44;
    int &d1 = d;

    cout << "a=" << a << "   a=" << &a << endl;
    cout << "d=" << d << "   d=" << &d << endl;
    //cout << "c=" << c << "   c=" << *c << endl;
    cout << "" << endl;

    // swapAddress(&a, &d);
    swapRef(a, d);

    cout << "a=" << a << "   a=" << &a << endl;
    cout << "d=" << d << "   d=" << &d << endl;
}

void swapAddress(int *a, int *b) {
    cout << "a=" << a << "   *a=" << *a << endl;
    cout << "b=" << b << "   *b=" << *b << endl;
    int temp = *a;
    *a = *b;
    *b = temp;
    cout << "a=" << a << "   *a=" << *a << endl;
    cout << "b=" << b << "   *b=" << *b << endl;
    cout << "" << endl;

}

void swapRef(int &a, int &b) {
    cout << "a=" << a << "   &a=" << &a << endl;
    cout << "b=" << b << "   &b=" << &b << endl;

    int temp = b;
    b = a;
    a = temp;

    cout << "a=" << a << "   &a=" << &a << endl;
    cout << "b=" << b << "   &b=" << &b << endl;
    cout << "" << endl;
}

void swapValue(int a, int b) {
    cout << "a=" << a << "   b=" << b << endl;
    int temp = a;
    a = b;
    b = temp;
    cout << "a=" << a << "   b=" << b << endl;
}


//引用
void swap2(int &a, int &b) {
    cout << "a=" << a << "   b=" << b << endl;
    //cout << "&a=" << &a << "   &b=" << &b << endl;
    int tmp = a;
    a = b;
    b = tmp;
}

//地址
void swap3(int *a, int *b) {
    cout << "a=" << a << "   b=" << b << endl;
    cout << "a=" << *a << "   b=" << *b << endl;
    int tmp = *a;
    *a = *b;
    *b = tmp;
}

// 值交换
void swap1(int a, int b) {
    cout << "a=" << a << "   b=" << b << endl;
    int tmp;
    tmp = a;
    a = b;
    b = tmp;
    cout << "a=" << a << "   b=" << b << endl;
}

void cstudy() {
    char s1[6] = {'h', 'e', 'l', 'l', 'o', '\0'};
    char s2[3] = {'X', 'Z', 'Q'};
    char s3[3] = {'X', 'Z', 'Q'};
    cout << strlen(s1) << endl;
    //拼接
    char *ract = strcat(s1, s2);
    cout << "ract=" << ract << "    ract=" << &ract << endl;

//    char *in = "1231231";
//    cout << *&in << endl;
//    // 比较
//    cout << "比较=" << strcmp(s3, s2) << endl;
};