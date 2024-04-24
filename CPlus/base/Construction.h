//
// Created by Xia on 2022/7/20.
//

#ifndef CPLUS_CONSTRUCTION_H
#define CPLUS_CONSTRUCTION_H

#include <iostream>

using namespace std;


class Construction {

private:
    int m_a;
    int m_b;

public:
    Construction() {//无参数构造函数
        m_a = 0;
        m_b = 0;
        cout << "无参构造函数 " << m_a << " " << m_b << endl;
    }

    Construction(int a) {//有参数的构造函数
        m_a = a;
        m_b = 0;
        cout << "有参构造函数 " << m_a << " " << m_b << endl;
    }

    Construction(int a, int b) {//有两个参数的构造函数
        m_a = a;
        m_b = b;
        cout << "有参构造函数 " << m_a << " " << m_b << endl;
    }

    /*** 一个拷贝构造函数 */
    Construction(const Construction &obj) {//参数是引用类型
        //拷贝构造函数用于,一个对象给另外一个对象赋值
        m_a = obj.m_a;
        m_b = obj.m_b;
        cout << "拷贝构造函数 " << m_a << " " << m_b << endl;
    }

    //成员函数
    void init(int a, int b) {
        m_a = a;
        m_b = b;
    }

    void print() {
        cout << "print " << m_a << " " << m_b << endl;
    }

    int getA() {
        return m_a;
    }

    ~Construction() {
        cout << "析构函数 " << m_a << " " << m_b << endl;
    }

};


#endif //CPLUS_CONSTRUCTION_H
