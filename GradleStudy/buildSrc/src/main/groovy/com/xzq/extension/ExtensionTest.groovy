package com.xzq.extension


class Animal {

    String username
    int legs

    Animal(String name) {
        username = name
    }

    void setLegs(int c) {
        legs = c
    }

    String toString() {
        return "This animal is $username, it has ${legs} legs."
    }
}

class Pig extends Animal {

    int age
    String owner

    Pig(int age, String owner) {
        super("Pig")
        this.age = age
        this.owner = owner
    }

    String toString() {
        return super.toString() + " Its age is $age, its owner is $owner."
    }

}
