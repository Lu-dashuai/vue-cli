package com.bds.vue.controller;

import com.bds.vue.bean.Result;
import com.bds.vue.service.RoleService;
import com.bds.vue.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * AUTHOR:Kevin Ding
 * TIME:2019/9/25
 * TODO:table
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService service;

    /**
     * 查询角色列表
     * @param
     * @return
     */
    @RequestMapping(value = "/getRoleList",method = RequestMethod.POST)
    public Map toData(@RequestBody Map param){
        return service.getData(param);
    }

    /**
     * 员工弹出框使用
     * @param
     * @return
     */
    @RequestMapping(value = "/getRole",method = RequestMethod.GET)
    public List toData(){
        return service.getData();
    }
    /**
     * 批量删除
     * @return
     */
    @RequestMapping(value = "/deleteRole",method = RequestMethod.GET)
    public Object deleteUser(@RequestParam Map<String,String> map){
        String ids = map.get("ids")+"";
        System.out.println("---------"+ids);
        Result result = service.deleteRole(ids);
        return result;

    }
    /**
     * 添加员工信息
     * @param map 字段
     * @return
     */
    @RequestMapping(value = "/addRole",method = POST, produces = "application/json")
    public Object addRole(@RequestBody Map map){
        Result result = service.addRole(map);
        return result;
    }
    /**
     * 更改员工信息
     * @param map 字段
     * @return
     */
    @RequestMapping(value = "/updateRole",method = POST, produces = "application/json")
    public Object updateRole(@RequestBody Map map){
        Result result = service.updateRole(map);
        return result;
    }

}