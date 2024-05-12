//
// Created by zhiqiang.xia1 on 2024/5/11.
//

#include "Algorithm.h"
#include <iostream>

using namespace std;

// 正确性，易读性，健壮性，高效性

int main() {
    //cout << fac(10) << endl;
    cstudy();
    return 0;
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