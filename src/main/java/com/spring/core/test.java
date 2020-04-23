package com.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class test {
    public static void main(String[] args){
        ApplicationContext ac=new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/applicationContext.xml");

        Homework work=(Homework) ac.getBean("homework");
        System.out.println(work.getHomeworkid()+" "+work.getHomeworktitle());

        Student stu=(Student)ac.getBean("student");
        System.out.println(stu.getStuid()+" "+stu.getStuname());

        StudentHomework stuwork=(StudentHomework)ac.getBean("studenthomework");
        System.out.println(stuwork.getStuid()+" "+stuwork.getHomeworkid()+" "+stuwork.getHomeworktitle()+" "+stuwork.getHomeworkContent());
    }
}
