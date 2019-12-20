package com.yws.plane.util;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 短信发送工具类
 */
public class MessageUtil {

    /**
     * 验证码发送
     *
     * @param phone 手机号
     * @param code  验证码
     * @return
     */
    public static String sendCode(String phone, Integer code) {
        String host = "http://yzxyzm.market.alicloudapi.com";
        String path = "/yzx/verifySms";
        String method = "POST";
        String appcode = "41f47e47440b44eb87a847a145a36721";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("phone", phone);
        querys.put("templateId", "TP18040314");
        querys.put("variable", "code:" + code);
        Map<String, String> bodys = new HashMap<String, String>();

        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            return EntityUtils.toString(response.getEntity());
            //获取response的body
            //System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
