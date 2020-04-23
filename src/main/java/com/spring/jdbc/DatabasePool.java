package com.spring.jdbc;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Repository(value = "poolDao")
public class DatabasePool {

    private static HikariDataSource hikariDataSource;

    public static HikariDataSource getHikariDataSource(){

        if(null!=hikariDataSource){
            return hikariDataSource;
        }

        synchronized (DatabasePool.class){

            if(null==hikariDataSource){
                String url = "jdbc:mysql://localhost:3306/school?useSSL=false&serverTimezone=UTC";
                String driver = "com.mysql.cj.jdbc.Driver";
                HikariConfig hikariConfig=new HikariDataSource();
                hikariConfig.setUsername("root");
                hikariConfig.setPassword("000000");
                hikariConfig.setDriverClassName(driver);
                hikariConfig.setJdbcUrl(url);
                hikariDataSource=new HikariDataSource(hikariConfig);
                return hikariDataSource;
            }
        }
        return null;
    }

    public static void main(String[] args){
        while(true){
            getHikariDataSource();
            /*
            try {
                Thread.sleep(3000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
             */
        }
    }
}
