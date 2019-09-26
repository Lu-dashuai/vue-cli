package com.bds.vue.controller;

import com.bds.vue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * AUTHOR:Kevin Ding
 * TIME:2019/9/25
 * TODO:员工控制层
 */
@Controller
@RequestMapping("user/")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getData",method = POST, produces = "application/json")
    @ResponseBody
    public Map toData(@RequestParam Map param){
        return userService.getAll(param);
    }

}