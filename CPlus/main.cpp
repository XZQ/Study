#include <iostream>
#include "base/MyTeacher.h"
#include "base/Construction.h"
#include "base/Date.h"
#include "base/Student.h"
// https://www.jianshu.com/p/81f876353c53
using namespace std;


void testMyTeacher2() {
//    MyTeacher myTeacher(10);
//    MyTeacher myTeacher2(11);
//    cout << "a的年龄为：" << myTeacher.getAge() << endl;
//    cout << "b的年龄为：" << myTeacher2.getAge() << endl;

    MyTeacher a(19, 170);
//    MyTeacher a(10);
    MyTeacher b(a);
    cout << "a的年龄为：" << a.getMAge() << "  a的身高为：" << *a.getMHeight() << endl;
//    cout << "b的年龄为：" << b.getMAge() << "  b的身高为：" << b.getMHeight() << endl;
}


void testMyTeacher1() {
    cout << "C++类的使用" << endl;
    MyTeacher myTeacher = {};
    myTeacher.setMAge(32);
    cout << "t1.age: " << myTeacher.getMAge() << endl;
    cout << "========================================" << endl;
}


//https://www.jianshu.com/p/bb6b252a94d0
void testConstruction() {
    //1. 括号法
    Construction c1(1);
//    Construction c2(2, 3);

    //2. 等号法,只用于调用单个参数的构造函数(编译器自动调用的构造函数)
//    Construction t3 = (4, 5, 6, 7, 8);// C++对"=" 功能增强，这里调用了单个参数构造函数,取值以最后一个,的值为准
//    Construction t4 = 9;//这里是不是把9赋值给t4;,不是的，这里调用了Construction的构造函数

    //3. 直接调用构造函数 (手动调用的构造函数)
    Construction c5 = Construction(5, 6);

    //==========================================================================================//
    //c1 = c5;       //把 c5 copy给 c1 ,对象的赋值操作,这里不是调用构造函数(属于对象的赋值)
    Construction c6 = c5; //这里是调用了拷贝构造函数(属于对象的初始化)
    Construction c7(c5);  //这里是调用了拷贝构造函数(属于对象的初始化)
}

// https://blog.csdn.net/m0_54850825/article/details/124873838
void testDate() {
    Date d1;
    d1.print();

    Date d2(2022, 5, 15);    //含参写法，全缺省函数传3个参数可以
    d2.print();

    Date d3(2022);    //全缺省函数传1个参数可以
    d3.print();

    Date d4(2022, 10);    //全缺省函数传2个参数可以
    d4.print();

}

void testObj() {
    cout << "new delete基本语法" << endl;

    //使用malloc函数在堆上申请了一块内存空间
    int *p = (int *) malloc(sizeof(int));//在堆上申请了一块内存空间
    *p = 10;
    //释放堆上的内存
    free(p);
    p = nullptr;

    //使用new运算符在堆上申请了一块内存空间
    int *p1 = new int;//在堆上申请内存 分配基础类型
    *p1 = 20;
    cout << "*p1: " << *p1 << endl;
    //释放new的内存
    delete p1;
    cout << "*p1: " << *p1 << endl;//这里p1释放后还是20,释放内存,不代表清空p1的值,只是当前的内存不再受保护


    //使用new运算符在堆上申请了一块内存空间
    int *p2 = new int(30);
    cout << "*p2: " << *p2 << endl;
    delete (p2);

    cout << "*p1: " << *p1 << endl;//这里p1变成30了,说明之前释放的内存被p2用了

}

void testArray() {
    cout << "在堆上分配数组" << endl;
    // C中方式
    int *array = (int *) malloc(sizeof(int) * 10); // int array[10]
    array[0] = 20;
    free(array);//释放内存

    //C++中方式
    int *array1 = new int[20];
    array1[2] = 3;
    delete[] array1;
}

// https://www.jianshu.com/p/bb6b252a94d0
void testComplix() {
    cout << "在堆上分配复杂类型对象" << endl;
    //c中方式
    auto *myTeacher = (MyTeacher *) malloc(sizeof(MyTeacher));
//    MyTeacher *myTeacher = (MyTeacher *) malloc(sizeof(MyTeacher));
    myTeacher->getMAge();//调用方法不会自动调用构造函数
    free(myTeacher);//释放时候也不会自动调用析构函数
    cout << "================" << endl;

    MyTeacher *pt2 = new MyTeacher(10);//会自动调用构造函数
    pt2->getMAge();
    delete pt2;//会自动调用析构函数
}

void testReference() {
    int a = 1;
    int &b = a;
    printf("a:%d,b:%d\n", a, b);//a:1,b:1
    printf("a:%p,b:%p\n", &a, &b);//a:000000000061fe14,b:000000000061fe14
}

