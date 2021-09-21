/**
 * @author: zty
 * @program: javaweb-session-cookie
 * @ClassName Person
 * @description:
 * @create: 2021-08-15 16:51
 * @Version 1.0
 **/
package com.zty.pojo;

public class Person {
    private String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
