//
// Created by Xia on 2022/7/28.
//

#ifndef CPLUS_PTRTEST_H
#define CPLUS_PTRTEST_H

#include <iostream>

using namespace std;

class PtrTest {

    PtrTest() {
        cout << "构造 PtrTest()" << endl;
    }

    ~PtrTest() {
        cout << "析构 ~Test()" << endl;
    }
};


#endif //CPLUS_PTRTEST_H
