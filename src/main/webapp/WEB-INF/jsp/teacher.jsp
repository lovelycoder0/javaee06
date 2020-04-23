<%@ page import="com.spring.core.StudentHomework" %>
<%@ page import="java.util.List" %>
<%@ page import="com.spring.jdbc.StudentHomeworkJdbc" %>
<%@ page import="com.spring.core.Student" %>
<%@ page import="com.spring.jdbc.StudentJdbc" %>
<%@ page import="com.spring.core.Homework" %>
<%@ page import="com.spring.jdbc.HomeworkJdbc" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/3/9
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师界面</title>
</head>
<body>

<fieldset>
    <legend align="center">学生作业</legend>
    <table align="center" width="960" border="1"
           bgcolor="black" cellpadding="1" cellspacing="1">
        <tr align="center" height="30" bgcolor="#5f9ea0">
            <td>ID</td>
            <td>学生学号</td>
            <td>作业编号</td>
            <td>作业标题</td>
            <td>作业内容</td>
            <td>创建时间</td>
        </tr>

        <%
            StudentHomeworkJdbc studenthomework=new StudentHomeworkJdbc();
            List<StudentHomework> list=(List<StudentHomework>) studenthomework.selectAll();
            //List<StudentHomework> list=(List<StudentHomework>) request.getAttribute("list");

            if(null==list||list.size()<=0){
                System.out.println("None data.");
            }
            else{
                for (StudentHomework sh:list){

        %>

        <tr align="center" bgcolor="white">
            <td><%=sh.getId()%></td>
            <td><%=sh.getStuid()%></td>
            <td><%=sh.getHomeworkid()%></td>
            <td><%=sh.getHomeworktitle()%></td>
            <td><%=sh.getHomeworkContent()%></td>
            <td><%=sh.getCreatetime()%></td>
        </tr>

        <%
                    /*
                    out.println(sh.getId());
                    out.println(sh.getStuid());
                    out.println(sh.getHomeworkid());
                    out.println(sh.getHomeworktitle());
                    out.println(sh.getHomeworkContent());
                    out.println(sh.getCreatetime());
                     */
                }
            }
        %>
    </table>
</fieldset>

<fieldset>
    <legend align="center">学生名单</legend>
    <table align="center" width="960" border="1"
           bgcolor="black" cellpadding="1" cellspacing="1">
        <tr align="center" height="30" bgcolor="#5f9ea0">
            <td>学生学号</td>
            <td>学生姓名</td>
        </tr>

        <%
            StudentJdbc stu=new StudentJdbc();
            List<Student> lists=(List<Student>) stu.selectAll();
            //List<StudentHomework> list=(List<StudentHomework>) request.getAttribute("list");

            if(null==lists||lists.size()<=0){
                System.out.println("None data.");
            }
            else{
                for (Student sh:lists){

        %>

        <tr align="center" bgcolor="white">
            <td><%=sh.getStuid()%></td>
            <td><%=sh.getStuname()%></td>
        </tr>

        <%
                    /*
                    out.println(sh.getId());
                    out.println(sh.getStuid());
                    out.println(sh.getHomeworkid());
                    out.println(sh.getHomeworktitle());
                    out.println(sh.getHomeworkContent());
                    out.println(sh.getCreatetime());
                     */
                }
            }
        %>
        <tr bgcolor="#5f9ea0">
            <td colspan="6" style="text-align: center;">
                <a href="/javaee06_war_exploded/addstu.jsp">添加学生</a>
            </td>
        </tr>


    </table>
</fieldset>

<fieldset>
    <legend align="center">布置作业</legend>
    <table align="center" width="960" border="1"
           bgcolor="black" cellpadding="1" cellspacing="1">
        <tr align="center" height="30" bgcolor="#5f9ea0">
            <td>作业编号</td>
            <td>作业题目</td>
        </tr>

        <%
            HomeworkJdbc homework=new HomeworkJdbc();
            List<Homework> listh=(List<Homework>) homework.selectAll();
            //List<StudentHomework> list=(List<StudentHomework>) request.getAttribute("list");

            if(null==listh||listh.size()<=0){
                System.out.println("None data.");
            }
            else{
                for (Homework sh:listh){

        %>

        <tr align="center" bgcolor="white">
            <td><%=sh.getHomeworkid()%></td>
            <td><%=sh.getHomeworktitle()%></td>
        </tr>

        <%
                    /*
                    out.println(sh.getId());
                    out.println(sh.getStuid());
                    out.println(sh.getHomeworkid());
                    out.println(sh.getHomeworktitle());
                    out.println(sh.getHomeworkContent());
                    out.println(sh.getCreatetime());
                     */
                }
            }
        %>
        <tr bgcolor="#5f9ea0">
            <td colspan="6" style="text-align: center;">
                <a href="/javaee06_war_exploded/addhomework.jsp">布置作业</a>
            </td>
        </tr>


    </table>
</fieldset>
</body>
</html>
