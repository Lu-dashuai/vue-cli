package com.bds.vue.service;

import com.bds.vue.bean.User;
import com.bds.vue.dao.UserDao;
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

    public int addEmp(User user){
        return  userDao.addEmp(user);
    }

    public int updateEmp(User user){
        return userDao.updateEmp(user);
    }

    public int delEmp(int id){
        return userDao.delEmp(id);
    }

}