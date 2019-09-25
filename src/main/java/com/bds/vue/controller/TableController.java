package com.bds.vue.controller;

import com.bds.vue.bean.Result;
import com.bds.vue.service.TableService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * AUTHOR:Kevin Ding
 * TIME:2019/9/25
 * TODO:table
 */
@Controller
@RequestMapping("header/")
public class TableController {
    @Autowired
    private TableService service;

    @RequestMapping("toData")
    @ResponseBody
    public Result toData(Map info){
        System.out.println("#########"+info.get("info"));
        return service.getData(info);
    }

}