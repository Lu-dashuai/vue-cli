package com.bds.vue.shiro;

import com.bds.vue.dao.UserDao;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:UserRealm
 * discription:
 * author:luRuiHua
 * createTime:2018-11-30 14:41
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserDao userDao;
    /**
     * 执行授权逻辑
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获取当前登陆的用户
        Subject subject = SecurityUtils.getSubject();
        //获取用户名
        String user_no = subject.getPrincipal()+"";
        //拼接参数
        Map map = new HashMap();
        map.put("user_no",user_no);
        //通过用户名查当前用户
        List<Map> maps = userDao.queryInfo(map);
        //获取当前的权限字符
        String role_name = maps.get(0).get("role_name")+"";
        //设置只有是这个字符才可以访问
        info.addStringPermission(role_name);


        return info;
    }

    /**
     * 执行认证逻辑
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //编写shiro判断逻辑，判断用户名密码是否正确
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        String user_no = token.getUsername();
        Map map = new HashMap();
        map.put("user_no",user_no);
        //通过用户名查当前用户
        //1.判断用户名
        List<Map> mapList = userDao.queryInfo(map);
        if (mapList.size() == 0) {
            return null;
        } else {
//            System.out.println(mapList.get(0));
            return new SimpleAuthenticationInfo(user_no, mapList.get(0).get("password"),"");
        }
    }
}
