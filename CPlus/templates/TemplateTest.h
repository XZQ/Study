//
// Created by Xia on 2022/8/1.
//

#ifndef CPLUS_TEMPLATETEST_H
#define CPLUS_TEMPLATETEST_H


class TemplateTest {

public:
//    void swap(int &left, int &right);
//
//    void swap(double &left, double &right);
//    template<class T> //两个都可以，以后基本用这个
//    template<typename T>//两个都可以
    template<class T>
    void swap(T &left, T &right) {
        T temp = left;
        left = right;
        right = temp;
    }

};


#endif //CPLUS_TEMPLATETEST_H
