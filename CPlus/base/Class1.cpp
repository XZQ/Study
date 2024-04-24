//
// Created by Xia on 2022/7/19.
//

#include <iostream>
#include "Class1.h"

using namespace std;


int main() {
    SIZE_OF a;
    // 函数指针
    myTypeFunc5 *func = nullptr;
    // 函数赋值给函数指针
    func = myfunc5;
    func(1, 2);
    cout << "=============================" << endl;

    myPFunc5 func2 = nullptr;
    func2 = myfunc5;
    func2(110, 119);

    return 0;
}

void myfunc5(int a) {
    cout << "a: " << a << endl;
}

void myfunc5(char *a) {
    cout << "a: " << a << endl;
}

void myfunc5(int a, int b) {
    cout << "a: " << a << " b: " << b << endl;
}

void myfunc5(char *a, char *b) {
    cout << "a: " << a << " b: " << b << endl;
}