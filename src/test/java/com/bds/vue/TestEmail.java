package com.bds.vue;


import io.github.isliqian.NiceEmail;
import org.junit.Before;
import org.junit.Test;

import javax.mail.MessagingException;
import java.io.File;

/**
 * className:TestEmail
 * discription:
 * author:luRuiHua
 * createTime:2019-10-23 12:14
 */
public class TestEmail {
    @Before
    public void before(){
        // 配置，一次即可：邮箱与密码
        NiceEmail.config(NiceEmail.SMTP_163(), "aluruihua@163.com", "aluruihua521");
    }

    /**
     * 测试发送文字
     * @throws MessagingException
     */
    @Test
    public void testSendText() throws MessagingException {
        NiceEmail.subject("这是一封测试TEXT邮件")//主题
                .from("寝室管理账单系统")//发件人昵称
                .to("aluruihua@163.com")//收件人
                .text("信件内容")//内容
                .send();//发送
    }

    /**
     * 测试发送Html
     * @throws MessagingException
     */
    @Test
    public void testSendHtml() throws MessagingException {
        NiceEmail.subject("寝室账单")
                .from("寝室管理系统")
                .to("aluruihua@163.com")
                //html内容即可
                .html("<h1>hi</h1>")
                .send();
    }

    /**
     * 测试附件邮件
     * @throws MessagingException
     */
    @Test
    public void testSendAttach() throws MessagingException {
        NiceEmail.subject("这是一封测试附件邮件")
                .from("LqNice")
                .to("51103942@qq.com")
                .html("<h1 font=red>信件内容</h1>")
                //附近的路径，以及名称
                .attach(new File("/Users/DELL/Pictures/Saved Pictures/000028.jpg"), "测试图片.jpeg")
                //名称可以不设置
                //.attach(new File("/Users/DELL/Pictures/Saved Pictures/000028.jpg"))
                .send();
    }
    /**
     * 测试发送验证码
     * @throws MessagingException
     */
    @Test
    public void testSendVerifcationCode() throws MessagingException{
        NiceEmail.subject("来自远方的验证码")
                .from("LqNice")
                .to("51103942@qq.com")
                //验证码长度为6，如果类型为null,验证码类型为数字英文混合验证码
                .verificationCode(6,null)
                //支持纯英文验证码
                //.verificationCode(4,verificationEnglishArrary)
                //如果验证码位数不配置，则按照6位验证码发送
                //.verificationCode(0,verificationNumberArrary)
                .send();

    }
}
