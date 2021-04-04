package com.hc.crud.teacherlist.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Teacher {
    /*
    * @GeneratedValue 自增id
    * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String tel;
    private String department;
    private String gender;
    private String avatar;
    private String email;
    private String address;
    private String undergraduate;
    private String master;
    private String phd;
    private String github;
    private String bio;
    private String title;
    private String project;
    private String description;
    private String blog;
    private Boolean ieee;
    private String joinDate;
    private Integer rate;
    private Integer age;
    private String stack;
}
