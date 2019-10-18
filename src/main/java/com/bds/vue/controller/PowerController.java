package com.bds.vue.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.bds.vue.bean.Power;
import com.bds.vue.bean.Result;
import com.bds.vue.bean.Tree;
import com.bds.vue.service.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

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
    @RequestMapping(value = "/getPower",method = RequestMethod.GET)
    public Object getPower(Integer role_id){
        System.out.println("role_id:"+role_id);
        List<Tree> trees = powerService.getPower(role_id);
        return trees;
    }
    @RequestMapping(value = "/addPower", method = POST, produces = "application/json")
    public Result addPower(@RequestBody Map map){
        System.out.println(map);
        return powerService.addPower(map);
    }
}
