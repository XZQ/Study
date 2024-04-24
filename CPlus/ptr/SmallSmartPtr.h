//
// Created by Xia on 2022/7/28.
//

#ifndef CPLUS_SMALLSMARTPTR_H
#define CPLUS_SMALLSMARTPTR_H
// https://zhuanlan.zhihu.com/p/336293980
// https://blog.csdn.net/zr1996106/article/details/123987368
// https://blog.csdn.net/lyshark_lyshark/article/details/125846775
// https://blog.csdn.net/locahuang/article/details/119026233

template<typename T>
class SmallSmartPtr {
public:
    explicit SmallSmartPtr(T *ptr) : ptr_(ptr) {

    }

    ~SmallSmartPtr() {
        delete ptr_;
    }
    T* get() const { return ptr_; }


private:
    T *ptr_;

};


#endif //CPLUS_SMALLSMARTPTR_H
