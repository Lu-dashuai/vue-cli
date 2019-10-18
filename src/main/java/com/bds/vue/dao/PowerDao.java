package com.bds.vue.dao;

import com.bds.vue.bean.Power;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * className:PowerDao
 * discription:
 * author:luRuiHua
 * createTime:2019-09-23 17:47
 */
@Mapper
public interface PowerDao {


    List<Power> getPowerByRoleId(@Param("role_id")Integer role_id);
    /**
     * 无条件获取权限菜单树
     */
    List<Power> getPower();
    void insertPowerId(Map param);
}
