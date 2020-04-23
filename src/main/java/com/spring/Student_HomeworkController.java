package com.spring;

import com.spring.core.Homework;
import com.spring.core.Student;
import com.spring.jdbc.HomeworkJdbc;
import com.spring.jdbc.StudentJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/list")
public class Student_HomeworkController {

    @Autowired
    StudentJdbc stu;

    @Autowired
    HomeworkJdbc homework;

    @RequestMapping(method = RequestMethod.GET,value = "/teacher")
    public String student(HttpServletRequest request, HttpServletResponse response) throws SQLException {

        List<Student> list= stu.selectAll();
        List<Homework> list1= homework.selectAll();
        request.setAttribute("list",list);
        request.setAttribute("list",list1);

        return "teacher";
    }

    @RequestMapping(method = RequestMethod.POST,value = "/addhomework")
    public String add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");

        Homework sh=new Homework();
        /**
         * 赋值
         **/
        sh.setHomeworkid(Integer.parseInt(request.getParameter("homeworkid")));
        sh.setHomeworktitle(request.getParameter("homeworktitle"));
        homework.add(sh);
        //response.sendRedirect("list");
        System.out.println(Integer.parseInt(request.getParameter("homeworkid")));

        return "redirect:student";
    }

    @RequestMapping(method = RequestMethod.POST,value = "/addstu")
    public String addstu(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");

        Student sh=new Student();
        /**
         * 赋值
         **/

        sh.setStuid(Integer.parseInt(request.getParameter("stuid")));
        sh.setStuname(request.getParameter("stuname"));
        stu.add(sh);
        //response.sendRedirect("list");
        System.out.println(Integer.parseInt(request.getParameter("stuid")));

        return "redirect:student";
    }
}
