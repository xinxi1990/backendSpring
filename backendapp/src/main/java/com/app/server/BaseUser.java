package com.app.server;

public abstract class BaseUser {

    public static String name;
    public static int age;

    public BaseUser(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static int createAge()
    {
        System.out.println("Inside Employee computePay");
        return age;
    }

    public abstract double computeName();


}
