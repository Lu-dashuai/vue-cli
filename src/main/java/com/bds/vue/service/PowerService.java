package com.bds.vue.service;

import com.bds.vue.bean.Power;
import com.bds.vue.bean.Tree;
import com.bds.vue.dao.PowerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * className:PowerController
 * discription:
 * author:luRuiHua
 * createTime:2019-09-23 17:46
 */
@Service
public class PowerService {
    @Autowired
    private PowerDao powerDao;

    public List<Tree> getPower(){
        //创建一个空的List<Power>存放要返回的json
        List<Tree> tree_list = new ArrayList<>();

        List<Power> powers = powerDao.getPower();//获取数据库整个power

        if (powers != null && powers.size() > 0){
            for (int i = 0; i < powers.size(); i++){
//                System.out.println(powers.get(i));
                Power power =  powers.get(i);
                int parentid = power.getParentid();
                if (parentid==0){//筛选父节点
                    Tree tree = new Tree();
                    tree.setId(power.getId());
                    tree.setName(power.getName());
                    tree.setIconcls(power.getIconcls());
                    tree.setStatus(power.getStatus());
                    tree.setParentid(power.getParentid());
                    tree.setUrl(power.getUrl());
                    tree.setChilds(new ArrayList<Power>());
                    tree_list.add(tree);
                    addChildPower(tree,powers);
                }
            }

        }
        return tree_list;
    }

    /**
     * 寻找孩子节点
     * @param tree 父节点
     * @param powers 所有数据
     */
    private void addChildPower(Tree tree, List<Power> powers) {
        for (Power childPower : powers){
            if (tree.getId()==childPower.getParentid()){
                List<Power> childs = tree.getChilds();
                childs.add(childPower);
            }
        }
    }

}
