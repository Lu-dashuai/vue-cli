package com.bds.vue.dao;

import com.bds.vue.bean.Result;
import com.bds.vue.bean.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * AUTHOR:Kevin Ding
 * TIME:2019/9/25
 * TODO:员工信息接口
 */
@Component
public interface UserDao {

    List<User> getAll(String user_no);

    Integer getCount();

    List queryInfo(Map info);

    void addUser(Map map);

    void updateUser(Map map);

    void deleteUser(List<Integer> list);

    List<Map> getUsernameByid(List list);
}
