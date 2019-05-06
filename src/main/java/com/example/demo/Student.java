package com.example.demo;

import java.io.Serializable;

/**
 * Created by zhaozhirong on 2019/4/11.
 */
public class Student implements Serializable{


    private static final long serialVersionUID = 5003135521135319036L;

    public static Integer num = 5;

    private String name;
    private String age;

    public Student(String name, String age) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
