package com.bds.vue.dao;

import com.bds.vue.bean.Img;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * className:ImgDao
 * discription:
 * author:luRuiHua
 * createTime:2019-09-15 14:37
 */
@Mapper
public interface ImgDao {
    @Select("select * from img")
    public List<Img> geimg();
}
