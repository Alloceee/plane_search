package com.yws.plane.util;

import com.qiniu.util.Md5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间转换工具类
 *
 * @Author: yewenshu https://github.com/Alloceee
 * @Date: 2019/11/9 23:52
 * @Project: plane_search
 */
public class TimeUtils {
    public static final String PATTERN1 = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN2 = "yyyy-MM-dd";
    /**
     * 字符串转化为日期格式
     *
     * @param dateString 日期格式的字符串
     * @param pattern    转化形式
     * @return 转换后的日期
     */
    public static Date stringToDate(String dateString, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 日期转化为字符串形式
     *
     * @param date    需要转化的日期
     * @param pattern 转化形式
     * @return 转化后的字符串
     */
    public static String dateToString(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static String subStartTime(String time) {
        return time.substring(0, 19);
    }

    public static String subEndTime(String time) {
        return time.substring(22);
    }

    /**
     * 获取当天日期的md5值
     * @return
     */
    public static String getMd5Day(){
        Date date = new Date();
        String dataStr = dateToString(date,PATTERN2);
        return  Md5.md5(dataStr.getBytes());
    }
}
