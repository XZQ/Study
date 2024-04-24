//
// Created by Xia on 2022/8/1.
// https://blog.csdn.net/qq_60750110/article/details/125024435
// https://blog.csdn.net/qq_61386381/article/details/125595705
// https://blog.csdn.net/zstuyyyyccccbbbb/article/details/122623701
// 模板原理：我们写了模板，编译器通过调用函数模板和类模板的类型，实例化出对应的函数或者类。

#include "TemplateTest.h"
#include <iostream>

using namespace std;


void testTemp() {
    int a = 0, b = 1;
    double c = 2.2, d = 3.3;
    swap(a, b);
    swap(c, d);
}

int Add(int left, int right) {
    return left + right;
}

template<typename T>
T Add(const T &left, const T &right) {
    return left + right;
}

template<class T1, class T2>
T1 add(T1 t1, T2 t2) {
    return t1 + t2;
}




int main1() {
    int a1 = 10, a2 = 20;
    double d1 = 10.0, d2 = 20.0;
    ///隐式实例化(T的类型是编译器自己推导的)
    cout << Add(a1, a2) << endl;
    cout << Add(d1, d2) << endl;

    int a3 = 10, a4 = 20;
    double d3 = 10.0;
    double d4 = 20.0;
    // error
    // 因为在编译期间，编译器根据实参推演模板参数的实际类型时，根据实参a将T推演为int，根据实参b将T推演为double，但是模板参数列表中只有一个T，编译器无法确定此处应该将T确定为int还是double
//    Add(a3, d3);

    int a5 = 10, a6 = 20;
    double d5 = 10.0;
    double d6 = 20.0;
    Add(a5, (int) d5);  // 1、仍然隐式实例化
    Add<int>(a5, d5);  // 2、显示实例化,指定T的类型

    Add(1, 2); //与非模板函数匹配，编译器不需要特化.实例化要额外花费
    Add<int>(1, 2); //调用编译器特化的Add版本.显示实例化

    return 0;
}



//void TemplateTest::swap(int &left, int &right) {
//
//}
//
//void TemplateTest::swap(double &left, double &right) {
//
//}
