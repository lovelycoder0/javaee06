package com.spring.core;

import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



public class Homework {
    private int homeworkid;
    private String homeworktitle;

    public int getHomeworkid() {
        return homeworkid;
    }

    public void setHomeworkid(int homeworkid) {
        this.homeworkid = homeworkid;
    }

    public String getHomeworktitle() {
        return homeworktitle;
    }

    public void setHomeworktitle(String homeworktitle) {
        this.homeworktitle = homeworktitle;
    }
}
