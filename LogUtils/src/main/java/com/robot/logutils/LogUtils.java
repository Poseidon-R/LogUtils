package com.robot.logutils;

import com.blankj.utilcode.util.ThrowableUtils;
import com.guangli.base.util.Logger;

/**
 * 本地日志记录
 */
public class LogUtils {

    public static void d(String msg) {
        LogDataUtils.getInstance().write("d", msg);
        Logger.d(msg);
    }

    public static void d(String msg, Throwable throwable) {
        LogDataUtils.getInstance().write("d", msg);
        Logger.d(msg, throwable);
    }

    public static void d(String tag, String msg) {
        LogDataUtils.getInstance().write("d", tag + ":" + msg);
        Logger.d(tag, msg);
    }

    public static void v(String msg) {
        LogDataUtils.getInstance().write("v", msg);
        Logger.v(msg);
    }

    public static void v(String msg, Throwable throwable) {
        LogDataUtils.getInstance().write("v", msg);
        Logger.v(msg, throwable);
    }

    public static void v(String tag, String msg) {
        LogDataUtils.getInstance().write("v", tag + ":" + msg);
        Logger.v(tag, msg);
    }

    public static void e(String msg) {
        LogDataUtils.getInstance().write("e", msg);
        Logger.e(msg);
    }

    public static void e(String msg, Throwable throwable) {
        LogDataUtils.getInstance().write("e", msg);
        Logger.e(msg, throwable);
    }

    public static void i(String tag, String msg) {
        LogDataUtils.getInstance().write("u", tag + ":" + msg);
        Logger.i(tag, msg);
    }

    public static void i(String msg) {
        LogDataUtils.getInstance().write("i", msg);
        Logger.i(msg);
    }

    public static void i(String msg, Throwable throwable) {
        LogDataUtils.getInstance().write("i", msg);
        Logger.i(msg, throwable);
    }

    public static void e(String tag, String msg) {
        LogDataUtils.getInstance().write("e", tag + ":" + msg);
        Logger.e(tag, msg);
    }

    public static void w(String msg) {
        LogDataUtils.getInstance().write("w", msg);
        Logger.w(msg);
    }

    public static void w(Throwable throwable) {
        LogDataUtils.getInstance().write("w", ThrowableUtils.getFullStackTrace(throwable));
        Logger.w(throwable);
    }

    public static void w(String msg, Throwable throwable) {
        LogDataUtils.getInstance().write("w", msg);
        Logger.w(msg, throwable);
    }

    public static void w(String tag, String msg) {
        LogDataUtils.getInstance().write("w", tag + ":" + msg);
        Logger.w(tag, msg);
    }
}
