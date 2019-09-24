package com.bds.vue.dao;

import com.bds.vue.bean.Power;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * className:PowerDao
 * discription:
 * author:luRuiHua
 * createTime:2019-09-23 17:47
 */
@Mapper
public interface PowerDao {

    /**
     * 无条件获取权限菜单树
     */
    List<Power> getPower();
}
