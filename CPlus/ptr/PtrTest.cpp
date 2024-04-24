//
// Created by Xia on 2022/7/28.
// https://www.cnblogs.com/tenosdoit/p/3456704.html
// https://changkun.de/modern-cpp/zh-cn/05-pointers/
// https://www.cyhone.com/articles/right-way-to-use-cpp-smart-pointer/
// http://c.biancheng.net/view/7898.html
// https://www.cnblogs.com/aquester/p/11469872.html
// https://blog.csdn.net/qq_50285142/article/details/114026148

#include "PtrTest.h"
#include <memory>
#include <iostream>


using namespace std;


void testSharedPtr() {
    shared_ptr<int> p1;
    shared_ptr<int> p2(nullptr);

    // p3 p4 一样
    shared_ptr<int> p3(new int(10));
    shared_ptr<int> p4 = std::make_shared<int>(10);

    // 调用拷贝构造函数
    shared_ptr<int> p5(p4);//    shared_ptr<int> p5 = p4;
    //调用移动构造函数
    shared_ptr<int> p6(std::move(p5));
}


//int main() {
//    cout << "printT3 end:" << endl;
//    return 0;
//}
