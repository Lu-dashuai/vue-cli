package com.bds.vue.dao;

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

    List<User> getAll();

    Integer getCount();

    /**
     * 获取员工表数据，含有查询分页
     * @param info
     * @return
     */
    List queryInfo(Map info);

    /**
     * 添加员工
     * @param user
     * @return
     */
    int addEmp(User user);

    /**
     * 修改员工系信息
     * @param user
     * @return
     */
    int updateEmp(User user);

    /**
     * 删除员工
     * @param id
     * @return
     */
    int delEmp(int id);
}
