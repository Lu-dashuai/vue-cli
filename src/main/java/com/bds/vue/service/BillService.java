package com.bds.vue.service;

import com.bds.vue.bean.Result;
import com.bds.vue.dao.BillDao;
import com.bds.vue.dao.OrderDao;
import com.bds.vue.dao.UserDao;
import com.bds.vue.util.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * AUTHOR:Kevin Ding
 * TIME:2019/9/25
 * TODO:员工服务层
 */
@Service
public class BillService {
    @Autowired
    private BillDao billDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private UserDao userDao;

    public Result addBill(Map map) {
        Result res = new Result();
        try {
            //获取参数
            Map order = (Map)map.get("order");
            List joiner = (List)map.get("joiner");
            System.out.println("order:"+order);
            String order_n = order.get("order_no")+"";
            long order_no = Long.parseLong(order_n);
            String promoter_id = order.get("promoter_id")+"";
            String order_moneys = order.get("order_money")+"";
            BigDecimal money = new BigDecimal(order_moneys);
            BigDecimal size = new BigDecimal(joiner.size());
            BigDecimal bill_money = money.divide(size, 2, BigDecimal.ROUND_HALF_UP);
            String order_status = order.get("order_status")+"";
            String info = order.get("info")+"";
            String promoter_name = order.get("user_name")+"";
            ///1.先删除该订单下的所有账单
            billDao.deleteBillByOrderNo(order_no);
            List<Map> usernameByid = userDao.getUsernameByid(joiner);
//            System.out.println("username:"+usernameByid);
            new EmailUtil(order,joiner,usernameByid,bill_money+"");

            //2.组织对象作为参数插入
            if (joiner!=null&&joiner.size()>0){
                for (int i=0;i<joiner.size();i++){
                    String joiner_id = joiner.get(i)+"";
                    Map param = new HashMap();
                    String bill_id = order_no + joiner_id;
                    param.put("bill_id",bill_id);
                    param.put("order_no",order_no);
                    param.put("promoter_id",promoter_id);
                    param.put("joiner_id",joiner_id);
                    param.put("bill_money",bill_money);
                    param.put("bill_status",2);//更改账单状态为立项
                    param.put("info",info);
                    param.put("create_time",new Date());
                    param.put("order_money",money);
                    //执行插入
                    billDao.addBill(param);
                }
                //3 更改订单状态为立项
                orderDao.updateOrderStatus(2,order_no);
            }
            res.setCode(200);
        }catch (Exception e){
            e.printStackTrace();
            res.setCode(500);
        }
        return res;
    }

}