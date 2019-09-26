package com.bds.vue.bean;

import lombok.Data;

import java.util.Date;

/**
 * AUTHOR:Kevin Ding
 * TIME:2019/9/25
 * TODO:员工表POJO
 */
@Data
public class User {
    private Integer id;
    private String user_no;
    private String user_name;
    private String password;
    private String sex;
    private String card_id;
    private String email;
    private String tel;
    private String hobby;
    private Integer role_id;
    private Date create_time;
    private String info;

}