//
// Created by XZQ on 2022/11/13.
//



#include "newbase.h"
#include<iostream>
#include <memory>

using namespace std;

// https://blog.csdn.net/cl122763974/article/details/139693205
void testArray1() {
    char str1[] = {"111111"};// 数组
    const char *str2 = "helloworld"; // 常量指针，值不可改变，指针可变

    char c = 'a';
    char *cp = &c;
//    cout << cp << endl;

    // 指针数组 首先这个变量是一个数组，其次，”指针”修饰这个数组，意思是说这个数组的所有元素都是指针类型
    char *arr[4] = {"hello", "world", "shannxi", "xian"};
    cout << arr << endl;
    cout << arr + 1 << endl;
    // 数组指针 数组指针可以说成是”数组的指针”，首先这个变量是一个指针，其次，”数组”修饰这个指针，意思是说这个指针存放着一个数组的首地址，或者说这个指针指向一个数组的首地址。
    char (*pa)[4];

    int x = 1, x2 = 3;
    int &rx = x;

}

// “野指针并不是指向NULL的指针，而是指向不确定地址的指针
// 其指向地址的不确定性，系统通过该指针访问的地址很可能是无法访问的，导致系统发生严重错误，即使可以被访问，读取到的数据往往也是错误的，因此野指针对程序系统运行的危害是致命的。

void testPoint() {
    float *p = (float *) malloc(5 * sizeof(float));
    if (p = nullptr) {
        p[0] = 1.1;
    }
}

// 智能指针
// https://blog.csdn.net/bitcarmanlee/article/details/124847634
// https://blog.csdn.net/TABE_/article/details/117391903
// https://blog.csdn.net/qq_35661325/article/details/125764521
// https://blog.csdn.net/qq_18626745/article/details/126419900
// https://blog.csdn.net/sheng199463/article/details/124386379

void testAutoPtr() {
    auto_ptr<string> p1(new string("111111"));
    auto_ptr<string> p2;
    p2 = p1;
    cout << "1111" << endl;

    // unique_ptr用于替换auto_ptr，实现了独占式拥有概念，保证同一时间内只有一个智能指针可以指向该对象
    unique_ptr<string> p3(new string("uniqueprt"));
    unique_ptr<string> p4;
//    p4 = p3;
    unique_ptr<string> p5;
    p5 = unique_ptr<string>(new string("1111111"));

    unique_ptr<string> u1, u2;
    u1 = std::make_unique<string>("ps2");
    u2 = move(u1);
    u1 = std::make_unique<string>(("ps1"));
    cout << *u1 << "       ---        " << *u2 << endl;

    // share_prt
//    use_count ：返回引用计数的个数
//    unique ：返回是否是独占所有权( use_count 为 1)
//    swap ：交换两个 shared_ptr 对象(即交换所拥有的对象)
//    reset ：放弃内部对象的所有权或拥有对象的变更, 会引起原有对象的引用计数的减少
//    get ：返回内部对象(指针)
    string *s1 = new string("s1");
    shared_ptr<string> ps1(s1);
    shared_ptr<string> ps2;
    ps2 = ps1;
    cout << ps1.use_count() << "--" << ps2.use_count() << "   " << ps1.unique() << "--" << ps2.unique() << endl;

    int *point = new int;
    string *string1 = new string('5', 'q');
    cout << *string1 << "       ---        " << string1 << endl;
    auto mystr = new auto(string1);

    //
    int *pp = new int();
    int *pp2 = pp;
    delete pp2; // 因为pp,pp2 指向同一个指针，此处没有问题

}

template<typename T>
T add(T t1, T t2) {
    return t1 + t2;
}
