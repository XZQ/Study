//
// Created by Xia on 2022/8/1.
//

#ifndef CPLUS_DERIVED_H
#define CPLUS_DERIVED_H

#include "Base.h"
#include <iostream>

using namespace std;

class Derived : private Base {
public:
    void Show() {
        std::cout << "Derived=" << ma << std::endl;
        std::cout << "Derived=" << mb << std::endl;
        //std::cout << mc << std::endl;
    }

};

#endif //CPLUS_DERIVED_H
