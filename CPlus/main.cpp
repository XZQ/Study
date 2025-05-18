#include <iostream>
#include "base/MyTeacher.h"
#include "base/Student.h"
// https://www.jianshu.com/p/81f876353c53
using namespace std;

#include <unistd.h>
#include <stdio.h>


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

// https://blog.csdn.net/m0_54850825/article/details/124873838
void testObj() {
    cout << "new delete基本语法" << endl;

    //使用malloc函数在堆上申请了一块内存空间
    int *p = (int *) malloc(sizeof(int)); //在堆上申请了一块内存空间
    *p = 10;
    //释放堆上的内存
    free(p);
    p = nullptr;

    //使用new运算符在堆上申请了一块内存空间
    int *p1 = new int; //在堆上申请内存 分配基础类型
    *p1 = 20;
    cout << "*p1: " << *p1 << endl;
    //释放new的内存
    delete p1;
    cout << "*p1: " << *p1 << endl; //这里p1释放后还是20,释放内存,不代表清空p1的值,只是当前的内存不再受保护


    //使用new运算符在堆上申请了一块内存空间
    int *p2 = new int(30);
    cout << "*p2: " << *p2 << endl;
    delete (p2);

    cout << "*p1: " << *p1 << endl; //这里p1变成30了,说明之前释放的内存被p2用了
}

void testArray() {
    cout << "在堆上分配数组" << endl;
    // C中方式
    int *array = (int *) malloc(sizeof(int) * 10); // int array[10]
    array[0] = 20;
    free(array); //释放内存

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
    myTeacher->getMAge(); //调用方法不会自动调用构造函数
    free(myTeacher); //释放时候也不会自动调用析构函数
    cout << "================" << endl;

    MyTeacher *pt2 = new MyTeacher(10); //会自动调用构造函数
    pt2->getMAge();
    delete pt2; //会自动调用析构函数
}

