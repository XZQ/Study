//
// Created by zhiqiang.xia1 on 2024/5/11.
//

#include "Algorithm.h"
#include <iostream>

using namespace std;

// 正确性，易读性，健壮性，高效性

int main() {
    //cout << fac(10) << endl;
//    cstudy();
    int a = 11;
    int b = 22;
    //cout << "a=" << a << "   b=" << b << endl;
    //swap1(a, b);
    swap2(a, b);
    //swap3(&a, &b);
    //cout << "a=" << a << "   b=" << b << endl;
    return 0;
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

    char *in = "1231231";
    cout << *&in << endl;
    // 比较
    cout << "比较=" << strcmp(s3, s2) << endl;
};