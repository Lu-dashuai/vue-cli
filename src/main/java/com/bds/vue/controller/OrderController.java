package com.bds.vue.controller;

import com.bds.vue.bean.Result;
import com.bds.vue.service.OrderService;
import com.bds.vue.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * AUTHOR:Kevin Ding
 * TIME:2019/9/25
 * TODO:员工控制层
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    /**
     * 查询订单信息
     * @param param 分页参数+字段参数
     * @return
     */
    @RequestMapping(value = "/getData",method = POST, produces = "application/json")
    public Map toData(@RequestBody Map param){
//        System.out.println(userService.getAll(param));
        return orderService.getAll(param);
    }

    /**
     * 添加订单信息
     * @param map 字段
     * @return
     */
    @RequestMapping(value = "/addOrder",method = POST, produces = "application/json")
    public Object addOrder(@RequestBody Map map){
        map.put("create_time",new Date());
        Result result = orderService.addOrder(map);
        return result;
    }
    /**
     * 更改订单
     * @param map 字段
     * @return
     */
    @RequestMapping(value = "/updateOrder",method = POST, produces = "application/json")
    public Object updateOrder(@RequestBody Map map){
//        map.put("create_time",new Date());

        System.out.println("更改："+map);
        Result result = orderService.updateOrder(map);
        return result;
    }
//
//
    /**
     * 批量删除
     * @return
     */
    @RequestMapping(value = "/deleteOrder",method = GET)
    public Object deleteOrder(@RequestParam Map<String,String> map){
        String ids = map.get("ids")+"";
        System.out.println("---------"+ids);
        Result result = orderService.deleteOrder(ids);
        return result;
    }



/**
 * Post:
 *
 * @RequestBody Map param
 *
 *
 *
 *
 * Get:
 *
 *  @RequestParam(required = false) Map param
 */

}