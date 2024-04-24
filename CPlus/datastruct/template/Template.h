//
// Created by XZQ on 2022/11/6.
//

#ifndef CPLUS_TEMPLATE_H
#define CPLUS_TEMPLATE_H

template<typename T>
class Template {
private:
    T t;
public:
    explicit Template(T t = 0) {
        this->t = t;
    }

    T &getT() {
        return this->t;
    }
};

int max(int a, int b, int c) {
    a = a > b ? a : b;
    a = a > c ? a : c;
    return a;
}

double max(double a, double b, double c) {
    a = a > b ? a : b;
    a = a > c ? a : c;
    return a;
}

long max(long a, long b, long c) {
    a = a > b ? a : b;
    a = a > c ? a : c;
    return a;
}

// 函数模板
template<typename T>
T max(T a, T b, T c) {
    a = a > b ? a : b;
    a = a > c ? a : c;
    return a;
}

template<class numtype>
class Compare {
private:
    numtype x;
    numtype y;
public:
    Compare(numtype x, numtype y) {
        this->x = x;
        this->y = y;
    }

    numtype max() {
        return (x > y) ? x : y;
    }

    numtype min() {
        return (x < y) ? x : y;
    }

    numtype add();

    numtype reduce();

};

template<class numtype>
numtype Compare<numtype>::add() {
    return x + y;
}

template<class numtype>
numtype Compare<numtype>::reduce() {
    return x - y;
}


#endif //CPLUS_TEMPLATE_H
