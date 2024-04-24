//
// Created by Xia on 2022/7/20.
//

#ifndef CPLUS_DATE_H
#define CPLUS_DATE_H

#include "iostream"

using namespace std;


class Date {
private:
    int _year; // 年
    int _month; // 月
    int _day; // 日
public:

    explicit Date(int year = 1, int month = 1, int day = 1) {
        this->_year = year;
        this->_month = month;
        this->_day = day;
        cout << " 构造函数被调用 " << _year << " - " << _month << " - " << _day << endl;
    }

    void print() const {
        cout << _year << " - " << _month << " - " << _day << endl;
    }
};


#endif //CPLUS_DATE_H
