package com.spring.jdbc;

import com.spring.core.StudentHomework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class StudentHomeworkJdbc {

    public List<StudentHomework> selectAll() {
        //定义连接数据库
        Connection con= null;
        try {
            con = DatabasePool.getHikariDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //要执行的SQL语句
        String sql = "select * from studenthomework";
        //创建集合
        List<StudentHomework> list = new ArrayList<>();
        //遍历查询结果集
        try {
            //创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();

            //ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);
            int id=0;
            int stuid=0;
            int homeid=0;

            while (rs.next()) {
                StudentHomework sh = new StudentHomework();
                sh.setId(rs.getInt("id"));
                sh.setStuid(rs.getInt("stuid"));
                sh.setHomeworkid(rs.getInt("homeworkid"));
                sh.setHomeworktitle(rs.getString("homeworktitle"));
                sh.setHomeworkContent(rs.getString("homeworkContent"));
                sh.setCreatetime(rs.getTimestamp("createtime"));
                //sh.setUpdatetime(rs.getTime("updatetime"))
                list.add(sh);

            }

        } catch (SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            System.out.println("数据库数据成功获取！！");
        }

        return list;
    }

    public void add(StudentHomework sh){
        //定义连接数据库
        Connection con= null;
        try {
            con = DatabasePool.getHikariDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //要执行的SQL语句
        String sql = "insert into studenthomework(stuid,homeworkid,homeworktitle,homeworkContent) values(?,?,?,?) ";

        try {
            //创建statement类对象，用来执行SQL语句！！
            PreparedStatement pst=con.prepareStatement(sql);
            pst.setInt(1,sh.getStuid());
            pst.setInt(2,sh.getHomeworkid());
            pst.setString(3,sh.getHomeworktitle());
            pst.setString(4,sh.getHomeworkContent());

            int count = pst.executeUpdate();
            pst.close();

        } catch (SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            System.out.println("数据库数据成功获取！！");
        }

    }

   public void main(String[] args) {
        List<StudentHomework> list=selectAll();
        for (StudentHomework sh:list){
            System.out.println(sh.getHomeworkContent());
        }
    }
}





