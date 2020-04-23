package com.spring.service;

import org.springframework.stereotype.Service;

@Service
public class JdbcService {

    public Long getByid(Long id){
        System.out.println("getById("+id+")");
        return id;
    }
}
