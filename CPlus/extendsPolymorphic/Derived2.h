//
// Created by Xia on 2022/8/1.
//

#ifndef CPLUS_DERIVED2_H
#define CPLUS_DERIVED2_H


#include "Base.h"
#include <iostream>

using namespace std;

class Derived2 : private Base {
public:
    void Show() {
        std::cout << "Derived2=" << ma << std::endl;
        std::cout << "Derived2=" << mb << std::endl;
//        std::cout << mc << std::endl;
    }
};


#endif //CPLUS_DERIVED2_H