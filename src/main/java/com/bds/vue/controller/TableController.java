package com.bds.vue.controller;

import com.bds.vue.bean.Result;
import com.bds.vue.service.TableService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * AUTHOR:Kevin Ding
 * TIME:2019/9/25
 * TODO:table
 */
@RestController
@RequestMapping("/header")
public class TableController {
    @Autowired
    private TableService service;

    @RequestMapping(value = "/toData",method = RequestMethod.GET)
    public Result toData(String info){
        System.out.println(info);

        return service.getData(info);
    }

}