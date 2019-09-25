package com.bds.vue.service;

import com.bds.vue.bean.User;
import com.bds.vue.dao.UserDao;
import com.github.pagehelper.PageHelper;
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

    public Map getAll(int page_num){
        Map info = new HashMap();
        List<User> user = new ArrayList<>();
        PageHelper.startPage(page_num,10);
        user = userDao.getAll();
        int total = userDao.getCount();
        info.put("data",user);
        info.put("total",total);
        return info;

    }

}