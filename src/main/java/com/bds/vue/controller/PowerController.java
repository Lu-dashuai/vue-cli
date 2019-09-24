package com.bds.vue.controller;

import com.bds.vue.bean.Power;
import com.bds.vue.bean.Tree;
import com.bds.vue.service.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * className:PowerController
 * discription:
 * author:luRuiHua
 * createTime:2019-09-23 17:46
 */
@RestController
@RequestMapping("/power")
public class PowerController {
    @Autowired
    PowerService powerService;
    /**
     * 无条件查询权限菜单树
     */

//    @RequestMapping(value = "/article/{id}", method = DELETE, produces = "application/json")
//    @PathVariable这个注解，也是Spring MVC提供的，其作用是表示该变量的值是从访问路径中获取。
    @RequestMapping(value = "/getPower", method = GET, produces = "application/json")
    public Object getPower(){
        List<Tree> trees = powerService.getPower();
        return trees;
    }
}
