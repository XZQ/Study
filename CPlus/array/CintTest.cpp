//
// Created by XZQ on 2022/10/1.
//

#include <iostream>
#include <fstream>

using namespace std;

class People {
public:
    void show() {
        cout << "姓名：\t" << name << endl;
        cout << "年龄：\t" << age << endl;
        cout << "性别：\t" << sex << endl;
    }

private:
    string name = "XZQ";
    int age = 17;
    string sex = "男";
};

class Student : public People {
public:
    void show_1() {
        cout << "身高：\t" << height << endl;
        cout << "成绩：\t" << score << endl;
    }

private:
    float height = 175;
    float score = 99.8;
};

void openFile() {
    ofstream outFile;
    outFile.open("D:\\aa.txt", ios::out);
    if (outFile.is_open()) {
        cout << "文件打开成功" << endl;
    }
    outFile.close();
}

//int main() {
//    return 0;
//}