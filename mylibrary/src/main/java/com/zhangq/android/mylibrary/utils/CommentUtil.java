package com.zhangq.android.mylibrary.utils;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 常用工具beta版
 *
 * @author zhangQ
 * @date 2015-12-18
 * @description
 */
@SuppressWarnings("unused")
public class CommentUtil {
    private SharedPreferences sp;

    public final static double EARTH_RADIUS = 6378137.0;

    /**
     * 计算两个坐标点距离
     *
     * @return
     */
    public double calcDistance(Context context, double lat_a, double lng_a) {
        // TODO: 16/11/27
        double lat_b = 0;
        double lng_b = 0;
        double radLat1 = (lat_a * Math.PI / 180.0);
        double radLat2 = (lat_b * Math.PI / 180.0);
        double a = radLat1 - radLat2;
        double b = (lng_a - lng_b) * Math.PI / 180.0;
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2)
                * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000) / 10000;
        return s;
    }


    /**
     * 获取系统唯一id--udid
     *
     * @param mContext
     * @return
     */
    public String getDeviceID(Context mContext) {
        return ((TelephonyManager) mContext
                .getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
    }

    public static int dp2px(Application app, float dp) {
        float scale = app.getResources()
                .getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }


    /**
     * 判断网络是否链接
     *
     * @param app
     * @return
     */
    public static boolean isNetWork(Application app) {
        ConnectivityManager manager = (ConnectivityManager) app
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] infos = manager.getAllNetworkInfo();
        if (infos == null) {
            return false;
        }
        for (NetworkInfo networkInfo : infos) {
            if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                return true;
            }
        }
        return false;
    }

    /**
     * 关闭键盘
     *
     * @param mContext
     * @param view
     */
    public void CloseKeyBoard(Context mContext, View view) {
        view.clearFocus();
        InputMethodManager imm = (InputMethodManager) mContext
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    /**
     * 验证手机号码
     *
     * @param mobiles
     * @return
     */
    public static boolean isMobileNO(String mobiles) {
        /*
         * 移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
		 * 联通：130、131、132、152、155、156、185、186 电信：133、153、180、189、（1349卫通）
		 * 总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
		 */
        String telRegex = "[1][3456789]\\d{9}";// "[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(mobiles))
            return false;
        else
            return mobiles.matches(telRegex);
    }

    public static String getFormatTime(int time) {
        String returnStr = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date mDate = new Date(time * 1000L);
            Date nowData = new Date();
            String formatString = format.format(mDate);
            long betweenForSec = Math.abs(mDate.getTime() - nowData.getTime()) / 1000; // 秒

            if (mDate.getYear() == nowData.getYear()) { // 同一年

                if (mDate.getMonth() == nowData.getMonth()) { // 同一月

                    if (mDate.getDate() == nowData.getDate()) { // 同一天
                        if (mDate.getHours() == nowData.getHours()) { // 同一个小时

                            if (betweenForSec < 60) {
                                returnStr = betweenForSec + "秒前";
                            } else if (betweenForSec < (60 * 60)) {
                                returnStr = betweenForSec / 60 + "分钟前";
                            }

                        } else {
                            returnStr = formatString.substring(11);
                        }
                    } else if (mDate.getDate() + 1 == nowData.getDate()) { // 昨天

                        returnStr = "昨天 " + formatString.substring(11, 16);
                    } else if (mDate.getDate() + 2 == nowData.getDate()) { // 前天

                        returnStr = "前天 " + formatString.substring(11, 16);
                    } else {
                        returnStr = formatString.substring(5, 16);
                    }

                } else {
                    returnStr = formatString.substring(5, 16);
                }

            } else {
                returnStr = formatString.substring(0, 11);
            }

        } catch (Exception e) {
            returnStr = "TimeError"; // 错误提示
        }
        return returnStr;
    }


}
