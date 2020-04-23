package com.spring.mvc;


import com.spring.aspect.TestAspect;
import com.spring.service.JdbcService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan("com.spring.*")
@EnableAspectJAutoProxy
public class TestSpring {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(TestSpring.class);
        TestAspect testAspect=context.getBean("testAspect",TestAspect.class);
        System.out.println(testAspect.toString());
        JdbcService jdbcService=context.getBean("jdbcService",JdbcService.class);
        jdbcService.getByid(10L);
    }
}
