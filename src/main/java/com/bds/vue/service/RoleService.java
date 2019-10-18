package com.bds.vue.service;

import com.bds.vue.bean.Result;
import com.bds.vue.bean.Role;
import com.bds.vue.dao.RoleDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * AUTHOR:Kevin Ding
 * TIME:2019/9/25
 * TODO:表头服务层
 */
@Service
public class RoleService {
    @Autowired
    private RoleDao dao;
    /**
     * 查询角色列表
     * @param
     * @return
     */
    public Map getData(Map param){
        Map info = new HashMap();
        int page_num = Integer.parseInt(param.get("page_num").toString()) ;
        int page_size = Integer.parseInt(param.get("page_size").toString());
        List role = new ArrayList<>();
        PageHelper.startPage(page_num,page_size);
        role = dao.getAll();
        PageInfo page = new PageInfo (role);
        PageHelper.startPage(page_num,page_size);
        info.put("data",role);
        info.put("total_count",page.getTotal());//总记录数
        info.put("page_count",page.getPages());//总页数
        info.put("page_num",page.getPageNum());//当前页数
        info.put("page_size",page.getPageSize());//当前页大小
        return info;
    }

    /**
     * 查询角色列表
     * @param
     * @return
     */
    public List getData(){
        List role = dao.getAll();
        return role;
    }

    public Result deleteRole(String ids) {
        Result res = new Result();
        List<Integer> list = new ArrayList<Integer>();
        try {
            String[] ids_arr = ids.split(",");
            for (int i=0;i<ids_arr.length;i++){
                int id = Integer.valueOf(ids_arr[i]);
                list.add(id);
            }
            dao.deleteRole(list);
            res.setCode(200);
        }catch (Exception e){
            e.printStackTrace();
            res.setCode(500);
        }
        return res;
    }
    public Result addRole(Map map) {
        Result res = new Result();
        try {
            dao.addRole(map);
            res.setCode(200);
        } catch (Exception e){
            e.printStackTrace();
            res.setCode(500);
        }
        return res;
    }
    public Result updateRole(Map map) {
        Result res = new Result();
        try {
            dao.updateRole(map);
            res.setCode(200);
        } catch (Exception e){
            e.printStackTrace();
            res.setCode(500);
        }
        return res;
    }
}