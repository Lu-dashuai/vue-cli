package com.bds.vue.service;

import com.bds.vue.bean.Power;
import com.bds.vue.bean.Result;
import com.bds.vue.bean.Tree;
import com.bds.vue.dao.PowerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public List<Tree> getPower(Integer role_id){
        //创建一个空的List<Power>存放要返回的json
        List<Tree> tree_list = new ArrayList<>();
        List<Power> powers = null;
        if (role_id==null){
            powers = powerDao.getPower();//获取数据库整个power
        }else{
            powers = powerDao.getPowerByRoleId(role_id);//获取数据库整个power
        }



        if (powers != null && powers.size() > 0){
            for (int i = 0; i < powers.size(); i++){
//                System.out.println(powers.get(i));
                Power power =  powers.get(i);
                int parentid = power.getParentid();
                if (parentid==0){//筛选父节点
                    Tree tree = new Tree();
                    tree.setId(power.getId());
                    tree.setTitle(power.getTitle());
                    tree.setIconcls(power.getIconcls());
                    tree.setStatus(power.getStatus());
                    tree.setParentid(power.getParentid());
                    tree.setUrl(power.getUrl());
                    tree.setChildren(new ArrayList<Power>());
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
                List<Power> childs = tree.getChildren();
                childs.add(childPower);
            }
        }
    }

    /**
     * 给权限中间表添加
     * @param map
     * @return
     */
    public Result addPower(Map map) {
        Result res = new Result();
        try {
            Integer role_id = Integer.valueOf(map.get("role_id") + "");
            ArrayList anIf = (ArrayList)map.get("_if");
//            List power_ids = new ArrayList();
            for (Object tree_obj: anIf){
                LinkedHashMap linkedHashMap = (LinkedHashMap)tree_obj;
                Integer id = Integer.valueOf(linkedHashMap.get("id")+"");
                Map param = new HashMap();
                param.put("power_id",id);
                param.put("role_id",role_id);
                powerDao.insertPowerId(param);
//                power_ids.add(id);
//                ArrayList children = (ArrayList)linkedHashMap.get("children");
//                if (children!=null&&children.size()>0){
//                    for (Object power_obj : children){
//                        LinkedHashMap power = (LinkedHashMap)power_obj;
//                        String id1 = power.get("id")+"";
//                        power_ids.add(id1);
//                    }
//                }
            }
//            System.out.println("需要添加的power_id:"+power_ids);
//            for (int i=0;i<power_ids.size();i++){
//                Integer id = Integer.valueOf(power_ids.get(i) + "");
//
//
//            }


            res.setCode(200);
        } catch (Exception e){
        }
        return res;

    }
}
