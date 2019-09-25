package com.bds.vue.dao;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * AUTHOR:Kevin Ding
 * TIME:2019/9/25
 * TODO:表头
 */
@Component
public interface TableDao {
    List getAll(Map info);

    Integer getCount(Map info);

}