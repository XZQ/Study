//
// Created by Xia on 2022/7/26.
//

#ifndef CPLUS_PERSON_H
#define CPLUS_PERSON_H


class Person {
private:
    char m_Name;
    int *m_Age;
public:

    Person(char name, int age) {
        this->m_Name = name;
        this->m_Age = new int(age);
    }

    Person(const Person *person) {
        // 浅拷贝可以解决值传递的问题
        this->m_Name = person->m_Name;
        // 深拷贝
        this->m_Age = new int(*person->m_Age);
    }

    ~Person() {
        if (this->m_Age != nullptr) {
            delete this->m_Age;
            this->m_Age = nullptr;
        }
    }
};


#endif //CPLUS_PERSON_H
