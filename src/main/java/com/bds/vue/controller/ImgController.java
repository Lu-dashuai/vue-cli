package com.bds.vue.controller;

import com.bds.vue.bean.Result;
import com.bds.vue.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * className:ImgController
 * discription:
 * author:luRuiHua
 * createTime:2019-09-15 14:36
 */
@RestController
@RequestMapping("/img")
public class ImgController {
    @Autowired
    private ImgService imgService;

    @RequestMapping("/getImg")
    public Object getImg(){
        Result rst = imgService.getImg();
        return rst;
    }
}
