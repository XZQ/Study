//
// Created by XZQ on 2022/11/22.
// https://blog.csdn.net/QLeelq/article/details/115747717
//

#include<iostream>
#include<thread>

using namespace std;

// https://zhuanlan.zhihu.com/p/643183960
// https://blog.csdn.net/weixin_45754224/article/details/141139153

void thread1() {
    std::cout << "子线程1    =" << &this_thread::get_id << std::endl;
}

void thread2(int x) {
    std::cout << "子线程2 x=" << x << std::endl;
}

// 锁 https://www.cnblogs.com/whlook/p/6573659.html

void createThread() {
    std::thread second(thread2, 100);
    std::cout << "主线程\n";
    second.join();
}


// int main() {
//     std::thread first(thread1);
//     std::cout << "主线程\n";
//     first.join(); //必须说明添加线程的方式
//     return 0;
// }


// https://juejin.cn/post/6844903668026703880#heading-5
//结构体大小涉及一个对齐的问题，对齐规则为：
//结构体变量首地址为最宽成员长度（如果有#pragma pack(n)，则取最宽成员长度和n的较小值，默认pragma的n=8）的整数倍
//        结构体大小为最宽成员长度的整数倍
//结构体每个成员相对结构体首地址的偏移量都是每个成员本身大小（如果有pragma pack(n),则是n与成员大小的较小值）的整数倍
//        因此，下面结构体S1和S2虽然内容一样，但是字段顺序不同，大小也不同，sizeof(S1) = 8, 而sizeof(S2) = 12. 如果定义了#pragma pack(2)，则sizeof(S1)=8；sizeof(S2)=8

/*
https://blog.csdn.net/weixin_42133358/article/details/124765557
https://www.jb51.net/article/252953.htm
https://blog.csdn.net/qq_45139003/article/details/121444879
*/

//int main() {
////    createThread();
//    testStudent();
//    return 0;
//}