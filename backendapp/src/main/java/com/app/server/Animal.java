package com.app.server;


/***
 * 多态
 */

public abstract class Animal {
    abstract void eat();
    abstract void work();
}

class Cat extends Animal{

    @Override
    void eat() {
        System.out.println("吃鱼");
    }

    @Override
    void work() {
        System.out.println("抓老鼠");
    }
}


class Dog extends Animal{

    @Override
    void eat() {
        System.out.println("吃骨头");
    }

    @Override
    void work() {
        System.out.println("看家");
    }
}

class Test{

    public static void main(String[] args) {
        show(new Dog());

        Animal a = new Cat();  // 向上转型
        a.eat();               // 调用的是 Cat 的 eat
        Cat c = (Cat)a;        // 向下转型
        c.work();        // 调用的是 Cat 的 work

    }

    public static void show(Animal animal){
        animal.eat();
        if (animal instanceof Cat){
            Cat c = (Cat) animal;
            c.work();
        }else if (animal instanceof Dog){
            Dog d = (Dog) animal;
            d.work();
        }
    }

}