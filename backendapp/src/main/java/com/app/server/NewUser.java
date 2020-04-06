package com.app.server;


/***
 * 抽象类总结
 * 1. 抽象类不能被实例化(初学者很容易犯的错)，如果被实例化，就会报错，编译无法通过。只有抽象类的非抽象子类可以创建对象。
 *
 * 2. 抽象类中不一定包含抽象方法，但是有抽象方法的类必定是抽象类。
 *
 * 3. 抽象类中的抽象方法只是声明，不包含方法体，就是不给出方法的具体实现也就是方法的具体功能。
 *
 * 4. 构造方法，类方法（用 static 修饰的方法）不能声明为抽象方法。
 *
 * 5. 抽象类的子类必须给出抽象类中的抽象方法的具体实现，除非该子类也是抽象类。
 */

public class NewUser extends BaseUser {

    public static String name;
    public static int age;

    public NewUser(String name, int age) {
        super(name, age);
        this.name = name;
        this.age = age;
    }


    /**
     * 覆盖父类的方法
     * @return
     */
    public static int createAge(){
        System.out.println("son createAge");
        return age * 10;
    }

    @Override
    public double computeName() {
        return 0;
    }


    /**
     * 继承父类的方法
     * @return
     */
    public int createAgeSon(){
        super.createAge(); // 应用super类的方法
        System.out.println("son createAge");
        return this.age * 10;
    }


    /**
     * 方法的重载
     * @param age
     */
    public void computeAge(int age){

    }

    public void computeAge(float age){

    }

    public static void main(String[] args) {
        NewUser newUser = new NewUser("mike",10);
        System.out.println(BaseUser.createAge());
        System.out.println(newUser.createAge());
        //System.out.println(newUser.createAgeSon());

        System.out.println(newUser.computeName());

    }

}
