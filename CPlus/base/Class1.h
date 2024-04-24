//
// Created by Xia on 2022/7/19.
//

#ifndef CPLUS_CLASS1_H
#define CPLUS_CLASS1_H

void myfunc5(int a);

void myfunc5(char *a);

void myfunc5(int a, int b);

void myfunc5(char *a, char *b);

//typedef声明一个函数类型:myTypeFunc5
typedef void (myTypeFunc5)(int a, int b);

//typedef声明一个函数指针类型
typedef void (*myPFunc5)(int a, int b);//一个函数指针只能指向一个具体的函数

typedef int SIZE_OF;


#endif //CPLUS_CLASS1_H
