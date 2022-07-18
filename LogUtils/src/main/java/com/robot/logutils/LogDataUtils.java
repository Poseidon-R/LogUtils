package com.robot.logutils;


import android.content.Intent;

import com.blankj.utilcode.util.ActivityUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 日志数据记录
 */
public class LogDataUtils {

    private static LogDataUtils instance = null;

    private final List<LogEntity> data;


    private LogDataUtils() {
        data = new ArrayList<>();
    }

    public static void init() {
        if (instance == null) {
            instance = new LogDataUtils();
        }
    }

    public static LogDataUtils getInstance() {
        if (instance == null) {
            throw new IllegalArgumentException("please init LogDataUtils");
        }
        return instance;
    }

    private final SimpleDateFormat debugApiDateFormat = new SimpleDateFormat("MM-dd hh:mm:ss.SSS");

    public void write(String type, String logMsg) {
        String msg = debugApiDateFormat.format(System.currentTimeMillis()) + "/" + type + "/:             " + logMsg;
        synchronized (data) {
            LogEntity logEntity = new LogEntity(type, msg.toCharArray());
            data.add(logEntity);
            if (data.size() > 10000) {
                data.remove(0);
            }
        }
    }

    public void toLogPage() {
        ActivityUtils.startActivity(LogRecordActivity.class);
    }

    public List<LogEntity> getData() {
        return data;
    }

}
