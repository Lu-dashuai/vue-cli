package com.bds.vue.controller;

import com.bds.vue.bean.User;
import com.bds.vue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * AUTHOR:Kevin Ding
 * TIME:2019/9/25
 * TODO:员工控制层
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getData",method = POST, produces = "application/json")
    public Map toData(@RequestBody Map param){
        return userService.getAll(param);
    }

    @RequestMapping(value = "/add",method = POST,produces = "application/json")
    public int addEmp(@RequestBody User user){
        return userService.addEmp(user);
    }

    @RequestMapping(value = "/update",method = POST,produces = "application/json")
    public int updateEmp(@RequestBody User user){
        return userService.updateEmp(user);
    }

    @RequestMapping(value = "/del",method = POST,produces = "application/json")
    public int delEmp(@RequestBody User user){
        return userService.delEmp(user.getId());
    }

}