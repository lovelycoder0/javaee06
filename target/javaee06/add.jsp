<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/3/8
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加</title>
</head>
<body>
<form action=/javaee06_war_exploded/list/add
      method=post>

    <table border="1" class="t1" align="center" style="margin-top: 100px">
        <tr>
            <td colspan="2"><h1>提交作业</h1></td>
        </tr>
        <tr>
            <td>学生学号:</td>
            <td><input  type="text" name="stuid"/></td>
        </tr>
        <tr>
            <td>作业编号:</td>
            <td><input  type="text" name="homeworkid"/></td>
        </tr>
        <tr>
            <td>作业标题:</td>
            <td><input  type="text" name="homeworktitle"/></td>
        </tr>
        <tr>
            <td>作业内容:</td>
            <td><input  type="text" name="homeworkContent"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input  type="submit" value="提交"/>
                <input  type="reset" value="清空"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
