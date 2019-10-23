package com.bds.vue.util;

import io.github.isliqian.NiceEmail;

import java.util.List;
import java.util.Map;

/**
 * className:EmailUtil
 * discription:
 * author:luRuiHua
 * createTime:2019-10-23 14:24
 */
public class EmailUtil {
    static {
        // 配置，一次即可：邮箱与密码
        NiceEmail.config(NiceEmail.SMTP_163(), "aluruihua@163.com", "aluruihua521");
    }


    private String order_no;
    private String bill_no;
    private String promoter_name;//收款方
    private String joiners_name;
    private String order_money;
    private String bill_money;
    private String create_time;

    public EmailUtil(Map order, List joiner,List<Map> joiner2,String bill_money) {

        try {
            StringBuilder sb = new StringBuilder("");
            for (int i=0;i<joiner.size();i++){
                sb.append(joiner2.get(i).get("user_name")+"|");
            }
            String joiners_name = sb.toString();
            for (int i=0;i<joiner.size();i++){
                String email = joiner2.get(i).get("email")+"";
                String joiner_id = joiner.get(i)+"";
                String order_no = order.get("order_no")+"";
                this.order_no = order_no;//1
                String bill_id = order.get("order_no")+joiner_id;
                this.bill_no = bill_id;//2
                String promoter_name = order.get("user_name")+"";
                this.promoter_name = promoter_name;//3
                String order_money = order.get("order_money")+"";
                this.order_money = order_money;//4
                this.bill_money = bill_money;//5
                String create_time = order.get("create_time")+"";
                this.create_time = create_time;//6
                this.joiners_name = joiners_name;
                String html = getHtml();

                NiceEmail.subject("寝室账单")
                        .from("寝室管理系统")
                        .to(email)
                        //html内容即可
                        .html(html)
                        .send();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private String getHtml() {
        String html = "<div class=\"content-wrap\"\n" +
                "    style=\"margin: 0px auto; overflow: hidden; padding-top: 15px; background-color: rgb(255, 255, 255); width: 600px;\">\n" +
                "    <!---->\n" +
                "    <div>\n" +
                "      <div style=\"margin: 0px auto; max-width: 600px;\">\n" +
                "        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                "          style=\"background-color: rgb(62, 207, 88); background-image: url(&quot;&quot;); background-repeat: no-repeat; background-size: 100px; background-position: 1% 50%;\">\n" +
                "          <tbody>\n" +
                "            <tr>\n" +
                "              <td style=\"direction: ltr; font-size: 0px; text-align: center; vertical-align: top; width: 600px;\">\n" +
                "                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "                  <tbody>\n" +
                "                    <tr>\n" +
                "                      <td\n" +
                "                        style=\"width: 50%; max-width: 50%; min-height: 1px; font-size: 13px; text-align: left; direction: ltr; vertical-align: top; padding: 0px;\">\n" +
                "                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"vertical-align: top;\">\n" +
                "                          <tbody>\n" +
                "                            <tr>\n" +
                "                              <td align=\"center\" style=\"font-size: 0px; word-break: break-word;\">\n" +
                "                                <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                  style=\"border-collapse: collapse; border-spacing: 0px; width: 100%;\">\n" +
                "                                  <tbody>\n" +
                "                                    <tr>\n" +
                "                                      <td>\n" +
                "                                        <!---->\n" +
                "                                      </td>\n" +
                "                                    </tr>\n" +
                "                                  </tbody>\n" +
                "                                </table>\n" +
                "                              </td>\n" +
                "                            </tr>\n" +
                "                          </tbody>\n" +
                "                        </table>\n" +
                "                      </td>\n";
                String html1 =
                "                      <td\n" +
                "                        style=\"width: 50%; max-width: 50%; min-height: 1px; font-size: 13px; text-align: left; direction: ltr; vertical-align: top; padding: 0px;\">\n" +
                "                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"vertical-align: top;\">\n" +
                "                          <tbody>\n" +
                "                            <tr>\n" +
                "                              <td align=\"center\" style=\"font-size: 0px; word-break: break-word;\">\n" +
                "                                <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                  style=\"border-collapse: collapse; border-spacing: 0px; width: 100%;\">\n" +
                "                                  <tbody>\n" +
                "                                    <tr>\n" +
                "                                      <td>\n" +
                "                                        <div class=\"full\">\n" +
                "                                          <div style=\"margin: 0px auto; max-width: 600px;\">\n" +
                "                                            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                              role=\"presentation\" style=\"width: 300px;\">\n" +
                "                                              <tbody>\n" +
                "                                                <tr>\n" +
                "                                                  <td\n" +
                "                                                    style=\"direction: ltr; width: 300px; font-size: 0px; padding-bottom: 0px; text-align: center; vertical-align: top;\">\n" +
                "                                                    <div\n" +
                "                                                      style=\"display: inline-block; vertical-align: top; width: 100%;\">\n" +
                "                                                      <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                                        role=\"presentation\" width=\"100%\" style=\"vertical-align: top;\">\n" +
                "                                                        <tbody>\n" +
                "                                                          <tr>\n" +
                "                                                            <td align=\"center\"\n" +
                "                                                              style=\"font-size: 0px; padding: 0px 10px; word-break: break-word;\">\n" +
                "                                                              <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                                                role=\"presentation\"\n" +
                "                                                                style=\"border-collapse: collapse; border-spacing: 0px;\">\n" +
                "                                                                <tbody>\n" +
                "                                                                  <tr>\n";
                String html2 =
                "                                                                    <td style=\"width: 280px; text-align: center;\">\n" +
                "                                                                      <div>\n" +
                "                                                                        <img height=\"auto\" width=\"NaN\" src=\"\n" +
                "                                     https://luruihua.oss-cn-beijing.aliyuncs.com/img/qinshi/mail-logo.png\"\n" +
                "                                                                          style=\"box-sizing: border-box; border: 0px; display: inline-block; outline: none; text-decoration: none; height: auto; width: auto; max-width: 100%; padding: 0px;\" />\n" +
                "                                                                      </div>\n" +
                "                                                                    </td>\n" +
                "                                                                  </tr>\n" +
                "                                                                </tbody>\n" +
                "                                                              </table>\n" +
                "                                                            </td>\n" +
                "                                                          </tr>\n" +
                "                                                        </tbody>\n" +
                "                                                      </table>\n" +
                "                                                    </div>\n" +
                "                                                  </td>\n" +
                "                                                </tr>\n" +
                "                                              </tbody>\n" +
                "                                            </table>\n" +
                "                                          </div>\n" +
                "                                        </div>\n" +
                "                                      </td>\n" +
                "                                    </tr>\n" +
                "                                  </tbody>\n" +
                "                                </table>\n" +
                "                              </td>\n" +
                "                            </tr>\n" +
                "                          </tbody>\n" +
                "                        </table>\n" +
                "                      </td>\n" ;
                String html3 =
                "                    </tr>\n" +
                "                  </tbody>\n" +
                "                </table>\n" +
                "              </td>\n" +
                "            </tr>\n" +
                "          </tbody>\n" +
                "        </table>\n" +
                "      </div>\n" +
                "    </div>\n" +
                "    <div class=\"full\">\n" +
                "      <div style=\"margin: 0px auto; max-width: 600px;\">\n" +
                "        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"width: 600px;\">\n" +
                "          <tbody>\n" +
                "            <tr>\n" +
                "              <td style=\"direction: ltr; font-size: 0px; padding-top: 0px; text-align: center; vertical-align: top;\">\n" +
                "                <div class=\"outlook-group-fix\"\n" +
                "                  style=\"font-size: 13px; text-align: left; direction: ltr; display: inline-block; vertical-align: top; width: 100%;\">\n" +
                "                  <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\"\n" +
                "                    style=\"vertical-align: top;\">\n" +
                "                    <tbody>\n" +
                "                      <tr>\n" +
                "                        <td align=\"center\" vertical-align=\"middle\"\n" +
                "                          style=\"padding-top: 40px; width: 600px; background-image: url(&quot;&quot;); background-size: 100px; background-position: 10% 50%; background-repeat: no-repeat;\">\n" +
                "                        </td>\n" +
                "                      </tr>\n" +
                "                    </tbody>\n" +
                "                  </table>\n" +
                "                </div>\n" +
                "              </td>\n" +
                "            </tr>\n" +
                "          </tbody>\n" +
                "        </table>\n" +
                "      </div>\n" ;
                String html4 =
                "    </div>\n" +
                "    <div class=\"full\">\n" +
                "      <div style=\"margin: 0px auto; max-width: 600px;\">\n" +
                "        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"width: 600px;\">\n" +
                "          <tbody>\n" +
                "            <tr>\n" +
                "              <td\n" +
                "                style=\"direction: ltr; width: 600px; font-size: 0px; padding-bottom: 0px; text-align: center; vertical-align: top; background-image: url(&quot;&quot;); background-repeat: no-repeat; background-size: 100px; background-position: 10% 50%;\">\n" +
                "                <div\n" +
                "                  style=\"font-size: 13px; text-align: left; direction: ltr; display: inline-block; vertical-align: top; width: 100%;\">\n" +
                "                  <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\"\n" +
                "                    style=\"vertical-align: top;\">\n" +
                "                    <tbody>\n" +
                "                      <tr>\n" +
                "                        <td align=\"left\" style=\"font-size: 0px; padding: 10px 20px; word-break: break-word;\">\n" +
                "                          <div class=\"text\"\n" +
                "                            style=\"margin: 0px; text-align: left; color: rgb(102, 102, 102); font-size: 12px;\">\n" +
                "                            <div>\n" +
                "                              <p style=\"line-height: 20px; margin: 0px;\"><span\n" +
                "                                  style=\"color: rgb(62, 58, 57);\">尊敬的用户：</span></p>\n" +
                "                            </div>\n" +
                "                          </div>\n" +
                "                        </td>\n" +
                "                      </tr>\n" +
                "                    </tbody>\n" +
                "                  </table>\n" +
                "                </div>\n" +
                "              </td>\n" +
                "            </tr>\n" +
                "          </tbody>\n" +
                "        </table>\n" +
                "      </div>\n" +
                "    </div>\n" +
                "    <div class=\"full\">\n" +
                "      <div style=\"margin: 0px auto; max-width: 600px;\">\n" +
                "        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"width: 600px;\">\n" +
                "          <tbody>\n" +
                "            <tr>\n" +
                "              <td\n" +
                "                style=\"direction: ltr; width: 600px; font-size: 0px; padding-bottom: 0px; text-align: center; vertical-align: top; background-image: url(&quot;&quot;); background-repeat: no-repeat; background-size: 100px; background-position: 10% 50%;\">\n" +
                "                <div\n" +
                "                  style=\"font-size: 13px; text-align: left; direction: ltr; display: inline-block; vertical-align: top; width: 100%;\">\n" +
                "                  <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\"\n" +
                "                    style=\"vertical-align: top;\">\n" +
                "                    <tbody>\n" +
                "                      <tr>\n" +
                "                        <td align=\"left\" style=\"font-size: 0px; padding: 6px 20px; word-break: break-word;\">\n" +
                "                          <div class=\"text\"\n" +
                "                            style=\"margin: 0px; text-align: left; color: rgb(62, 207, 88); font-size: 21px;\">\n" +
                "                            <div>\n" +
                "                              <p style=\"line-height: 20px; margin: 0px;\">您收到一份账单，请与室友联系后，尽快付清。</p>\n" +
                "                            </div>\n" +
                "                          </div>\n" +
                "                        </td>\n" +
                "                      </tr>\n" +
                "                    </tbody>\n" +
                "                  </table>\n" +
                "                </div>\n" +
                "              </td>\n" +
                "            </tr>\n" ;
                String html5 =
                "          </tbody>\n" +
                "        </table>\n" +
                "      </div>\n" +
                "    </div>\n" +
                "    <div class=\"full\">\n" +
                "      <div style=\"margin: 0px auto; max-width: 600px;\">\n" +
                "        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"width: 600px;\">\n" +
                "          <tbody>\n" +
                "            <tr>\n" +
                "              <td style=\"direction: ltr; font-size: 0px; padding-top: 0px; text-align: center; vertical-align: top;\">\n" +
                "                <div class=\"outlook-group-fix\"\n" +
                "                  style=\"font-size: 13px; text-align: left; direction: ltr; display: inline-block; vertical-align: top; width: 100%;\">\n" +
                "                  <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\"\n" +
                "                    style=\"vertical-align: top;\">\n" +
                "                    <tbody>\n" +
                "                      <tr>\n" +
                "                        <td align=\"center\" vertical-align=\"middle\"\n" +
                "                          style=\"padding-top: 15px; width: 600px; background-image: url(&quot;&quot;); background-size: 100px; background-position: 10% 50%; background-repeat: no-repeat;\">\n" +
                "                        </td>\n" +
                "                      </tr>\n" +
                "                    </tbody>\n" +
                "                  </table>\n" +
                "                </div>\n" +
                "              </td>\n" +
                "            </tr>\n" +
                "          </tbody>\n" +
                "        </table>\n" +
                "      </div>\n" +
                "    </div>\n" +
                "    <div class=\"full\">\n" +
                "      <div style=\"margin: 0px auto; max-width: 600px;\">\n" +
                "        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"width: 600px;\">\n" +
                "          <tbody>\n" +
                "            <tr>\n" +
                "              <td\n" +
                "                style=\"direction: ltr; width: 600px; font-size: 0px; padding-bottom: 0px; text-align: center; vertical-align: top; background-image: url(&quot;&quot;); background-repeat: no-repeat; background-size: 100px; background-position: 10% 50%;\">\n" +
                "                <div\n" +
                "                  style=\"font-size: 13px; text-align: left; direction: ltr; display: inline-block; vertical-align: top; width: 100%;\">\n" +
                "                  <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\"\n" +
                "                    style=\"vertical-align: top;\">\n" +
                "                    <tbody>\n" +
                "                      <tr>\n" +
                "                        <td align=\"left\" style=\"font-size: 0px; padding: 10px 20px; word-break: break-word;\">\n" +
                "                          <div class=\"text\"\n" +
                "                            style=\"margin: 0px; text-align: left; color: rgb(102, 102, 102); font-size: 12px;\">\n" +
                "                            <div>\n" +
                "                              <p style=\"line-height: 20px; margin: 0px;\"><span\n" +
                "                                  style=\"color: rgb(62, 58, 57);\">以下为您账单的重要信息，请注意保密：</span></p>\n" +
                "                            </div>\n" +
                "                          </div>\n" +
                "                        </td>\n" +
                "                      </tr>\n" +
                "                    </tbody>\n" +
                "                  </table>\n" +
                "                </div>\n" +
                "              </td>\n" ;
                String html6 =
                "            </tr>\n" +
                "          </tbody>\n" +
                "        </table>\n" +
                "      </div>\n" +
                "    </div>\n" +
                "    <!-- mj-column-per-25 -->\n" +
                "    <div>\n" +
                "      <div style=\"margin: 0px auto; max-width: 600px;\">\n" +
                "        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                "          style=\"background-color: rgb(241, 245, 240); background-image: url(&quot;&quot;); background-repeat: no-repeat; background-size: 100px; background-position: 1% 50%;\">\n" +
                "          <tbody>\n" +
                "            <tr>\n" +
                "              <td style=\"direction: ltr; font-size: 0px; text-align: center; vertical-align: top; width: 600px;\">\n" +
                "                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "                  <tbody>\n" +
                "                    <tr>\n" +
                "                      <td\n" +
                "                        style=\"width: 33.3333%; max-width: 33.3333%; min-height: 1px; font-size: 13px; text-align: left; direction: ltr; vertical-align: top; padding: 0px;\">\n" +
                "                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"vertical-align: top;\">\n" +
                "                          <tbody>\n" +
                "                            <tr>\n" +
                "                              <td align=\"center\" style=\"font-size: 0px; word-break: break-word;\">\n" +
                "                                <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                  style=\"border-collapse: collapse; border-spacing: 0px; width: 100%;\">\n" +
                "                                  <tbody>\n" +
                "                                    <tr>\n" +
                "                                      <td>\n" +
                "                                        <div columnnumber=\"3\">\n" +
                "                                          <div>\n" +
                "                                            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                              style=\"width: 100%;\">\n" +
                "                                              <tbody>\n" +
                "                                                <tr>\n" +
                "                                                  <td\n" +
                "                                                    style=\"direction: ltr; font-size: 0px; text-align: center; vertical-align: top; border: 0px;\">\n" +
                "                                                    <a target=\"_blank\" href=\"javascript:;\" style=\"cursor: default;\">\n" +
                "                                                      <div class=\"mj-column-per-25\"\n" +
                "                                                        style=\"width: 100%; max-width: 100%; font-size: 13px; text-align: left; direction: ltr; display: inline-block; vertical-align: top;\">\n" +
                "                                                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"\n" +
                "                                                          style=\"vertical-align: top;\">\n" +
                "                                                          <tbody>\n" +
                "                                                            <tr>\n" +
                "                                                              <td align=\"center\" border=\"0\"\n" +
                "                                                                style=\"font-size: 0px; word-break: break-word;\">\n" +
                "                                                                <table align=\"center\" border=\"0\" cellpadding=\"0\"\n" +
                "                                                                  cellspacing=\"0\"\n" +
                "                                                                  style=\"border-collapse: collapse; border-spacing: 0px; width: 100%;\">\n" +
                "                                                                  <tbody>\n" +
                "                                                                    <tr>\n" +
                "                                                                      <td border=\"0\">\n" +
                "                                                                        <div class=\"full\">\n" +
                "                                                                          <div\n" ;
                String html7 =
                "                                                                            style=\"margin: 0px auto; max-width: 600px;\">\n" +
                "                                                                            <table align=\"center\" border=\"0\"\n" +
                "                                                                              cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                                                              role=\"presentation\" style=\"width: 200px;\">\n" +
                "                                                                              <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                  <td\n" +
                "                                                                                    style=\"direction: ltr; width: 200px; font-size: 0px; padding-bottom: 0px; text-align: center; vertical-align: top; background-image: url(&quot;&quot;); background-repeat: no-repeat; background-size: 100px; background-position: 10% 50%;\">\n" +
                "                                                                                    <div\n" +
                "                                                                                      style=\"font-size: 13px; text-align: left; direction: ltr; display: inline-block; vertical-align: top; width: 100%;\">\n" +
                "                                                                                      <table border=\"0\" cellpadding=\"0\"\n" +
                "                                                                                        cellspacing=\"0\"\n" +
                "                                                                                        role=\"presentation\" width=\"100%\"\n" +
                "                                                                                        style=\"vertical-align: top;\">\n" +
                "                                                                                        <tbody>\n" +
                "                                                                                          <tr>\n" +
                "                                                                                            <td align=\"left\"\n" +
                "                                                                                              style=\"font-size: 0px; padding: 25px 20px; word-break: break-word;\">\n" +
                "                                                                                              <div class=\"text\"\n" +
                "                                                                                                style=\"margin: 0px; text-align: center; color: rgb(125, 125, 125); font-size: 12px;\">\n" +
                "                                                                                                <div>\n" +
                "                                                                                                  <p\n" +
                "                                                                                                    style=\"line-height: 20px; margin: 0px;\">\n" +
                "                                                                                                   订单号</p>\n" +
                "                                                                                                </div>\n" +
                "                                                                                              </div>\n" +
                "                                                                                            </td>\n" +
                "                                                                                          </tr>\n" +
                "                                                                                        </tbody>\n" +
                "                                                                                      </table>\n" +
                "                                                                                    </div>\n" +
                "                                                                                  </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                              </tbody>\n" +
                "                                                                            </table>\n" +
                "                                                                          </div>\n" +
                "                                                                        </div>\n" +
                "                                                                      </td>\n" +
                "                                                                    </tr>\n" +
                "                                                                  </tbody>\n" +
                "                                                                </table>\n" +
                "                                                              </td>\n" +
                "                                                            </tr>\n" +
                "                                                          </tbody>\n";
                String html8 =
                "                                                        </table>\n" +
                "                                                      </div>\n" +
                "                                                      <div class=\"mj-column-per-25\"\n" +
                "                                                        style=\"width: 100%; max-width: 100%; font-size: 13px; text-align: left; direction: ltr; display: inline-block; vertical-align: top;\">\n" +
                "                                                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"\n" +
                "                                                          style=\"vertical-align: top;\">\n" +
                "                                                          <tbody>\n" +
                "                                                            <tr>\n" +
                "                                                              <td align=\"center\" border=\"0\"\n" +
                "                                                                style=\"font-size: 0px; word-break: break-word;\">\n" +
                "                                                                <table align=\"center\" border=\"0\" cellpadding=\"0\"\n" +
                "                                                                  cellspacing=\"0\"\n" +
                "                                                                  style=\"border-collapse: collapse; border-spacing: 0px; width: 100%;\">\n" +
                "                                                                  <tbody>\n" +
                "                                                                    <tr>\n" +
                "                                                                      <td border=\"0\">\n" +
                "                                                                        <div class=\"full\">\n" +
                "                                                                          <div\n" +
                "                                                                            style=\"margin: 0px auto; max-width: 600px;\">\n" +
                "                                                                            <table align=\"center\" border=\"0\"\n" +
                "                                                                              cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                                                              role=\"presentation\" style=\"width: 200px;\">\n" +
                "                                                                              <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                  <td\n" +
                "                                                                                    style=\"direction: ltr; width: 200px; font-size: 0px; padding-bottom: 0px; text-align: center; vertical-align: top; background-image: url(&quot;&quot;); background-repeat: no-repeat; background-size: 100px; background-position: 10% 50%;\">\n" +
                "                                                                                    <div\n" +
                "                                                                                      style=\"font-size: 13px; text-align: left; direction: ltr; display: inline-block; vertical-align: top; width: 100%;\">\n" +
                "                                                                                      <table border=\"0\" cellpadding=\"0\"\n" +
                "                                                                                        cellspacing=\"0\"\n" +
                "                                                                                        role=\"presentation\" width=\"100%\"\n" +
                "                                                                                        style=\"vertical-align: top;\">\n" +
                "                                                                                        <tbody>\n" +
                "                                                                                          <tr>\n" +
                "                                                                                            <td align=\"left\"\n" +
                "                                                                                              style=\"font-size: 0px; padding: 25px 20px; word-break: break-word;\">\n" +
                "                                                                                              <div class=\"text\"\n" +
                "                                                                                                style=\"margin: 0px; text-align: center; color: rgb(125, 125, 125); font-size: 12px;\">\n" +
                "                                                                                                <div>\n" +
                "                                                                                                  <p\n" +
                "                                                                                                    style=\"line-height: 20px; margin: 0px;\">\n" +
                "                                                                                                    账单号</p>\n" +
                "                                                                                                </div>\n" +
                "                                                                                              </div>\n" +
                "                                                                                            </td>\n" +
                "                                                                                          </tr>\n" +
                "                                                                                        </tbody>\n" +
                "                                                                                      </table>\n" +
                "                                                                                    </div>\n" +
                "                                                                                  </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                              </tbody>\n" +
                "                                                                            </table>\n" +
                "                                                                          </div>\n" +
                "                                                                        </div>\n" +
                "                                                                      </td>\n" +
                "                                                                    </tr>\n" ;
                String html9 =
                "                                                                  </tbody>\n" +
                "                                                                </table>\n" +
                "                                                              </td>\n" +
                "                                                            </tr>\n" +
                "                                                          </tbody>\n" +
                "                                                        </table>\n" +
                "                                                      </div>\n" +
                "                                                      <div class=\"mj-column-per-25\"\n" +
                "                                                        style=\"width: 100%; max-width: 100%; font-size: 13px; text-align: left; direction: ltr; display: inline-block; vertical-align: top;\">\n" +
                "                                                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"\n" +
                "                                                          style=\"vertical-align: top;\">\n" +
                "                                                          <tbody>\n" +
                "                                                            <tr>\n" +
                "                                                              <td align=\"center\" border=\"0\"\n" +
                "                                                                style=\"font-size: 0px; word-break: break-word;\">\n" +
                "                                                                <table align=\"center\" border=\"0\" cellpadding=\"0\"\n" +
                "                                                                  cellspacing=\"0\"\n" +
                "                                                                  style=\"border-collapse: collapse; border-spacing: 0px; width: 100%;\">\n" +
                "                                                                  <tbody>\n" +
                "                                                                    <tr>\n" +
                "                                                                      <td border=\"0\">\n" +
                "                                                                        <div class=\"full\">\n" +
                "                                                                          <div\n" +
                "                                                                            style=\"margin: 0px auto; max-width: 600px;\">\n" +
                "                                                                            <table align=\"center\" border=\"0\"\n" +
                "                                                                              cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                                                              role=\"presentation\" style=\"width: 200px;\">\n" +
                "                                                                              <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                  <td\n" +
                "                                                                                    style=\"direction: ltr; width: 200px; font-size: 0px; padding-bottom: 0px; text-align: center; vertical-align: top; background-image: url(&quot;&quot;); background-repeat: no-repeat; background-size: 100px; background-position: 10% 50%;\">\n" +
                "                                                                                    <div\n" +
                "                                                                                      style=\"font-size: 13px; text-align: left; direction: ltr; display: inline-block; vertical-align: top; width: 100%;\">\n" +
                "                                                                                      <table border=\"0\" cellpadding=\"0\"\n" +
                "                                                                                        cellspacing=\"0\"\n" +
                "                                                                                        role=\"presentation\" width=\"100%\"\n" +
                "                                                                                        style=\"vertical-align: top;\">\n" +
                "                                                                                        <tbody>\n" +
                "                                                                                          <tr>\n" +
                "                                                                                            <td align=\"left\"\n" +
                "                                                                                              style=\"font-size: 0px; padding: 25px 20px; word-break: break-word;\">\n" +
                "                                                                                              <div class=\"text\"\n" +
                "                                                                                                style=\"margin: 0px; text-align: center; color: rgb(125, 125, 125); font-size: 12px;\">\n" +
                "                                                                                                <div>\n" +
                "                                                                                                  <p\n" +
                "                                                                                                    style=\"line-height: 20px; margin: 0px;\">\n" +
                "                                                                                                    收款方</p>\n" +
                "                                                                                                </div>\n" +
                "                                                                                              </div>\n" +
                "                                                                                            </td>\n" +
                "                                                                                          </tr>\n" +
                "                                                                                        </tbody>\n" +
                "                                                                                      </table>\n" +
                "                                                                                    </div>\n" +
                "                                                                                  </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                              </tbody>\n" +
                "                                                                            </table>\n" +
                "                                                                          </div>\n" +
                "                                                                        </div>\n" +
                "                                                                      </td>\n" +
                "                                                                    </tr>\n" +
                "                                                                  </tbody>\n" +
                "                                                                </table>\n" +
                "                                                              </td>\n" +
                "                                                            </tr>\n" +
                "                                                          </tbody>\n" ;
                String html10=
                "                                                        </table>\n" +
                "                                                      </div>\n" +
                "                                                      <div class=\"mj-column-per-25\"\n" +
                "                                                        style=\"width: 100%; max-width: 100%; font-size: 13px; text-align: left; direction: ltr; display: inline-block; vertical-align: top;\">\n" +
                "                                                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"\n" +
                "                                                          style=\"vertical-align: top;\">\n" +
                "                                                          <tbody>\n" +
                "                                                            <tr>\n" +
                "                                                              <td align=\"center\" border=\"0\"\n" +
                "                                                                style=\"font-size: 0px; word-break: break-word;\">\n" +
                "                                                                <table align=\"center\" border=\"0\" cellpadding=\"0\"\n" +
                "                                                                  cellspacing=\"0\"\n" +
                "                                                                  style=\"border-collapse: collapse; border-spacing: 0px; width: 100%;\">\n" +
                "                                                                  <tbody>\n" +
                "                                                                    <tr>\n" +
                "                                                                      <td border=\"0\">\n" +
                "                                                                        <div class=\"full\">\n" +
                "                                                                          <div\n" +
                "                                                                            style=\"margin: 0px auto; max-width: 600px;\">\n" +
                "                                                                            <table align=\"center\" border=\"0\"\n" +
                "                                                                              cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                                                              role=\"presentation\" style=\"width: 200px;\">\n" +
                "                                                                              <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                  <td\n" +
                "                                                                                    style=\"direction: ltr; width: 200px; font-size: 0px; padding-bottom: 0px; text-align: center; vertical-align: top; background-image: url(&quot;&quot;); background-repeat: no-repeat; background-size: 100px; background-position: 10% 50%;\">\n" +
                "                                                                                    <div\n" +
                "                                                                                      style=\"font-size: 13px; text-align: left; direction: ltr; display: inline-block; vertical-align: top; width: 100%;\">\n" +
                "                                                                                      <table border=\"0\" cellpadding=\"0\"\n" +
                "                                                                                        cellspacing=\"0\"\n" +
                "                                                                                        role=\"presentation\" width=\"100%\"\n" +
                "                                                                                        style=\"vertical-align: top;\">\n" +
                "                                                                                        <tbody>\n" +
                "                                                                                          <tr>\n" +
                "                                                                                            <td align=\"left\"\n" +
                "                                                                                              style=\"font-size: 0px; padding: 25px 20px; word-break: break-word;\">\n" +
                "                                                                                              <div class=\"text\"\n" +
                "                                                                                                style=\"margin: 0px; text-align: center; color: rgb(125, 125, 125); font-size: 12px;\">\n" +
                "                                                                                                <div>\n" +
                "                                                                                                  <p\n" +
                "                                                                                                    style=\"line-height: 20px; margin: 0px;\">\n" +
                "                                                                                                    参与人</p>\n" +
                "                                                                                                </div>\n" +
                "                                                                                              </div>\n" +
                "                                                                                            </td>\n" +
                "                                                                                          </tr>\n" +
                "                                                                                        </tbody>\n" +
                "                                                                                      </table>\n" +
                "                                                                                    </div>\n" +
                "                                                                                  </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                              </tbody>\n" +
                "                                                                            </table>\n" +
                "                                                                          </div>\n" +
                "                                                                        </div>\n" +
                "                                                                      </td>\n" +
                "                                                                    </tr>\n" +
                "                                                                  </tbody>\n" +
                "                                                                </table>\n" +
                "                                                              </td>\n" +
                "                                                            </tr>\n" +
                "                                                          </tbody>\n" +
                "                                                        </table>\n" +
                "                                                      </div>\n" ;
                String html11 =
                "                                                      <div class=\"mj-column-per-25\"\n" +
                "                                                        style=\"width: 100%; max-width: 100%; font-size: 13px; text-align: left; direction: ltr; display: inline-block; vertical-align: top;\">\n" +
                "                                                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"\n" +
                "                                                          style=\"vertical-align: top;\">\n" +
                "                                                          <tbody>\n" +
                "                                                            <tr>\n" +
                "                                                              <td align=\"center\" border=\"0\"\n" +
                "                                                                style=\"font-size: 0px; word-break: break-word;\">\n" +
                "                                                                <table align=\"center\" border=\"0\" cellpadding=\"0\"\n" +
                "                                                                  cellspacing=\"0\"\n" +
                "                                                                  style=\"border-collapse: collapse; border-spacing: 0px; width: 100%;\">\n" +
                "                                                                  <tbody>\n" +
                "                                                                    <tr>\n" +
                "                                                                      <td border=\"0\">\n" +
                "                                                                        <div class=\"full\">\n" +
                "                                                                          <div\n" +
                "                                                                            style=\"margin: 0px auto; max-width: 600px;\">\n" +
                "                                                                            <table align=\"center\" border=\"0\"\n" +
                "                                                                              cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                                                              role=\"presentation\" style=\"width: 200px;\">\n" +
                "                                                                              <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                  <td\n" +
                "                                                                                    style=\"direction: ltr; width: 200px; font-size: 0px; padding-bottom: 0px; text-align: center; vertical-align: top; background-image: url(&quot;&quot;); background-repeat: no-repeat; background-size: 100px; background-position: 10% 50%;\">\n" +
                "                                                                                    <div\n" +
                "                                                                                      style=\"font-size: 13px; text-align: left; direction: ltr; display: inline-block; vertical-align: top; width: 100%;\">\n" +
                "                                                                                      <table border=\"0\" cellpadding=\"0\"\n" +
                "                                                                                        cellspacing=\"0\"\n" +
                "                                                                                        role=\"presentation\" width=\"100%\"\n" +
                "                                                                                        style=\"vertical-align: top;\">\n" +
                "                                                                                        <tbody>\n" +
                "                                                                                          <tr>\n" +
                "                                                                                            <td align=\"left\"\n" +
                "                                                                                              style=\"font-size: 0px; padding: 25px 20px; word-break: break-word;\">\n" +
                "                                                                                              <div class=\"text\"\n" +
                "                                                                                                style=\"margin: 0px; text-align: center; color: rgb(125, 125, 125); font-size: 12px;\">\n" +
                "                                                                                                <div>\n" +
                "                                                                                                  <p\n" +
                "                                                                                                    style=\"line-height: 20px; margin: 0px;\">\n" +
                "                                                                                                    订单金额</p>\n" +
                "                                                                                                </div>\n" +
                "                                                                                              </div>\n" +
                "                                                                                            </td>\n" +
                "                                                                                          </tr>\n" +
                "                                                                                        </tbody>\n" +
                "                                                                                      </table>\n" +
                "                                                                                    </div>\n" +
                "                                                                                  </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                              </tbody>\n" +
                "                                                                            </table>\n" +
                "                                                                          </div>\n" +
                "                                                                        </div>\n" +
                "                                                                      </td>\n" +
                "                                                                    </tr>\n" +
                "                                                                  </tbody>\n" +
                "                                                                </table>\n" +
                "                                                              </td>\n" +
                "                                                            </tr>\n" +
                "                                                          </tbody>\n" ;
                String html12 =
                "                                                        </table>\n" +
                "                                                      </div>\n" +
                "                                                      <div class=\"mj-column-per-25\"\n" +
                "                                                        style=\"width: 100%; max-width: 100%; font-size: 13px; text-align: left; direction: ltr; display: inline-block; vertical-align: top;\">\n" +
                "                                                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"\n" +
                "                                                          style=\"vertical-align: top;\">\n" +
                "                                                          <tbody>\n" +
                "                                                            <tr>\n" +
                "                                                              <td align=\"center\" border=\"0\"\n" +
                "                                                                style=\"font-size: 0px; word-break: break-word;\">\n" +
                "                                                                <table align=\"center\" border=\"0\" cellpadding=\"0\"\n" +
                "                                                                  cellspacing=\"0\"\n" +
                "                                                                  style=\"border-collapse: collapse; border-spacing: 0px; width: 100%;\">\n" +
                "                                                                  <tbody>\n" +
                "                                                                    <tr>\n" +
                "                                                                      <td border=\"0\">\n" +
                "                                                                        <div class=\"full\">\n" +
                "                                                                          <div\n" +
                "                                                                            style=\"margin: 0px auto; max-width: 600px;\">\n" +
                "                                                                            <table align=\"center\" border=\"0\"\n" +
                "                                                                              cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                                                              role=\"presentation\" style=\"width: 200px;\">\n" +
                "                                                                              <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                  <td\n" +
                "                                                                                    style=\"direction: ltr; width: 200px; font-size: 0px; padding-bottom: 0px; text-align: center; vertical-align: top; background-image: url(&quot;&quot;); background-repeat: no-repeat; background-size: 100px; background-position: 10% 50%;\">\n" +
                "                                                                                    <div\n" +
                "                                                                                      style=\"font-size: 13px; text-align: left; direction: ltr; display: inline-block; vertical-align: top; width: 100%;\">\n" +
                "                                                                                      <table border=\"0\" cellpadding=\"0\"\n" +
                "                                                                                        cellspacing=\"0\"\n" +
                "                                                                                        role=\"presentation\" width=\"100%\"\n" +
                "                                                                                        style=\"vertical-align: top;\">\n" +
                "                                                                                        <tbody>\n" +
                "                                                                                          <tr>\n" +
                "                                                                                            <td align=\"left\"\n" +
                "                                                                                              style=\"font-size: 0px; padding: 25px 20px; word-break: break-word;\">\n" +
                "                                                                                              <div class=\"text\"\n" +
                "                                                                                                style=\"margin: 0px; text-align: center; color: rgb(125, 125, 125); font-size: 12px;\">\n" +
                "                                                                                                <div>\n" +
                "                                                                                                  <p\n" +
                "                                                                                                    style=\"line-height: 20px; margin: 0px;\">\n" +
                "                                                                                                    账单金额</p>\n" +
                "                                                                                                </div>\n" +
                "                                                                                              </div>\n" +
                "                                                                                            </td>\n" +
                "                                                                                          </tr>\n" +
                "                                                                                        </tbody>\n" +
                "                                                                                      </table>\n" +
                "                                                                                    </div>\n" +
                "                                                                                  </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                              </tbody>\n" +
                "                                                                            </table>\n" +
                "                                                                          </div>\n" +
                "                                                                        </div>\n" +
                "                                                                      </td>\n" +
                "                                                                    </tr>\n" +
                "                                                                  </tbody>\n" +
                "                                                                </table>\n" +
                "                                                              </td>\n" +
                "                                                            </tr>\n" +
                "                                                          </tbody>\n" +
                "                                                        </table>\n" +
                "                                                      </div>\n";
                String html13 =
                "                                                      <div class=\"mj-column-per-25\"\n" +
                "                                                        style=\"width: 100%; max-width: 100%; font-size: 13px; text-align: left; direction: ltr; display: inline-block; vertical-align: top;\">\n" +
                "                                                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"\n" +
                "                                                          style=\"vertical-align: top;\">\n" +
                "                                                          <tbody>\n" +
                "                                                            <tr>\n" +
                "                                                              <td align=\"center\" border=\"0\"\n" +
                "                                                                style=\"font-size: 0px; word-break: break-word;\">\n" +
                "                                                                <table align=\"center\" border=\"0\" cellpadding=\"0\"\n" +
                "                                                                  cellspacing=\"0\"\n" +
                "                                                                  style=\"border-collapse: collapse; border-spacing: 0px; width: 100%;\">\n" +
                "                                                                  <tbody>\n" +
                "                                                                    <tr>\n" +
                "                                                                      <td border=\"0\">\n" +
                "                                                                        <div class=\"full\">\n" +
                "                                                                          <div\n" +
                "                                                                            style=\"margin: 0px auto; max-width: 600px;\">\n" +
                "                                                                            <table align=\"center\" border=\"0\"\n" +
                "                                                                              cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                                                              role=\"presentation\" style=\"width: 200px;\">\n" +
                "                                                                              <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                  <td\n" +
                "                                                                                    style=\"direction: ltr; width: 200px; font-size: 0px; padding-bottom: 0px; text-align: center; vertical-align: top; background-image: url(&quot;&quot;); background-repeat: no-repeat; background-size: 100px; background-position: 10% 50%;\">\n" +
                "                                                                                    <div\n" +
                "                                                                                      style=\"font-size: 13px; text-align: left; direction: ltr; display: inline-block; vertical-align: top; width: 100%;\">\n" +
                "                                                                                      <table border=\"0\" cellpadding=\"0\"\n" +
                "                                                                                        cellspacing=\"0\"\n" +
                "                                                                                        role=\"presentation\" width=\"100%\"\n" +
                "                                                                                        style=\"vertical-align: top;\">\n" +
                "                                                                                        <tbody>\n" +
                "                                                                                          <tr>\n" +
                "                                                                                            <td align=\"left\"\n" +
                "                                                                                              style=\"font-size: 0px; padding: 25px 20px; word-break: break-word;\">\n" +
                "                                                                                              <div class=\"text\"\n" +
                "                                                                                                style=\"margin: 0px; text-align: center; color: rgb(125, 125, 125); font-size: 12px;\">\n" +
                "                                                                                                <div>\n" +
                "                                                                                                  <p\n" +
                "                                                                                                    style=\"line-height: 20px; margin: 0px;\">\n" +
                "                                                                                                    账单日期</p>\n" +
                "                                                                                                </div>\n" +
                "                                                                                              </div>\n" +
                "                                                                                            </td>\n" +
                "                                                                                          </tr>\n" +
                "                                                                                        </tbody>\n" +
                "                                                                                      </table>\n" +
                "                                                                                    </div>\n" +
                "                                                                                  </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                              </tbody>\n" +
                "                                                                            </table>\n" +
                "                                                                          </div>\n" +
                "                                                                        </div>\n" +
                "                                                                      </td>\n" +
                "                                                                    </tr>\n" +
                "                                                                  </tbody>\n" +
                "                                                                </table>\n" +
                "                                                              </td>\n" +
                "                                                            </tr>\n" ;
                String html14=
                "                                                          </tbody>\n" +
                "                                                        </table>\n" +
                "                                                      </div>\n" +
                "                                                    </a></td>\n" +
                "                                                </tr>\n" +
                "                                              </tbody>\n" +
                "                                            </table>\n" +
                "                                          </div>\n" +
                "                                        </div>\n" +
                "                                      </td>\n" +
                "                                    </tr>\n" +
                "                                  </tbody>\n" +
                "                                </table>\n" +
                "                              </td>\n" +
                "                            </tr>\n" +
                "                          </tbody>\n" +
                "                        </table>\n" +
                "                      </td>\n" +
                "                      <td\n" +
                "                        style=\"width: 33.3333%; max-width: 33.3333%; min-height: 1px; font-size: 13px; text-align: left; direction: ltr; vertical-align: top; padding: 0px;\">\n" +
                "                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"vertical-align: top;\">\n" +
                "                          <tbody>\n" +
                "                            <tr>\n" +
                "                              <td align=\"center\" style=\"font-size: 0px; word-break: break-word;\">\n" +
                "                                <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                  style=\"border-collapse: collapse; border-spacing: 0px; width: 100%;\">\n" +
                "                                  <tbody>\n" +
                "                                    <tr>\n" +
                "                                      <td>\n" +
                "                                        <div columnnumber=\"3\">\n" +
                "                                          <div>\n" +
                "                                            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                              style=\"width: 100%;\">\n" +
                "                                              <tbody>\n" +
                "                                                <tr>\n" +
                "                                                  <td\n" +
                "                                                    style=\"direction: ltr; font-size: 0px; text-align: center; vertical-align: top; border: 0px;\">\n" +
                "                                                    <a target=\"_blank\" href=\"javascript:;\" style=\"cursor: default;\">\n" +
                "                                                      <!-- 订单号 -->\n" +
                "                                                      <div class=\"mj-column-per-25\"\n" +
                "                                                        style=\"width: 100%; max-width: 100%; font-size: 13px; text-align: left; direction: ltr; display: inline-block; vertical-align: top;\">\n" +
                "                                                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"\n" +
                "                                                          style=\"vertical-align: top;\">\n" +
                "                                                          <tbody>\n" +
                "                                                            <tr>\n" +
                "                                                              <td align=\"center\" border=\"0\"\n" +
                "                                                                style=\"font-size: 0px; word-break: break-word;\">\n" +
                "                                                                <table align=\"center\" border=\"0\" cellpadding=\"0\"\n" +
                "                                                                  cellspacing=\"0\"\n" +
                "                                                                  style=\"border-collapse: collapse; border-spacing: 0px; width: 100%;\">\n" +
                "                                                                  <tbody>\n" +
                "                                                                    <tr>\n" +
                "                                                                      <td border=\"0\">\n" +
                "                                                                        <div class=\"full\">\n" +
                "                                                                          <div\n" +
                "                                                                            style=\"margin: 0px auto; max-width: 600px;\">\n" +
                "                                                                            <table align=\"center\" border=\"0\"\n" +
                "                                                                              cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                                                              role=\"presentation\" style=\"width: 200px;\">\n" +
                "                                                                              <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                  <td\n" +
                "                                                                                    style=\"direction: ltr; width: 200px; font-size: 0px; padding-bottom: 0px; text-align: center; vertical-align: top; background-image: url(&quot;&quot;); background-repeat: no-repeat; background-size: 100px; background-position: 10% 50%;\">\n" +
                "                                                                                    <div\n" +
                "                                                                                      style=\"font-size: 13px; text-align: left; direction: ltr; display: inline-block; vertical-align: top; width: 100%;\">\n" +
                "                                                                                      <table border=\"0\" cellpadding=\"0\"\n" +
                "                                                                                        cellspacing=\"0\"\n" +
                "                                                                                        role=\"presentation\" width=\"100%\"\n" +
                "                                                                                        style=\"vertical-align: top;\">\n" +
                "                                                                                        <tbody>\n" +
                "                                                                                          <tr>\n" +
                "                                                                                            <td align=\"left\"\n" +
                "                                                                                              style=\"font-size: 0px; padding: 25px 20px; word-break: break-word;\">\n" +
                "                                                                                              <div class=\"text\"\n" +
                "                                                                                                style=\"margin: 0px; text-align: center; color: rgb(62, 58, 57); font-size: 12px;\">\n" +
                "                                                                                                <div>\n" +
                "                                                                                                  <p\n" +
                "                                                                                                    style=\"line-height: 20px; margin: 0px;\">\n" +
                "                                                                                                    "+this.order_no+"</p>\n" +
                "                                                                                                </div>\n" +
                "                                                                                              </div>\n" +
                "                                                                                            </td>\n" +
                "                                                                                          </tr>\n" +
                "                                                                                        </tbody>\n" +
                "                                                                                      </table>\n" +
                "                                                                                    </div>\n" +
                "                                                                                  </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                              </tbody>\n" +
                "                                                                            </table>\n" +
                "                                                                          </div>\n" +
                "                                                                        </div>\n" +
                "                                                                      </td>\n" +
                "                                                                    </tr>\n" +
                "                                                                  </tbody>\n" +
                "                                                                </table>\n" +
                "                                                              </td>\n" +
                "                                                            </tr>\n" +
                "                                                          </tbody>\n" +
                "                                                        </table>\n" ;
                String html15 =
                "                                                      </div>\n" +
                "                                                      <!-- 账单号 -->\n" +
                "                                                      <div class=\"mj-column-per-25\"\n" +
                "                                                        style=\"width: 100%; max-width: 100%; font-size: 13px; text-align: left; direction: ltr; display: inline-block; vertical-align: top;\">\n" +
                "                                                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"\n" +
                "                                                          style=\"vertical-align: top;\">\n" +
                "                                                          <tbody>\n" +
                "                                                            <tr>\n" +
                "                                                              <td align=\"center\" border=\"0\"\n" +
                "                                                                style=\"font-size: 0px; word-break: break-word;\">\n" +
                "                                                                <table align=\"center\" border=\"0\" cellpadding=\"0\"\n" +
                "                                                                  cellspacing=\"0\"\n" +
                "                                                                  style=\"border-collapse: collapse; border-spacing: 0px; width: 100%;\">\n" +
                "                                                                  <tbody>\n" +
                "                                                                    <tr>\n" +
                "                                                                      <td border=\"0\">\n" +
                "                                                                        <div class=\"full\">\n" +
                "                                                                          <div\n" +
                "                                                                            style=\"margin: 0px auto; max-width: 600px;\">\n" +
                "                                                                            <table align=\"center\" border=\"0\"\n" +
                "                                                                              cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                                                              role=\"presentation\" style=\"width: 200px;\">\n" +
                "                                                                              <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                  <td\n" +
                "                                                                                    style=\"direction: ltr; width: 200px; font-size: 0px; padding-bottom: 0px; text-align: center; vertical-align: top; background-image: url(&quot;&quot;); background-repeat: no-repeat; background-size: 100px; background-position: 10% 50%;\">\n" +
                "                                                                                    <div\n" +
                "                                                                                      style=\"font-size: 13px; text-align: left; direction: ltr; display: inline-block; vertical-align: top; width: 100%;\">\n" +
                "                                                                                      <table border=\"0\" cellpadding=\"0\"\n" +
                "                                                                                        cellspacing=\"0\"\n" +
                "                                                                                        role=\"presentation\" width=\"100%\"\n" +
                "                                                                                        style=\"vertical-align: top;\">\n" +
                "                                                                                        <tbody>\n" +
                "                                                                                          <tr>\n" +
                "                                                                                            <td align=\"left\"\n" +
                "                                                                                              style=\"font-size: 0px; padding: 25px 20px; word-break: break-word;\">\n" +
                "                                                                                              <div class=\"text\"\n" +
                "                                                                                                style=\"margin: 0px; text-align: center; color: rgb(62, 58, 57); font-size: 12px;\">\n" +
                "                                                                                                <div>\n" +
                "                                                                                                  <p\n" +
                "                                                                                                    style=\"line-height: 20px; margin: 0px;\">\n" +
                "                                                                                                    "+this.bill_no+"\n" +
                "                                                                                                  </p>\n" +
                "                                                                                                </div>\n" +
                "                                                                                              </div>\n" +
                "                                                                                            </td>\n" +
                "                                                                                          </tr>\n" +
                "                                                                                        </tbody>\n" +
                "                                                                                      </table>\n" +
                "                                                                                    </div>\n" +
                "                                                                                  </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                              </tbody>\n" +
                "                                                                            </table>\n" +
                "                                                                          </div>\n" +
                "                                                                        </div>\n" +
                "                                                                      </td>\n" +
                "                                                                    </tr>\n" +
                "                                                                  </tbody>\n" +
                "                                                                </table>\n" +
                "                                                              </td>\n" +
                "                                                            </tr>\n" +
                "                                                          </tbody>\n" +
                "                                                        </table>\n" +
                "                                                      </div>\n" ;
                String html16=
                "                                                      <!-- 收款方 -->\n" +
                "                                                      <div class=\"mj-column-per-25\"\n" +
                "                                                        style=\"width: 100%; max-width: 100%; font-size: 13px; text-align: left; direction: ltr; display: inline-block; vertical-align: top;\">\n" +
                "                                                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"\n" +
                "                                                          style=\"vertical-align: top;\">\n" +
                "                                                          <tbody>\n" +
                "                                                            <tr>\n" +
                "                                                              <td align=\"center\" border=\"0\"\n" +
                "                                                                style=\"font-size: 0px; word-break: break-word;\">\n" +
                "                                                                <table align=\"center\" border=\"0\" cellpadding=\"0\"\n" +
                "                                                                  cellspacing=\"0\"\n" +
                "                                                                  style=\"border-collapse: collapse; border-spacing: 0px; width: 100%;\">\n" +
                "                                                                  <tbody>\n" +
                "                                                                    <tr>\n" +
                "                                                                      <td border=\"0\">\n" +
                "                                                                        <div class=\"full\">\n" +
                "                                                                          <div\n" +
                "                                                                            style=\"margin: 0px auto; max-width: 600px;\">\n" +
                "                                                                            <table align=\"center\" border=\"0\"\n" +
                "                                                                              cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                                                              role=\"presentation\" style=\"width: 200px;\">\n" +
                "                                                                              <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                  <td\n" +
                "                                                                                    style=\"direction: ltr; width: 200px; font-size: 0px; padding-bottom: 0px; text-align: center; vertical-align: top; background-image: url(&quot;&quot;); background-repeat: no-repeat; background-size: 100px; background-position: 10% 50%;\">\n" +
                "                                                                                    <div\n" +
                "                                                                                      style=\"font-size: 13px; text-align: left; direction: ltr; display: inline-block; vertical-align: top; width: 100%;\">\n" +
                "                                                                                      <table border=\"0\" cellpadding=\"0\"\n" +
                "                                                                                        cellspacing=\"0\"\n" +
                "                                                                                        role=\"presentation\" width=\"100%\"\n" +
                "                                                                                        style=\"vertical-align: top;\">\n" +
                "                                                                                        <tbody>\n" +
                "                                                                                          <tr>\n" +
                "                                                                                            <td align=\"left\"\n" +
                "                                                                                              style=\"font-size: 0px; padding: 25px 20px; word-break: break-word;\">\n" +
                "                                                                                              <div class=\"text\"\n" +
                "                                                                                                style=\"margin: 0px; text-align: center; color: rgb(62, 58, 57); font-size: 12px;\">\n" +
                "                                                                                                <div>\n" +
                "                                                                                                  <p\n" +
                "                                                                                                    style=\"line-height: 20px; margin: 0px;\">\n" +
                "                                                                                                    "+this.promoter_name+"</p>\n" +
                "                                                                                                </div>\n" +
                "                                                                                              </div>\n" +
                "                                                                                            </td>\n" +
                "                                                                                          </tr>\n" +
                "                                                                                        </tbody>\n" +
                "                                                                                      </table>\n" +
                "                                                                                    </div>\n" +
                "                                                                                  </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                              </tbody>\n" +
                "                                                                            </table>\n" +
                "                                                                          </div>\n" +
                "                                                                        </div>\n" +
                "                                                                      </td>\n" +
                "                                                                    </tr>\n" +
                "                                                                  </tbody>\n" +
                "                                                                </table>\n" +
                "                                                              </td>\n" +
                "                                                            </tr>\n" +
                "                                                          </tbody>\n" +
                "                                                        </table>\n" +
                "                                                      </div>\n" +
                "                                                      <!-- 参与人 -->\n" +
                "                                                      <div class=\"mj-column-per-25\"\n" +
                "                                                        style=\"width: 100%; max-width: 100%; font-size: 13px; text-align: left; direction: ltr; display: inline-block; vertical-align: top;\">\n" +
                "                                                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"\n" +
                "                                                          style=\"vertical-align: top;\">\n" +
                "                                                          <tbody>\n" +
                "                                                            <tr>\n" +
                "                                                              <td align=\"center\" border=\"0\"\n" +
                "                                                                style=\"font-size: 0px; word-break: break-word;\">\n" +
                "                                                                <table align=\"center\" border=\"0\" cellpadding=\"0\"\n" +
                "                                                                  cellspacing=\"0\"\n" +
                "                                                                  style=\"border-collapse: collapse; border-spacing: 0px; width: 100%;\">\n" +
                "                                                                  <tbody>\n" +
                "                                                                    <tr>\n";
                String html17=
                "                                                                      <td border=\"0\">\n" +
                "                                                                        <div class=\"full\">\n" +
                "                                                                          <div\n" +
                "                                                                            style=\"margin: 0px auto; max-width: 600px;\">\n" +
                "                                                                            <table align=\"center\" border=\"0\"\n" +
                "                                                                              cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                                                              role=\"presentation\" style=\"width: 200px;\">\n" +
                "                                                                              <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                  <td\n" +
                "                                                                                    style=\"direction: ltr; width: 200px; font-size: 0px; padding-bottom: 0px; text-align: center; vertical-align: top; background-image: url(&quot;&quot;); background-repeat: no-repeat; background-size: 100px; background-position: 10% 50%;\">\n" +
                "                                                                                    <div\n" +
                "                                                                                      style=\"font-size: 13px; text-align: left; direction: ltr; display: inline-block; vertical-align: top; width: 100%;\">\n" +
                "                                                                                      <table border=\"0\" cellpadding=\"0\"\n" +
                "                                                                                        cellspacing=\"0\"\n" +
                "                                                                                        role=\"presentation\" width=\"100%\"\n" +
                "                                                                                        style=\"vertical-align: top;\">\n" +
                "                                                                                        <tbody>\n" +
                "                                                                                          <tr>\n" +
                "                                                                                            <td align=\"left\"\n" +
                "                                                                                              style=\"font-size: 0px; padding: 25px 20px; word-break: break-word;\">\n" +
                "                                                                                              <div class=\"text\"\n" +
                "                                                                                                style=\"margin: 0px; text-align: center; color: rgb(62, 58, 57); font-size: 12px;\">\n" +
                "                                                                                                <div>\n" +
                "                                                                                                  <p\n" +
                "                                                                                                    style=\"line-height: 20px; margin: 0px;\">\n" +
                "                                                                                                    "+this.joiners_name+"\n" +
                "                                                                                                  </p>\n" +
                "                                                                                                </div>\n" +
                "                                                                                              </div>\n" +
                "                                                                                            </td>\n" +
                "                                                                                          </tr>\n" +
                "                                                                                        </tbody>\n" +
                "                                                                                      </table>\n" +
                "                                                                                    </div>\n" +
                "                                                                                  </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                              </tbody>\n" +
                "                                                                            </table>\n" +
                "                                                                          </div>\n" +
                "                                                                        </div>\n" +
                "                                                                      </td>\n" +
                "                                                                    </tr>\n" +
                "                                                                  </tbody>\n" +
                "                                                                </table>\n" +
                "                                                              </td>\n" +
                "                                                            </tr>\n" +
                "                                                          </tbody>\n" +
                "                                                        </table>\n" +
                "                                                      </div>\n" +
                "                                                      <!-- 订单金额 -->\n" +
                "                                                      <div class=\"mj-column-per-25\"\n" +
                "                                                        style=\"width: 100%; max-width: 100%; font-size: 13px; text-align: left; direction: ltr; display: inline-block; vertical-align: top;\">\n" +
                "                                                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"\n" +
                "                                                          style=\"vertical-align: top;\">\n" +
                "                                                          <tbody>\n" +
                "                                                            <tr>\n" +
                "                                                              <td align=\"center\" border=\"0\"\n" +
                "                                                                style=\"font-size: 0px; word-break: break-word;\">\n" +
                "                                                                <table align=\"center\" border=\"0\" cellpadding=\"0\"\n" +
                "                                                                  cellspacing=\"0\"\n" +
                "                                                                  style=\"border-collapse: collapse; border-spacing: 0px; width: 100%;\">\n" +
                "                                                                  <tbody>\n" +
                "                                                                    <tr>\n";
                String html18 =
                "                                                                      <td border=\"0\">\n" +
                "                                                                        <div class=\"full\">\n" +
                "                                                                          <div\n" +
                "                                                                            style=\"margin: 0px auto; max-width: 600px;\">\n" +
                "                                                                            <table align=\"center\" border=\"0\"\n" +
                "                                                                              cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                                                              role=\"presentation\" style=\"width: 200px;\">\n" +
                "                                                                              <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                  <td\n" +
                "                                                                                    style=\"direction: ltr; width: 200px; font-size: 0px; padding-bottom: 0px; text-align: center; vertical-align: top; background-image: url(&quot;&quot;); background-repeat: no-repeat; background-size: 100px; background-position: 10% 50%;\">\n" +
                "                                                                                    <div\n" +
                "                                                                                      style=\"font-size: 13px; text-align: left; direction: ltr; display: inline-block; vertical-align: top; width: 100%;\">\n" +
                "                                                                                      <table border=\"0\" cellpadding=\"0\"\n" +
                "                                                                                        cellspacing=\"0\"\n" +
                "                                                                                        role=\"presentation\" width=\"100%\"\n" +
                "                                                                                        style=\"vertical-align: top;\">\n" +
                "                                                                                        <tbody>\n" +
                "                                                                                          <tr>\n" +
                "                                                                                            <td align=\"left\"\n" +
                "                                                                                              style=\"font-size: 0px; padding: 25px 20px; word-break: break-word;\">\n" +
                "                                                                                              <div class=\"text\"\n" +
                "                                                                                                style=\"margin: 0px; text-align: center; color: rgb(62, 58, 57); font-size: 12px;\">\n" +
                "                                                                                                <div>\n" +
                "                                                                                                  <p\n" +
                "                                                                                                    style=\"line-height: 20px; margin: 0px;\">\n" +
                "                                                                                                    "+this.order_money+"\n" +
                "                                                                                                  </p>\n" +
                "                                                                                                </div>\n" +
                "                                                                                              </div>\n" +
                "                                                                                            </td>\n" +
                "                                                                                          </tr>\n" +
                "                                                                                        </tbody>\n" +
                "                                                                                      </table>\n" +
                "                                                                                    </div>\n" +
                "                                                                                  </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                              </tbody>\n" +
                "                                                                            </table>\n" +
                "                                                                          </div>\n" +
                "                                                                        </div>\n" +
                "                                                                      </td>\n" +
                "                                                                    </tr>\n" +
                "                                                                  </tbody>\n" +
                "                                                                </table>\n" +
                "                                                              </td>\n" +
                "                                                            </tr>\n" +
                "                                                          </tbody>\n" +
                "                                                        </table>\n" +
                "                                                      </div>\n" +
                "                                                      <!-- 账单金额 -->\n" +
                "                                                      <div class=\"mj-column-per-25\"\n" +
                "                                                        style=\"width: 100%; max-width: 100%; font-size: 13px; text-align: left; direction: ltr; display: inline-block; vertical-align: top;\">\n" +
                "                                                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"\n" +
                "                                                          style=\"vertical-align: top;\">\n" +
                "                                                          <tbody>\n" +
                "                                                            <tr>\n" +
                "                                                              <td align=\"center\" border=\"0\"\n" +
                "                                                                style=\"font-size: 0px; word-break: break-word;\">\n" +
                "                                                                <table align=\"center\" border=\"0\" cellpadding=\"0\"\n" +
                "                                                                  cellspacing=\"0\"\n" +
                "                                                                  style=\"border-collapse: collapse; border-spacing: 0px; width: 100%;\">\n" +
                "                                                                  <tbody>\n" +
                "                                                                    <tr>\n" ;
                String html19=
                "                                                                      <td border=\"0\">\n" +
                "                                                                        <div class=\"full\">\n" +
                "                                                                          <div\n" +
                "                                                                            style=\"margin: 0px auto; max-width: 600px;\">\n" +
                "                                                                            <table align=\"center\" border=\"0\"\n" +
                "                                                                              cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                                                              role=\"presentation\" style=\"width: 200px;\">\n" +
                "                                                                              <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                  <td\n" +
                "                                                                                    style=\"direction: ltr; width: 200px; font-size: 0px; padding-bottom: 0px; text-align: center; vertical-align: top; background-image: url(&quot;&quot;); background-repeat: no-repeat; background-size: 100px; background-position: 10% 50%;\">\n" +
                "                                                                                    <div\n" +
                "                                                                                      style=\"font-size: 13px; text-align: left; direction: ltr; display: inline-block; vertical-align: top; width: 100%;\">\n" +
                "                                                                                      <table border=\"0\" cellpadding=\"0\"\n" +
                "                                                                                        cellspacing=\"0\"\n" +
                "                                                                                        role=\"presentation\" width=\"100%\"\n" +
                "                                                                                        style=\"vertical-align: top;\">\n" +
                "                                                                                        <tbody>\n" +
                "                                                                                          <tr>\n" +
                "                                                                                            <td align=\"left\"\n" +
                "                                                                                              style=\"font-size: 0px; padding: 25px 20px; word-break: break-word;\">\n" +
                "                                                                                              <div class=\"text\"\n" +
                "                                                                                                style=\"margin: 0px; text-align: center; color: rgb(62, 58, 57); font-size: 12px;\">\n" +
                "                                                                                                <div>\n" +
                "                                                                                                  <p\n" +
                "                                                                                                    style=\"line-height: 20px; margin: 0px;\">\n" +
                "                                                                                                    "+this.bill_money+"\n" +
                "                                                                                                  </p>\n" +
                "                                                                                                </div>\n" +
                "                                                                                              </div>\n" +
                "                                                                                            </td>\n" +
                "                                                                                          </tr>\n" +
                "                                                                                        </tbody>\n" +
                "                                                                                      </table>\n" +
                "                                                                                    </div>\n" +
                "                                                                                  </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                              </tbody>\n" +
                "                                                                            </table>\n" +
                "                                                                          </div>\n" +
                "                                                                        </div>\n" +
                "                                                                      </td>\n" +
                "                                                                    </tr>\n" +
                "                                                                  </tbody>\n" +
                "                                                                </table>\n" +
                "                                                              </td>\n" +
                "                                                            </tr>\n" +
                "                                                          </tbody>\n" +
                "                                                        </table>\n" +
                "                                                      </div>\n" +
                "                                                      <!-- 日期 -->\n" +
                "                                                      <div class=\"mj-column-per-25\"\n" +
                "                                                        style=\"width: 100%; max-width: 100%; font-size: 13px; text-align: left; direction: ltr; display: inline-block; vertical-align: top;\">\n" +
                "                                                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"\n" +
                "                                                          style=\"vertical-align: top;\">\n" +
                "                                                          <tbody>\n";
                String html20 =
                "                                                            <tr>\n" +
                "                                                              <td align=\"center\" border=\"0\"\n" +
                "                                                                style=\"font-size: 0px; word-break: break-word;\">\n" +
                "                                                                <table align=\"center\" border=\"0\" cellpadding=\"0\"\n" +
                "                                                                  cellspacing=\"0\"\n" +
                "                                                                  style=\"border-collapse: collapse; border-spacing: 0px; width: 100%;\">\n" +
                "                                                                  <tbody>\n" +
                "                                                                    <tr>\n" +
                "                                                                      <td border=\"0\">\n" +
                "                                                                        <div class=\"full\">\n" +
                "                                                                          <div\n" +
                "                                                                            style=\"margin: 0px auto; max-width: 600px;\">\n" +
                "                                                                            <table align=\"center\" border=\"0\"\n" +
                "                                                                              cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                                                              role=\"presentation\" style=\"width: 200px;\">\n" +
                "                                                                              <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                  <td\n" +
                "                                                                                    style=\"direction: ltr; width: 200px; font-size: 0px; padding-bottom: 0px; text-align: center; vertical-align: top; background-image: url(&quot;&quot;); background-repeat: no-repeat; background-size: 100px; background-position: 10% 50%;\">\n" +
                "                                                                                    <div\n" +
                "                                                                                      style=\"font-size: 13px; text-align: left; direction: ltr; display: inline-block; vertical-align: top; width: 100%;\">\n" +
                "                                                                                      <table border=\"0\" cellpadding=\"0\"\n" +
                "                                                                                        cellspacing=\"0\"\n" +
                "                                                                                        role=\"presentation\" width=\"100%\"\n" +
                "                                                                                        style=\"vertical-align: top;\">\n" +
                "                                                                                        <tbody>\n" +
                "                                                                                          <tr>\n" +
                "                                                                                            <td align=\"left\"\n" +
                "                                                                                              style=\"font-size: 0px; padding: 25px 20px; word-break: break-word;\">\n" +
                "                                                                                              <div class=\"text\"\n" +
                "                                                                                                style=\"margin: 0px; text-align: center; color: rgb(62, 58, 57); font-size: 12px;\">\n" +
                "                                                                                                <div>\n" +
                "                                                                                                  <p\n" +
                "                                                                                                    style=\"line-height: 20px; margin: 0px;\">\n" +
                "                                                                                                    "+this.create_time+"\n" +
                "                                                                                                  </p>\n" +
                "                                                                                                </div>\n" +
                "                                                                                              </div>\n" +
                "                                                                                            </td>\n" +
                "                                                                                          </tr>\n" +
                "                                                                                        </tbody>\n" +
                "                                                                                      </table>\n" +
                "                                                                                    </div>\n" +
                "                                                                                  </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                              </tbody>\n" +
                "                                                                            </table>\n" +
                "                                                                          </div>\n" +
                "                                                                        </div>\n" +
                "                                                                      </td>\n" +
                "                                                                    </tr>\n" +
                "                                                                  </tbody>\n" +
                "                                                                </table>\n" +
                "                                                              </td>\n" +
                "                                                            </tr>\n" +
                "                                                          </tbody>\n" +
                "                                                        </table>\n" +
                "                                                      </div>\n" ;
                String html21=
                "                                                    </a></td>\n" +
                "                                                </tr>\n" +
                "                                              </tbody>\n" +
                "                                            </table>\n" +
                "                                          </div>\n" +
                "                                        </div>\n" +
                "                                      </td>\n" +
                "                                    </tr>\n" +
                "                                  </tbody>\n" +
                "                                </table>\n" +
                "                              </td>\n" +
                "                            </tr>\n" +
                "                          </tbody>\n" +
                "                        </table>\n" +
                "                      </td>\n" +
                "                      <td\n" +
                "                        style=\"width: 33.3333%; max-width: 33.3333%; min-height: 1px; font-size: 13px; text-align: left; direction: ltr; vertical-align: top; padding: 0px;\">\n" +
                "                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"vertical-align: top;\">\n" +
                "                          <tbody>\n" +
                "                            <tr>\n" +
                "                              <td align=\"center\" style=\"font-size: 0px; word-break: break-word;\">\n" +
                "                                <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                  style=\"border-collapse: collapse; border-spacing: 0px; width: 100%;\">\n" +
                "                                  <tbody>\n" +
                "                                    <tr>\n" +
                "                                      <td>\n" +
                "                                        <div columnnumber=\"3\">\n" +
                "                                          <div>\n" +
                "                                            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                              style=\"width: 100%;\">\n" +
                "                                              <tbody>\n" +
                "                                                <tr>\n" +
                "                                                  <td\n" +
                "                                                    style=\"direction: ltr; font-size: 0px; text-align: center; vertical-align: top; border: 0px;\">\n" +
                "                                                    <a target=\"_blank\" href=\"javascript:;\" style=\"cursor: default;\">\n" +
                "                                                      <div class=\"mj-column-per-50\"\n" +
                "                                                        style=\"width: 100%; max-width: 100%; font-size: 13px; text-align: left; direction: ltr; display: inline-block; vertical-align: top;\">\n" +
                "                                                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"\n" +
                "                                                          style=\"vertical-align: top;\">\n" +
                "                                                          <tbody>\n" +
                "                                                            <tr>\n" +
                "                                                              <td align=\"center\" border=\"0\"\n" +
                "                                                                style=\"font-size: 0px; word-break: break-word;\">\n" +
                "                                                                <table align=\"center\" border=\"0\" cellpadding=\"0\"\n" +
                "                                                                  cellspacing=\"0\"\n" +
                "                                                                  style=\"border-collapse: collapse; border-spacing: 0px; width: 100%;\">\n" +
                "                                                                  <tbody>\n" +
                "                                                                    <tr>\n" +
                "                                                                      <td border=\"0\">\n" +
                "                                                                        <div class=\"full\">\n" +
                "                                                                          <div\n" +
                "                                                                            style=\"margin: 0px auto; max-width: 600px;\">\n" +
                "                                                                            <table align=\"center\" border=\"0\"\n" +
                "                                                                              cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                                                              role=\"presentation\" style=\"width: 200px;\">\n" +
                "                                                                              <tbody>\n" +
                "                                                                                <tr>\n" +
                "                                                                                  <td\n" +
                "                                                                                    style=\"direction: ltr; width: 200px; font-size: 0px; padding-bottom: 0px; text-align: center; vertical-align: top;\">\n" +
                "                                                                                    <div\n" +
                "                                                                                      style=\"display: inline-block; vertical-align: top; width: 100%;\">\n" +
                "                                                                                      <table border=\"0\" cellpadding=\"0\"\n" +
                "                                                                                        cellspacing=\"0\"\n" +
                "                                                                                        role=\"presentation\" width=\"100%\"\n" +
                "                                                                                        style=\"vertical-align: top;\">\n" +
                "                                                                                        <tbody>\n" +
                "                                                                                          <tr>\n" +
                "                                                                                            <td align=\"center\"\n" +
                "                                                                                              style=\"font-size: 0px; padding: 13px 21px; word-break: break-word;\">\n" +
                "                                                                                              <table border=\"0\"\n" +
                "                                                                                                cellpadding=\"0\"\n" +
                "                                                                                                cellspacing=\"0\"\n" +
                "                                                                                                role=\"presentation\"\n" +
                "                                                                                                style=\"border-collapse: collapse; border-spacing: 0px;\">\n" +
                "                                                                                                <tbody>\n" +
                "                                                                                                  <tr>\n" +
                "                                                                                                    <td\n" +
                "                                                                                                      style=\"width: 158px; text-align: right;\">\n" +
                "                                                                                                      <div>\n" +
                "                                                                                                        <img\n" +
                "                                                                                                          height=\"auto\"\n" +
                "                                                                                                          width=\"NaN\"\n" +
                "                                                                                                          src=\"https://wx.gtimg.com/mch/images/demo/secret.png\"\n" +
                "                                                                                                          style=\"box-sizing: border-box; border: 0px; display: inline-block; outline: none; text-decoration: none; height: auto; width: auto; max-width: 100%; padding: 0px;\" />\n" +
                "                                                                                                      </div>\n" +
                "                                                                                                    </td>\n" +
                "                                                                                                  </tr>\n" +
                "                                                                                                </tbody>\n" +
                "                                                                                              </table>\n" +
                "                                                                                            </td>\n" +
                "                                                                                          </tr>\n" +
                "                                                                                        </tbody>\n" +
                "                                                                                      </table>\n" +
                "                                                                                    </div>\n" +
                "                                                                                  </td>\n" +
                "                                                                                </tr>\n" +
                "                                                                              </tbody>\n" +
                "                                                                            </table>\n" +
                "                                                                          </div>\n" +
                "                                                                        </div>\n" +
                "                                                                      </td>\n" +
                "                                                                    </tr>\n" +
                "                                                                  </tbody>\n" +
                "                                                                </table>\n" +
                "                                                              </td>\n" +
                "                                                            </tr>\n" ;
                String html22=
                "                                                          </tbody>\n" +
                "                                                        </table>\n" +
                "                                                      </div>\n" +
                "                                                      <div class=\"mj-column-per-50\"\n" +
                "                                                        style=\"width: 100%; max-width: 100%; font-size: 13px; text-align: left; direction: ltr; display: inline-block; vertical-align: top;\">\n" +
                "                                                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"\n" +
                "                                                          style=\"vertical-align: top;\">\n" +
                "                                                          <tbody>\n" +
                "                                                            <tr>\n" +
                "                                                              <td align=\"center\" border=\"0\"\n" +
                "                                                                style=\"font-size: 0px; word-break: break-word;\">\n" +
                "                                                                <table align=\"center\" border=\"0\" cellpadding=\"0\"\n" +
                "                                                                  cellspacing=\"0\"\n" +
                "                                                                  style=\"border-collapse: collapse; border-spacing: 0px; width: 100%;\">\n" +
                "                                                                  <tbody>\n" +
                "                                                                    <tr>\n" +
                "                                                                      <td border=\"0\">\n" +
                "                                                                        <!---->\n" +
                "                                                                      </td>\n" +
                "                                                                    </tr>\n" +
                "                                                                  </tbody>\n" +
                "                                                                </table>\n" +
                "                                                              </td>\n" +
                "                                                            </tr>\n" +
                "                                                          </tbody>\n" +
                "                                                        </table>\n" +
                "                                                      </div>\n" +
                "                                                    </a></td>\n" +
                "                                                </tr>\n" +
                "                                              </tbody>\n" +
                "                                            </table>\n" +
                "                                          </div>\n" +
                "                                        </div>\n" +
                "                                      </td>\n" +
                "                                    </tr>\n" +
                "                                  </tbody>\n" +
                "                                </table>\n" +
                "                              </td>\n" +
                "                            </tr>\n" +
                "                          </tbody>\n" +
                "                        </table>\n" +
                "                      </td>\n" +
                "                    </tr>\n" +
                "                  </tbody>\n" +
                "                </table>\n" +
                "              </td>\n" +
                "            </tr>\n" +
                "          </tbody>\n" +
                "        </table>\n" +
                "      </div>\n" +
                "    </div>\n" +
                "      <!-- 底部 -->\n" ;
                String html23=
                "    <div>\n" +
                "      <div style=\"margin: 0px auto; max-width: 600px;\">\n" +
                "        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                "          style=\"background-color: rgb(255, 255, 255); background-image: url(&quot;&quot;); background-repeat: no-repeat; background-size: 100px; background-position: 1% 50%;\">\n" +
                "          <tbody>\n" +
                "            <tr>\n" +
                "              <td style=\"direction: ltr; font-size: 0px; text-align: center; vertical-align: top; width: 600px;\">\n" +
                "                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "                  <tbody>\n" +
                "                    <tr>\n" +
                "                      <td\n" +
                "                        style=\"width: 40%; max-width: 40%; min-height: 1px; font-size: 13px; text-align: left; direction: ltr; vertical-align: top; padding: 0px;\">\n" +
                "                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"vertical-align: top;\">\n" +
                "                          <tbody>\n" +
                "                            <tr>\n" +
                "                              <td align=\"center\" style=\"font-size: 0px; word-break: break-word;\">\n" +
                "                                <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                  style=\"border-collapse: collapse; border-spacing: 0px; width: 100%;\">\n" +
                "                                  <tbody>\n" +
                "                                    <tr>\n" +
                "                                      <td>\n" +
                "                                        <div class=\"full\">\n" +
                "                                          <div style=\"margin: 0px auto; max-width: 600px;\">\n" +
                "                                            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                              role=\"presentation\" style=\"width: 240px;\">\n" +
                "                                              <tbody>\n" +
                "                                                <tr>\n" +
                "                                                  <td\n" +
                "                                                    style=\"direction: ltr; font-size: 0px; padding: 0px; text-align: center; vertical-align: top;\">\n" +
                "                                                    <div class=\"outlook-group-fix\"\n" +
                "                                                      style=\"font-size: 13px; text-align: left; direction: ltr; display: inline-block; vertical-align: top; width: 100%;\">\n" +
                "                                                      <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                                        role=\"presentation\" width=\"100%\" style=\"vertical-align: top;\">\n" +
                "                                                        <tbody>\n" +
                "                                                          <tr>\n" +
                "                                                            <td align=\"center\"\n" +
                "                                                              style=\"font-size: 0px; padding: 25px 0px; word-break: break-word; width: 240px; background-image: url(&quot;&quot;); background-repeat: no-repeat; background-size: 100px; background-position: 10% 50%;\">\n" +
                "                                                              <table align=\"center\" border=\"0\" cellpadding=\"0\"\n" +
                "                                                                cellspacing=\"0\" role=\"presentation\"\n" +
                "                                                                style=\"border-collapse: collapse; border-spacing: 0px;\">\n" +
                "                                                                <tbody>\n" +
                "                                                                  <tr>\n" +
                "                                                                    <td\n" +
                "                                                                      style=\"width: 375px; border-top: 1px solid rgb(204, 204, 204);\">\n" +
                "                                                                    </td>\n" +
                "                                                                  </tr>\n" +
                "                                                                </tbody>\n" +
                "                                                              </table>\n" +
                "                                                            </td>\n" +
                "                                                          </tr>\n" +
                "                                                        </tbody>\n" +
                "                                                      </table>\n" +
                "                                                    </div>\n" +
                "                                                  </td>\n" +
                "                                                </tr>\n" +
                "                                              </tbody>\n" +
                "                                            </table>\n" +
                "                                          </div>\n" +
                "                                        </div>\n" +
                "                                      </td>\n" +
                "                                    </tr>\n" +
                "                                  </tbody>\n" +
                "                                </table>\n" +
                "                              </td>\n" +
                "                            </tr>\n" +
                "                          </tbody>\n" +
                "                        </table>\n" +
                "                      </td>\n" +
                "                      <td\n" ;
                String html24 =
                "                        style=\"width: 20%; max-width: 20%; min-height: 1px; font-size: 13px; text-align: left; direction: ltr; vertical-align: top; padding: 0px;\">\n" +
                "                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"vertical-align: top;\">\n" +
                "                          <tbody>\n" +
                "                            <tr>\n" +
                "                              <td align=\"center\" style=\"font-size: 0px; word-break: break-word;\">\n" +
                "                                <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                  style=\"border-collapse: collapse; border-spacing: 0px; width: 100%;\">\n" +
                "                                  <tbody>\n" +
                "                                    <tr>\n" +
                "                                      <td>\n" +
                "                                        <div class=\"full\">\n" +
                "                                          <div style=\"margin: 0px auto; max-width: 600px;\">\n" +
                "                                            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                              role=\"presentation\" style=\"width: 120px;\">\n" +
                "                                              <tbody>\n" +
                "                                                <tr>\n" +
                "                                                  <td\n" +
                "                                                    style=\"direction: ltr; width: 120px; font-size: 0px; padding-bottom: 0px; text-align: center; vertical-align: top; background-image: url(&quot;&quot;); background-repeat: no-repeat; background-size: 100px; background-position: 10% 50%;\">\n" +
                "                                                    <div\n" +
                "                                                      style=\"font-size: 13px; text-align: left; direction: ltr; display: inline-block; vertical-align: top; width: 100%;\">\n" +
                "                                                      <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                                        role=\"presentation\" width=\"100%\" style=\"vertical-align: top;\">\n" +
                "                                                        <tbody>\n" +
                "                                                          <tr>\n" +
                "                                                            <td align=\"left\"\n" +
                "                                                              style=\"font-size: 0px; padding: 13px 20px; word-break: break-word;\">\n" +
                "                                                              <div class=\"text\"\n" +
                "                                                                style=\"margin: 0px; text-align: center; color: rgb(51, 51, 51); font-size: 16px;\">\n" +
                "                                                                <div>\n" +
                "                                                                  <p style=\"line-height: 20px; margin: 0px;\">感谢观看</p>\n" +
                "                                                                </div>\n" +
                "                                                              </div>\n" +
                "                                                            </td>\n" +
                "                                                          </tr>\n" +
                "                                                        </tbody>\n" +
                "                                                      </table>\n" +
                "                                                    </div>\n" +
                "                                                  </td>\n" +
                "                                                </tr>\n" +
                "                                              </tbody>\n" +
                "                                            </table>\n" +
                "                                          </div>\n" +
                "                                        </div>\n" +
                "                                      </td>\n" +
                "                                    </tr>\n" +
                "                                  </tbody>\n" +
                "                                </table>\n" +
                "                              </td>\n" +
                "                            </tr>\n" +
                "                          </tbody>\n" +
                "                        </table>\n" +
                "                      </td>\n" +
                "                      <td\n" ;
                String html25=
                "                        style=\"width: 40%; max-width: 40%; min-height: 1px; font-size: 13px; text-align: left; direction: ltr; vertical-align: top; padding: 0px;\">\n" +
                "                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"vertical-align: top;\">\n" +
                "                          <tbody>\n" +
                "                            <tr>\n" +
                "                              <td align=\"center\" style=\"font-size: 0px; word-break: break-word;\">\n" +
                "                                <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                  style=\"border-collapse: collapse; border-spacing: 0px; width: 100%;\">\n" +
                "                                  <tbody>\n" +
                "                                    <tr>\n" +
                "                                      <td>\n" +
                "                                        <div class=\"full\">\n" +
                "                                          <div style=\"margin: 0px auto; max-width: 600px;\">\n" +
                "                                            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                              role=\"presentation\" style=\"width: 240px;\">\n" +
                "                                              <tbody>\n" +
                "                                                <tr>\n" +
                "                                                  <td\n" +
                "                                                    style=\"direction: ltr; font-size: 0px; padding: 0px; text-align: center; vertical-align: top;\">\n" +
                "                                                    <div class=\"outlook-group-fix\"\n" +
                "                                                      style=\"font-size: 13px; text-align: left; direction: ltr; display: inline-block; vertical-align: top; width: 100%;\">\n" +
                "                                                      <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                                        role=\"presentation\" width=\"100%\" style=\"vertical-align: top;\">\n" +
                "                                                        <tbody>\n" +
                "                                                          <tr>\n" +
                "                                                            <td align=\"center\"\n" +
                "                                                              style=\"font-size: 0px; padding: 25px 0px; word-break: break-word; width: 240px; background-image: url(&quot;&quot;); background-repeat: no-repeat; background-size: 100px; background-position: 10% 50%;\">\n" +
                "                                                              <table align=\"center\" border=\"0\" cellpadding=\"0\"\n" +
                "                                                                cellspacing=\"0\" role=\"presentation\"\n" +
                "                                                                style=\"border-collapse: collapse; border-spacing: 0px;\">\n" +
                "                                                                <tbody>\n" +
                "                                                                  <tr>\n" +
                "                                                                    <td\n" +
                "                                                                      style=\"width: 375px; border-top: 1px solid rgb(204, 204, 204);\">\n" +
                "                                                                    </td>\n" +
                "                                                                  </tr>\n" +
                "                                                                </tbody>\n" +
                "                                                              </table>\n" +
                "                                                            </td>\n" +
                "                                                          </tr>\n" +
                "                                                        </tbody>\n" +
                "                                                      </table>\n" +
                "                                                    </div>\n" +
                "                                                  </td>\n" +
                "                                                </tr>\n" +
                "                                              </tbody>\n" +
                "                                            </table>\n" +
                "                                          </div>\n" +
                "                                        </div>\n" +
                "                                      </td>\n" +
                "                                    </tr>\n" +
                "                                  </tbody>\n" +
                "                                </table>\n" +
                "                              </td>\n" +
                "                            </tr>\n" +
                "                          </tbody>\n" +
                "                        </table>\n" +
                "                      </td>\n" +
                "                    </tr>\n" +
                "                  </tbody>\n" +
                "                </table>\n" +
                "              </td>\n" +
                "            </tr>\n" +
                "          </tbody>\n" +
                "        </table>\n" +
                "      </div>\n" +
                "    </div>\n" +
                "    <div>\n" ;
                String html26 =
                "      <div style=\"margin: 0px auto; max-width: 600px;\">\n" +
                "        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                "          style=\"background-color: rgb(65, 207, 88); background-image: url(&quot;&quot;); background-repeat: no-repeat; background-size: 100px; background-position: 1% 50%;\">\n" +
                "          <tbody>\n" +
                "            <tr>\n" +
                "              <td style=\"direction: ltr; font-size: 0px; text-align: center; vertical-align: top; width: 600px;\">\n" +
                "                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "                  <tbody>\n" +
                "                    <tr>\n" +
                "                      <td\n" +
                "                        style=\"width: 80%; max-width: 80%; min-height: 1px; font-size: 13px; text-align: left; direction: ltr; vertical-align: top; padding: 0px;\">\n" +
                "                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"vertical-align: top;\">\n" +
                "                          <tbody>\n" +
                "                            <tr>\n" +
                "                              <td align=\"center\" style=\"font-size: 0px; word-break: break-word;\">\n" +
                "                                <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                  style=\"border-collapse: collapse; border-spacing: 0px; width: 100%;\">\n" +
                "                                  <tbody>\n" +
                "                                    <tr>\n" +
                "                                      <td>\n" +
                "                                        <div class=\"full\">\n" +
                "                                          <div style=\"margin: 0px auto; max-width: 600px;\">\n" +
                "                                            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                              role=\"presentation\" style=\"width: 480px;\">\n" +
                "                                              <tbody>\n" +
                "                                                <tr>\n" +
                "                                                  <td\n" +
                "                                                    style=\"direction: ltr; width: 480px; font-size: 0px; padding-bottom: 0px; text-align: center; vertical-align: top; background-image: url(&quot;&quot;); background-repeat: no-repeat; background-size: 100px; background-position: 10% 50%;\">\n" +
                "                                                    <div\n" +
                "                                                      style=\"font-size: 13px; text-align: left; direction: ltr; display: inline-block; vertical-align: top; width: 100%;\">\n" +
                "                                                      <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                                        role=\"presentation\" width=\"100%\" style=\"vertical-align: top;\">\n" +
                "                                                        <tbody>\n" +
                "                                                          <tr>\n" +
                "                                                            <td align=\"left\"\n" +
                "                                                              style=\"font-size: 0px; padding: 20px 10px; word-break: break-word;\">\n" +
                "                                                              <div class=\"text\"\n" +
                "                                                                style=\"margin: 0px; text-align: left; color: rgb(255, 255, 255); font-size: 12px;\">\n" +
                "                                                                <div>\n" +
                "                                                                  <p style=\"line-height: 20px; margin: 0px;\">\n" +
                "                                                                    请注意，该邮件地址不接收回复邮件，请与管理员jack联系：13253959318</p>\n" +
                "                                                                </div>\n" +
                "                                                              </div>\n" +
                "                                                            </td>\n" +
                "                                                          </tr>\n" +
                "                                                        </tbody>\n" +
                "                                                      </table>\n" +
                "                                                    </div>\n" +
                "                                                  </td>\n" +
                "                                                </tr>\n" +
                "                                              </tbody>\n" +
                "                                            </table>\n" +
                "                                          </div>\n" +
                "                                        </div>\n" +
                "                                      </td>\n" +
                "                                    </tr>\n" +
                "                                  </tbody>\n" +
                "                                </table>\n" +
                "                              </td>\n" +
                "                            </tr>\n" +
                "                          </tbody>\n" +
                "                        </table>\n" +
                "                      </td>\n" +
                "                      <td\n" ;
                String html27 =
                "                        style=\"width: 20%; max-width: 20%; min-height: 1px; font-size: 13px; text-align: left; direction: ltr; vertical-align: top; padding: 0px;\">\n" +
                "                        <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"vertical-align: top;\">\n" +
                "                          <tbody>\n" +
                "                            <tr>\n" +
                "                              <td align=\"center\" style=\"font-size: 0px; word-break: break-word;\">\n" +
                "                                <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                  style=\"border-collapse: collapse; border-spacing: 0px; width: 100%;\">\n" +
                "                                  <tbody>\n" +
                "                                    <tr>\n" +
                "                                      <td>\n" +
                "                                        <div class=\"full\">\n" +
                "                                          <div style=\"margin: 0px auto; max-width: 600px;\">\n" +
                "                                            <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                              role=\"presentation\" style=\"width: 120px;\">\n" +
                "                                              <tbody>\n" +
                "                                                <tr>\n" +
                "                                                  <td\n" +
                "                                                    style=\"direction: ltr; width: 120px; font-size: 0px; padding-bottom: 0px; text-align: center; vertical-align: top; background-image: url(&quot;&quot;); background-repeat: no-repeat; background-size: 100px; background-position: 10% 50%;\">\n" +
                "                                                    <div\n" +
                "                                                      style=\"font-size: 13px; text-align: left; direction: ltr; display: inline-block; vertical-align: top; width: 100%;\">\n" +
                "                                                      <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"\n" +
                "                                                        role=\"presentation\" width=\"100%\" style=\"vertical-align: top;\">\n" +
                "                                                        <tbody>\n" +
                "                                                          <tr>\n" +
                "                                                            <td align=\"left\"\n" +
                "                                                              style=\"font-size: 0px; padding: 20px 9px; word-break: break-word;\">\n" +
                "                                                              <div class=\"text\"\n" +
                "                                                                style=\"margin: 0px; text-align: left; color: rgb(255, 255, 255); font-size: 12px;\">\n" +
                "                                                                <div>\n" +
                "                                                                  <p style=\"line-height: 20px; margin: 0px;\">\n" +
                "                                                                  巴黎之春1103室</p>\n" +
                "                                                                </div>\n" +
                "                                                              </div>\n" +
                "                                                            </td>\n" +
                "                                                          </tr>\n" +
                "                                                        </tbody>\n" +
                "                                                      </table>\n" +
                "                                                    </div>\n" +
                "                                                  </td>\n" +
                "                                                </tr>\n" +
                "                                              </tbody>\n" +
                "                                            </table>\n" +
                "                                          </div>\n" +
                "                                        </div>\n" +
                "                                      </td>\n" +
                "                                    </tr>\n" +
                "                                  </tbody>\n" +
                "                                </table>\n" +
                "                              </td>\n" +
                "                            </tr>\n" +
                "                          </tbody>\n" +
                "                        </table>\n" +
                "                      </td>\n" +
                "                    </tr>\n" +
                "                  </tbody>\n" +
                "                </table>\n" +
                "              </td>\n" +
                "            </tr>\n" +
                "          </tbody>\n" +
                "        </table>\n" +
                "      </div>\n" +
                "    </div>\n" +
                "  </div>";
                StringBuilder sb = new StringBuilder(html);
                sb.append(html1)
                        .append(html2)
                        .append(html3).append(html4)
                        .append(html5)
                        .append(html6)
                        .append(html7)
                        .append(html8).append(html9)
                        .append(html10)
                        .append(html11)
                        .append(html12)
                        .append(html13)
                        .append(html14).append(html15)
                        .append(html16)
                        .append(html17)
                        .append(html18)
                        .append(html19)
                        .append(html20)
                        .append(html21)
                        .append(html22)
                        .append(html23)
                        .append(html24)
                        .append(html25)
                .append(html26)
                .append(html27);

        return sb.toString();
    }


}
