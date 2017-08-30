package com.bhyf.util;


/**
 * 项目名称：rising-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/12/10 13:23
 * 修改人：caizh
 * 修改时间：2015/12/10 13:23
 * 修改备注：
 */
public class SMSSender {

    private static final String api = ConfigProperties.getInstance().get("sms.api");
    private static final String usr = ConfigProperties.getInstance().get("sms.usr");
    private static final String pwd = ConfigProperties.getInstance().get("sms.pwd");

    public static boolean sendMsg(String mobile,String content){
        boolean flag =false;
        StringBuffer sendData = new StringBuffer();
        sendData.append("usr=").append(usr).append("&pwd=").append(pwd).append("&mobile=").append(mobile)
                .append("&sms=").append(content);
        try{

            String result = HttpUtil.sendPost(api, sendData.toString(), "gbk");
            String[] results =result.split("\\,");
            if("0".equals(results[0])){
                flag = true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }



}
