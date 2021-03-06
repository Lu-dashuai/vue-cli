package com.bds.vue.service;

import com.bds.vue.bean.Result;
import com.bds.vue.bean.User;
import com.bds.vue.dao.UserDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * AUTHOR:Kevin Ding
 * TIME:2019/9/25
 * TODO:员工服务层
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public Map getAll(Map param){

        Map info = new HashMap();
        int page_num = Integer.parseInt(param.get("page_num").toString()) ;
        int page_size = Integer.parseInt(param.get("page_size").toString());
        List user = new ArrayList<>();
        PageHelper.startPage(page_num,page_size);
        user = userDao.queryInfo(param);
        PageInfo   page = new PageInfo (user);
        PageHelper.startPage(page_num,page_size);

        info.put("data",user);
        info.put("total_count",page.getTotal());//总记录数
        info.put("page_count",page.getPages());//总页数
        info.put("page_num",page.getPageNum());//当前页数
        info.put("page_size",page.getPageSize());//当前页大小
        return info;

    }

    public Result addUser(Map map) {
        Result res = new Result();
        try {
            userDao.addUser(map);
            res.setCode(200);
        } catch (Exception e){
            e.printStackTrace();
            res.setCode(201);
            System.out.println("可能是违反唯一约束。。。。");
        }
        return res;
    }
    public Result updateUser(Map map) {
        Result res = new Result();
        try {
            userDao.updateUser(map);
            res.setCode(200);
        } catch (Exception e){
            e.printStackTrace();
            res.setCode(201);
            System.out.println("可能是违反唯一约束。。。。");
        }
        return res;
    }

    public Result deleteUser(String ids) {
        Result res = new Result();
        List<Integer> list = new ArrayList<Integer>();
        try {
            String[] ids_arr = ids.split(",");
            for (int i=0;i<ids_arr.length;i++){
                int id = Integer.valueOf(ids_arr[i]);
                list.add(id);
            }
            userDao.deleteUser(list);
            res.setCode(200);
        }catch (Exception e){
            e.printStackTrace();
            res.setCode(500);
        }
        return res;
    }
}