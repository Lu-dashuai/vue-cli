package com.bds.vue.service;

import com.bds.vue.bean.Code;
import com.bds.vue.bean.Result;
import com.bds.vue.bean.tb_table_header;
import com.bds.vue.dao.TableDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * AUTHOR:Kevin Ding
 * TIME:2019/9/25
 * TODO:表头服务层
 */
@Service
public class TableService {
    @Autowired
    private TableDao dao;

    public Result getData(Map info){
        Result res = new Result();
        List<tb_table_header> data = dao.getAll(info);
        Integer total = dao.getCount(info);
        res.setCode(Code.SUC);
        res.setData(data);
        res.setTotal(total);
        return res;
    }

}