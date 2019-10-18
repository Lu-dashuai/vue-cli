package com.bds.vue.controller;

import com.bds.vue.bean.Result;
import com.bds.vue.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * AUTHOR:Kevin Ding
 * TIME:2019/9/25
 * TODO:员工控制层
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    /**
     * 查询员工信息
     * @param param 分页参数+字段参数
     * @return
     */
    @RequestMapping(value = "/getData",method = POST, produces = "application/json")
    public Map toData(@RequestBody Map param){
        System.out.println(userService.getAll(param));
        return userService.getAll(param);
    }

    /**
     * 添加员工信息
     * @param map 字段
     * @return
     */
    @RequestMapping(value = "/addUser",method = POST, produces = "application/json")
    public Object addUser(@RequestBody Map map){
        map.put("create_time",new Date());
        Result result = userService.addUser(map);
        return result;
    }
    /**
     * 更改员工信息
     * @param map 字段
     * @return
     */
    @RequestMapping(value = "/updateUser",method = POST, produces = "application/json")
    public Object updateUser(@RequestBody Map map){
        map.put("create_time",new Date());
        Result result = userService.updateUser(map);
        return result;
    }


    /**
     * 批量删除
     * @return
     */
    @RequestMapping(value = "/deleteUser",method = GET)
    public Object deleteUser(@RequestParam Map<String,String> map){
        String ids = map.get("ids")+"";
        System.out.println("---------"+ids);
        Result result = userService.deleteUser(ids);
        return result;

    }


/**
 * Post:
 *
 * @RequestBody Map param
 *
 *
 *
 *
 * Get:
 *
 *  @RequestParam(required = false) Map param
 */

}