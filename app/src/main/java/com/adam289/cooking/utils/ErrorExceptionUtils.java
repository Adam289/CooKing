package com.adam289.cooking.utils;

/**
 * Desc 错误消息提示
 * Created by Adam289 on 2017/3/24.
 */

public class ErrorExceptionUtils {
    public static String getErrorMsg(Throwable e) {
        if (null == e || null == e.getMessage())
            return "网络出问题了";
        String msg;
        String err = e.getMessage();
        if (err.equals("No address associated with hostname")) {
            msg = "网络没有连接";
        } else {
            msg = "网络出问题了";
        }
        return msg;
    }
}
