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

    void deletePowerByRole(Integer role_id);

    /**
     * 给菜单表添加
     * @param map
     */
    void addPowerTable(Map map);

    /**
     * 删除菜单
     * @param id
     */
    void delPower(Integer id);

    /**
     * 删除中间表通过power_id
     * @param id
     */
    void delRolePower(Integer id);

    List<Power> selectPowerByid(Integer id);
}
