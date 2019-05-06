package com.example.demo;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zhaozhirong on 2019/4/11.
 */
public class Main {
    public static void main(String[] args) throws Exception {
      String aa  = "123,21s,32432，324324，32432";
        System.out.println(aa.replaceAll("，",",").split(",").length);
    }

    private static void write() throws IOException{
        Student student = new Student("zzr","12");
        FileOutputStream fileOutputStream = new FileOutputStream("person.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(student);
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    private static void read() throws IOException, ClassNotFoundException {
        Student student =null;
        FileInputStream fileInputStream = new FileInputStream("person.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        student = (Student) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(student.getName());
        System.out.println(student.getAge());
        System.out.println(Student.num);
    }

    /**
     * 获取过去第几天的日期
     *
     * @param past
     * @return
     */
    public static String getPastDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(today);
        return result;
    }
}
