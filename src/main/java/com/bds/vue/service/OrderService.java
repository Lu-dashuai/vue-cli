package com.bds.vue.service;

import com.bds.vue.bean.Result;
import com.bds.vue.bean.Status;
import com.bds.vue.dao.OrderDao;
import com.bds.vue.dao.UserDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * AUTHOR:Kevin Ding
 * TIME:2019/9/25
 * TODO:员工服务层
 */
@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;

    public Map getAll(Map param){

        Map<String,Object> info = new HashMap();
        int page_num = Integer.parseInt(param.get("page_num").toString()) ;
        int page_size = Integer.parseInt(param.get("page_size").toString());
        List<Map> order = new ArrayList<>();
        PageHelper.startPage(page_num,page_size);
        order = orderDao.queryInfo(param);
        for (Map map : order){
            String order_status = map.get("order_status") + "";
            order_status = Status.getDescByValue(order_status);
            map.put("order_status",order_status);
        }
        System.out.println(order);
        PageInfo   page = new PageInfo (order);
        PageHelper.startPage(page_num,page_size);

        info.put("data",order);
        info.put("total_count",page.getTotal());//总记录数
        info.put("page_count",page.getPages());//总页数
        info.put("page_num",page.getPageNum());//当前页数
        info.put("page_size",page.getPageSize());//当前页大小
        return info;

    }

    public Result addOrder(Map map) {
        Result res = new Result();
        try {
            String order_status = map.get("order_status") + "";
            Integer status = Status.getValueByDesc(order_status);
            map.put("order_status",status);
            orderDao.addOrder(map);
            res.setCode(200);
        } catch (Exception e){
            e.printStackTrace();
            res.setCode(201);
            System.out.println("可能是违反唯一约束。。。。");
        }
        return res;
    }
    public Result updateOrder(Map map) {
        Result res = new Result();
        try {
            String date = map.get("create_time")+"";
            date = date.replace("Z", " UTC");//注意是空格+UTC
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");//注意格式化的表达式
            Date d = format.parse(date);
            map.put("create_time",d);
            String order_status = map.get("order_status") + "";
            Integer status = Status.getValueByDesc(order_status);
            map.put("order_status",status);
            orderDao.updateOrder(map);
            res.setCode(200);
        } catch (Exception e){
            e.printStackTrace();
            res.setCode(201);
            System.out.println("可能是违反唯一约束。。。。");
        }
        return res;
    }
//
    public Result deleteOrder(String ids) {
        Result res = new Result();
        List<Integer> list = new ArrayList<Integer>();
        try {
            String[] ids_arr = ids.split(",");
            for (int i=0;i<ids_arr.length;i++){
                int id = Integer.valueOf(ids_arr[i]);
                list.add(id);
            }
            orderDao.deleteOrder(list);
            res.setCode(200);
        }catch (Exception e){
            e.printStackTrace();
            res.setCode(500);
        }
        return res;
    }

}