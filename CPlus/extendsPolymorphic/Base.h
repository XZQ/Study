//
// Created by Xia on 2022/8/1.
//

#ifndef CPLUS_BASE_H
#define CPLUS_BASE_H


class Base {
public:
    Base(int a = 10, int b = 20, int c = 30) : ma(a), mb(b), mc(c) {}

public:
    int ma;
protected:
    int mb;
private:
    int mc;
};


#endif //CPLUS_BASE_H
