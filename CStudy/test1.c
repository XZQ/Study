//
// Created by XZQ on 2022/3/16.
//

#include <stdio.h>
#include "test1.h"
#include "test1.h"


int main()                          //主函数
{
    int a,b,c;                      //定义 a、b、c 三个整数型变量
    a = 10; b = 20;                 //a 赋值 10，b 赋值 20
    c = a + b;                      //计算 a + b 的和，并把它赋值给 c
    printf("%d+%d=%d\n", a, b, c);  //屏幕打印 ”10+20=30”
    return 0;
}