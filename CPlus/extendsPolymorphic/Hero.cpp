//
// Created by Xia on 2022/8/19.
//

#include "Hero.h"

#include <iostream>
#include <cstring>

using namespace std;

Dema::Dema(int blood, string name) : Hero(89, "JS"), blood(911), name("Tsla") {
    cout << "Dmea name is:" << this->name << "   " << this->blood << endl;
    this->name = name;
    this->blood = blood;
}

Dema::~Dema() {
//    if (this->name != "dema") {
//        cout << "This Hero are no dema!" << endl;
//        return;
//    }
//    if (this->blood < 0) {
//        cout << "Dema blood error!\n" << endl;
//        return;
//    }
}



