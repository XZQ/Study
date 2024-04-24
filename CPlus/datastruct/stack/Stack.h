//
// Created by XZQ on 2022/11/6.
//

#ifndef CPLUS_STACK_H
#define CPLUS_STACK_H

// https://blog.csdn.net/weixin_44843481/article/details/118597319
// https://blog.csdn.net/qq_29344757/article/details/79409591

template<class Type>
class Stack {
private:
    Type *stack;
    int top;
    int Max;
public:
    Stack(int size);

    ~Stack();

    int push(Type type); // 栈顶加入元素
    int pop(Type *type);// 栈顶删除元素
    Type getTop();

    int isEmpty() const;

    int isFull() const;  //栈是否为满
    int size() const;  //元素个数

};

template<typename Type>
Stack<Type>::Stack(int size) {
    this->Max = size;
    this->stack = new Type(size);
    this->top = -1;
}

template<typename Type>
Stack<Type>::~Stack() {
    delete stack;
}

template<class Type>
int Stack<Type>::push(Type type) {
    if (top >= this->Max - 1) {
        return -1;
    }
    stack[top] = type;
    top++;
    return 0;
}

template<class Type>
int Stack<Type>::pop(Type *type) {
    if (top == -1) {
        return 0;
    }
    *type = stack[top];
    top--;
}

template<class Type>
Type Stack<Type>::getTop() {
    if (this->top == -1) {
        return nullptr;
    }
    return stack[top];
}

template<class Type>
int Stack<Type>::isEmpty() const {
    return top == -1;
}

template<class Type>
int Stack<Type>::isFull() const {
    return top = this->Max - 1;
}

template<class Type>
int Stack<Type>::size() const {
    return top;
}


#endif //CPLUS_STACK_H