// 地址法
void numberChange1(int *a, int *b) {
    cout << "a=" << a << " *a=" << *a << " &a=" << &a << endl;
    cout << "b=" << b << " *b=" << *b << " &b=" << &b << endl;
    int temp = 0;
    temp = *a;
    cout << "a=" << a << " *a=" << *a << " &a=" << &a << " temp=" << temp << endl;
    *a = *b;
    *b = temp;
}

// 引用法
void numberChange2(int &a, int &b) {
    cout << "a地址:" << &a << " b地址:" << &b << endl;//a地址:0x62fe14 b地址:0x62fe10
    cout << "a:" << a << " b:" << b << endl;
    int temp = a;
    a = b;
    b = temp;
}

void testNumber() {
    // C 语言交换地址
    int a = 110;
    int b = 120;
//    numberChange1(&a, &b);
    //  C++ 交换引用
    int a1 = 110;
    int b1 = 120;
    numberChange2(a1, b1);
    cout << "a1:" << a1 << " a2:" << b1 << endl;
}

void testConstReference() {
    int p = 1;
    const int &pr = p;// 常量引用(类似常量指针，常量不可变)
    cout << "pr:" << pr << "    &pr:" << *&pr << endl;
//    pr = 11; 错误
    p = 22;
    cout << p << "   " << pr << endl;//p=22 pr=22
}

// 函数重载
inline int add(int x, int y) {
    return x + y;
}

int add(int number1 = 100, int number2 = 200, bool isOk = 0) {
    return number1 + number2;
}

int add(int number1, int number2, int number3) {
    return number1 + number2 + number3;
}

void t(int a) {
    cout << "a:" << a << endl;
}

/**
 * 引用算重载函数会和int a冲突 重载的前提具体调用的哪个类型
 */
void t(int &a) {
    cout << "int &a:" << a << endl;
}

/**
 * 常量引用，算重载但是和int a冲突
 */
void t(const int &a) {
    cout << "const int &a:" << a << endl;
}

void test1(Student student) {//形参 是实参拷贝 const &student 先声明Student对象  需要实例化Student对象
    cout << "a:" << student.getAge() << endl;//拿到
}

void test2(Student &student) {// 引用传参
    cout << "a:" << student.getAge() << endl;//拿到
}

void test3(Student *student) {// 地址传参
    cout << "a:" << student->getAge() << endl;//拿到
}

void testStudent() {
//    Student stu1;//在栈区开辟
//    stu1.setAge(100);
//    stu1.setName("张三");
//    cout << "name: " << stu1.getName() << " age:" << stu1.getAge() << endl;

//    Student *student = new Student();//new -> delete    malloc -> free
//    student->setName("李思");
//    student->setAge(19);
//    cout << "name: " << student->getName() << " age:" << student->getAge() << endl;
//    if (student) {
//        delete student;//delete 必须手动释放堆空间的student
//        student = NULL;
//    }


    //声明在栈区的对象
//    Student student1;
//    Student student2(10); //括号法 有参的构造函数
//    Student student3 = Student(); //显示法
//    Student student4 = Student(11);//显示法
//    Student student5 = 11;//隐式法：等价于Student(10)
//
//    //explicit 修饰构造函数，只能显示调用
//    Student *student = new Student();// 堆中，必须delete


//    Student student;
//    student.setAge(10);
    //  上面两行代码，会调用构造和析构，栈区声明，回收
//    test1(student);//形参传递  实例化了两次  析构函数调用了两次
//    Student student1(student);//会调用默认的拷贝函数
//    Student student2 = student;//赋值也会调用默认的考本函数

//    test2(student);// 引用
//    test3(&student);// 地址

    char ca[] = "123";
    const char *af = "123";
    Student s1(af, 11);

}

char *scrcpy1(char *dest, const char *src) {
    if (src == nullptr || dest == nullptr) {
        return nullptr;
    }
    int i = 0;
    while (*src != '\0') {
        dest[i] = *src;
        i++;
        src++;
    }
    dest[i] = '\0';
    return dest;
}

void testStrcpy() {
    const char src[] = "1111111111111111111111111111111";
    char dest[sizeof(src)];
    strcpy(dest, src);
    scrcpy1(dest, src);
    cout << dest << endl;
}

// 函数指针
int max(int x, int y);

int min(int x, int y);

void process(int x, int y, int (*p)(int x, int y));

int max(int x, int y) {
    return x > y ? x : y;
}

int min(int x, int y) {
    return x > y ? y : x;
}

void process(int x, int y, int(*p)(int a, int b)) {
    cout << p(x, y) << endl;
}

void testFun() {
    int x = 10;
    int y = 11;
    process(x, y, max);
}

//https://zhuanlan.zhihu.com/p/168627944
int (*p)();


// 函数指针


// 智能指针 https://blog.csdn.net/qq_56663697/article/details/123964427

int main() {
//    testConstruction();
//    testMyTeacher2();
//    testDate();
//    testObj();
//    testReference();
//    testNumber();
//    testConstReference();
//    testStudent();
    testFun();
    return 0;
}


