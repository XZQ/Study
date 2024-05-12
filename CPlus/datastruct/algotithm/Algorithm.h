//
// Created by zhiqiang.xia1 on 2024/5/11.
//

#ifndef CPLUS_ALGORITHM_H
#define CPLUS_ALGORITHM_H

long long fac(int n) {
    if (n == 0 || n == 1) {
        return 1;
    } else {
        return n * fac(n - 1);
    }
}

typedef struct student {
    char name;
    char32_t number;
    char16_t sex;
    int age;
    float score;
} student;

student stu;

void cstudy();

void swap1(int a, int b);

void swap2(int &a, int &b);

void swap3(int *a, int *b);

#endif //CPLUS_ALGORITHM_H