void testReference() {
    int a = 1;
    int &b = a;
    printf("a:%d,b:%d\n", a, b); //a:1,b:1
    printf("a:%p,b:%p\n", &a, &b); //a:000000000061fe14,b:000000000061fe14
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
    cout << "a地址:" << &a << " b地址:" << &b << endl; //a地址:0x62fe14 b地址:0x62fe10
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
    const int &pr = p; // 常量引用(类似常量指针，常量不可变)
    cout << "pr:" << pr << "    &pr:" << *&pr << endl;
    //    pr = 11; 错误
    p = 22;
    cout << p << "   " << pr << endl; //p=22 pr=22
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

void test1(Student student) {
    //形参 是实参拷贝 const &student 先声明Student对象  需要实例化Student对象
    cout << "a:" << student.getAge() << endl; //拿到
}

void test2(Student &student) {
    // 引用传参
    cout << "a:" << student.getAge() << endl; //拿到
}

void test3(Student *student) {
    // 地址传参
    cout << "a:" << student->getAge() << endl; //拿到
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

void process(int x, int y, int (*p)(int a, int b)) {
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
void test_arr() {
    int array[2][3] = {
        {1, 2, 3},
        {4, 5, 6}
    };
    cout << &array[0][0] << "  " << &array[0][1] << "  " << &array[0][2] << endl;
    cout << &array[1][0] << "  " << &array[1][1] << "  " << &array[1][2] << endl;
}

// https://blog.csdn.net/cl122763974/article/details/139693205
void charArray() {
    char charArray[] = "Hello";
    std::size_t len = std::strlen(charArray);
    cout << len << endl;

    char *dynamicArray = new char[100];
    std::strcpy(dynamicArray, "Hello, Dynamic World!");
    cout << dynamicArray << endl;
    delete[] dynamicArray;

    std::string str = "12";

    // string        string是一个C++ 标准库中的一个类
    // char[]        指的是字符数组
    // char*         指向字符串的指针
    // const char*   指针指向的是一个const char类型，即不能通过当前的指针对字符串的内容作出修改

    //  1.char*和 char[]的区别
    //  char* 可以指向堆上或静态区的内存，需要手动管理。char[] 在栈上分配内存，自动管理；

    char *str1 = "Hello"; // 指向字符串字面值
    char *str2 = new char[6]; // 动态分配内存，释放时需要手动清理
    std::strcpy(str2, "Hello");
    cout << str1 << "  " << str2 << endl;
    delete[] str2;
    char str3[] = "Hello"; // 字符数组，大小为 6 包括终止符 '\0'，并在栈上分配内存。
}

// https://www.cnblogs.com/DamnableLee/p/13565658.html
// https://www.jianshu.com/p/79242a05601f
void charArray1() {
    char *myStr = "Hello"; // 字符指针，可以指向一片内存，内存中存放着字符串
    char *myStr1;
    myStr1 = "Hello";

    // 字符数组
    char str[10] = "Hello!"; //方法一
    char str1[10] = {'H', 'e', 'l', 'l', 'o', '!', '\0'}; //方法二，结尾必须有'\0'，整数0，非字符0；

    //错误一
    char myStr2[10];
    myStr1 = "Hello!"; //虽然都是指针，但是定义char myStr2[10]时，为其分配的是栈内存空间，而"Hello"指向数据区中的字符常量空间，所以两者之间不能直接赋值；

    //错误二
    char *myStr3 = "Hello!";
    myStr3[0] = 'h'; //错误原理同上，myStr3指向的是数据区的字符常量，是不可写的内存空间，因此不能通过指针myStr3来修改；

    // char[]转char*
    // 可以直接赋值
    char stg1[] = "Hell0";
    char *stg2 = nullptr;
    stg2 = stg1;

    // char* 转char[]
    // 不能直接赋值，可以使用strcpy函数
    char *stg3 = "hhhh";
    char stg4[] = "llll";
    strcpy(stg4, stg3);
    strncpy(stg4, stg3, strlen(stg3) + 1);

    // string 转char[]
    // 依然是使用strcpy拷贝，拷贝时要将string进行.c_str()的转换
    string ts = "my home";
    char st1[100];
    strcpy(st1, ts.c_str());

    // char[]转string
    char str22[] = "hello";
    string st22 = str;

    // string转char*
    // 用c_str()进行格式转换, 通过c_str()转成 const char*, 再通过const_cast<char>转成char
    string st = "my test";
    char *st12 = const_cast<char *>(st.c_str());
    cout << st12 << endl;

    // char*转string
    char *sr = "hello";
    string sr1 = sr;
}

// int testFork() {
//     pid_t pid = fork();
//     if (pid < 0) {
//         // fork failed
//         perror("fork");
//         return 1;
//     } else if (pid == 0) {
//         // In child process
//         printf("I am the child process, my PID is %d", getpid());
//     } else {
//         // In parent process
//         printf("I am the parent process, my PID is %d and my child's PID is %d \n", getpid(), pid);
//     }
// }

void fun(int *a) {
    cout << a << endl;
}

void fun1(int &a) {
    cout << a << endl;
}

void test1() {
    int a = 10;
    //使用指针做形参
    fun(&a);

    //使用引用做形参
    fun1(a);
    cout << a << endl;
}


int main() {
    //    testConstruction();
    //    testMyTeacher2();
    //    testDate();
    //    testObj();
    //    testReference();
    //    testNumber();
    //    testConstReference();
    //    testStudent();
    //    testFun();
    //    test_arr();
    //    charArray1();
    //    testFork();
    // test1();
    int size = 10;
    auto *ptr = static_cast<int *>(malloc(size * sizeof(int)));
    cout << "ptr=" << ptr << endl;

    if (ptr == nullptr) {
        cout << "内存分配失败" << endl;
        return -1;
    }

    for (int i = 0; i < size; i++) {
        ptr[i] = i;
    }
    free(ptr);

    return 0;
}
