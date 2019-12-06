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
            powerDao.deletePowerByRole(role_id);
            ArrayList anIf = (ArrayList)map.get("_if");
//            List power_ids = new ArrayList();
            for (Object tree_obj: anIf){
                LinkedHashMap linkedHashMap = (LinkedHashMap)tree_obj;
                Integer id = Integer.valueOf(linkedHashMap.get("id")+"");
                Map param = new HashMap();
                param.put("power_id",id);
                param.put("role_id",role_id);
                try {
                    powerDao.insertPowerId(param);
                } catch (Exception e){

                }
            }
            for (Object tree_obj: anIf){
                LinkedHashMap linkedHashMap = (LinkedHashMap)tree_obj;
                Integer id = Integer.valueOf(linkedHashMap.get("parentid")+"");
                if (id!=0){
                    Map param = new HashMap();
                    param.put("power_id",id);
                    param.put("role_id",role_id);
                    try {
                        powerDao.insertPowerId(param);
                    } catch (Exception e){

                    }

                }
            }
            res.setCode(200);
        } catch (Exception e){
        }
        return res;

    }

    /**
     * 给菜单表添加菜单
     * @param map
     * @return
     */
    public void addPowerTable(Map map) {
        boolean status = Boolean.valueOf(map.get("switch").toString());
        if (status){
            map.put("status","open");
        }else {
            map.put("status","close");
        }
        powerDao.addPowerTable(map);
    }

    /**
     * 删除节点
     * @param id
     */
    public void delPower(Integer id) {
        //需要删除菜单表的 id 和 parentid 都为id 的数据

        //需要删除中间表的冗余数据【
        // 1. power_id 为id的
        // 2. 如果power_id为父id则要删除power_id为父id底下id的数据
        // 】
        List<Power> powers = powerDao.selectPowerByid(id);
        if (powers.size()!=0){
            for (Power power:powers){
                Integer id1 = power.getId();
                powerDao.delRolePower(id1);
            }
        }
        powerDao.delRolePower(id);
        powerDao.delPower(id);
    }
}
