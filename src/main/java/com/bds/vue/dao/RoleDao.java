package com.bds.vue.dao;


import com.bds.vue.bean.Role;

import java.util.List;
import java.util.Map;

/**
 * AUTHOR:Kevin Ding
 * TIME:2019/9/25
 * TODO:表头
 */

public interface RoleDao {
    /**
     * 查询角色列表
     * @return
     */
    List<Role> getAll();


    void deleteRole(List<Integer> list);

    void addRole(Map map);

    void updateRole(Map map);
}