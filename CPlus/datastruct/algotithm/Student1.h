//
// Created by zhiqiang.xia1 on 2024/8/8.
//

#ifndef CPLUS_STUDENT1_H
#define CPLUS_STUDENT1_H


class Student1 {

private:
    char *name{};
    int age{};

public:
    Student1();

    Student1(char *name, int age);

    explicit Student1(char *name);

    ~Student1();

    char *getName() const;

    void setName(char *name);

    int getAge() const;

    void setAge(int age);
};


#endif //CPLUS_STUDENT1_H
