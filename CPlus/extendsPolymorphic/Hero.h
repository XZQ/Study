//
// Created by Xia on 2022/8/19.
//

#ifndef CPLUS_HERO_H
#define CPLUS_HERO_H

#include <iostream>
#include <cstring>

using namespace std;

class Hero {
private:
    int blood;
    string name;
public:

    Hero(int blood, string name = "XZA") {
        this->blood = blood;
        this->name = name;
    }

    ~Hero() {
        if (this->blood < 0) {
            cout << "Hero blood error!\n" << endl;
            return;
        }
        cout << "~ Hero name is:" << this->name << endl;
        cout << "~ Hero blood is :" << this->blood << endl;
    }
};

class Dema : public Hero {
private :
    int blood;
    string name;

public:
    Dema();
    Dema(int blood, string name);

    ~Dema();
};



#endif //CPLUS_HERO_H
