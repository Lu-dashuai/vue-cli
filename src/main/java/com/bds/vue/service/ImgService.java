package com.bds.vue.service;

import com.bds.vue.dao.ImgDao;
import com.bds.vue.bean.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:ImgService
 * discription:
 * author:luRuiHua
 * createTime:2019-09-15 14:37
 */
@Service
public class ImgService {

    @Autowired
    private ImgDao imgDao;

    public Result getImg() {
        Result rst = new Result();
//        List<Img> geimg = imgDao.geimg();
//        System.out.println(geimg.get(0).getSrc());
        List geimg = getData();
        rst.setCode(200);
        rst.setData(geimg);
        return rst;
    }

    private ArrayList getData(){
        ArrayList data = new ArrayList();
        Map el1 = new HashMap();
        el1.put("id","1");
        el1.put("img","http://pic16.nipic.com/20111006/6239936_092702973000_2.jpg");
        el1.put("name","111");
        Map el2 = new HashMap();
        el2.put("id","2");
        el2.put("img","http://pic16.nipic.com/20111006/6239936_092702973000_2.jpg");
        el2.put("name","222");
        Map el3 = new HashMap();
        el3.put("id","3");
        el3.put("img","http://pic16.nipic.com/20111006/6239936_092702973000_2.jpg");
        el3.put("name","333");
        data.add(el1);
        data.add(el2);
        data.add(el3);
        return data;


    }
}
