package com.bds.vue.bean;

import lombok.Data;

import java.util.List;

/**
 * className:Tree
 * discription:
 * author:luRuiHua
 * createTime:2019-09-24 12:58
 */
@Data
public class Tree {
    private Integer id;
    private String title;
    private String status;
    private String iconcls;
    private String url;
    private Integer parentid;
    private List<Power> children;
}
