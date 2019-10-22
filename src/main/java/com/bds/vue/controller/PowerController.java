package com.bds.vue.controller;

import com.bds.vue.bean.Result;
import com.bds.vue.bean.Tree;
import com.bds.vue.bean.User;
import com.bds.vue.dao.UserDao;
import com.bds.vue.service.PowerService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * className:PowerController
 * discription:
 * author:luRuiHua
 * createTime:2019-09-23 17:46
 */
@RestController
@RequestMapping("/power")
public class PowerController {
    @Autowired
    PowerService powerService;
    @Autowired
    UserDao userDao;

//    @RequestMapping(value = "/article/{id}", method = DELETE, produces = "application/json")
//    @PathVariable这个注解，也是Spring MVC提供的，其作用是表示该变量的值是从访问路径中获取。

    /**
     * 查询权限菜单树
     * @param role_id if null 查询所有
     *                if not null 查询对应role_id的权限
     * @return
     */
    @RequestMapping(value = "/getPower",method = RequestMethod.GET)
    public Object getPower(Integer role_id){
        List<Tree> trees = powerService.getPower(role_id);
        return trees;
    }

    /**
     * 获取role_id
     * @param
     * @return
     */
    @RequestMapping(value = "/getSessionRoleId",method = RequestMethod.GET)
    public Result getSessionRoleId(HttpSession session){
        Result res = new Result();
        User user = (User)session.getAttribute("user");
        if (user==null){
            res.setCode(404);
            res.setMsg("未登录");
            return res;
        }
        res.setCode(200);
        res.setData(user);
        return res;
    }


    /**
     * 给权限菜单树的中间表添加
     *      先删除该role_id对应的中间表的所有权限
     *      再添加选中的权限
     * @param map
     * @return
     */
    @RequestMapping(value = "/addPower", method = POST, produces = "application/json")
    public Result addPower(@RequestBody Map map){
        return powerService.addPower(map);
    }

    /**
     * 注销方法
     * @param session
     * @return
     */
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public Result logout(HttpSession session){
        Result res = new Result();
        session.removeAttribute("user");
        res.setCode(200);
        return res;
    }
    /**
     * 登陆方法
     * @param map
     * @return
     */
    @RequestMapping(value = "/login", method = POST)
    public Result login(@RequestBody Map map,HttpSession session){
        Result res = new Result();
        String user_no = map.get("user_no")+"";
        String password = map.get("password")+"";

        System.out.println(user_no);
        //通过用户名查当前用户
        //1.判断用户名
        List<User> mapList = userDao.getAll(user_no);
        User user = mapList.get(0);
        session.setAttribute("user",user);

        //shiro的关键代码，执行认证功能
        // 1.获取subject
        Subject subject = SecurityUtils.getSubject();
        //2.封装用户数据
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user_no, password);
        //3.执行登陆方法
        try {
            //登陆成功
            subject.login(usernamePasswordToken);
            res.setCode(200);
            res.setMsg("登陆成功");
            //跳到欢迎页面
        } catch (UnknownAccountException e) {
            //用户名不存在的异常
            res.setCode(404);
            res.setMsg("用户名不存在");
        } catch (IncorrectCredentialsException e) {
            //用户名不存在的异常
            res.setCode(500);
            res.setMsg("用户名和密码错误");
        }

        return res;
    }
}
