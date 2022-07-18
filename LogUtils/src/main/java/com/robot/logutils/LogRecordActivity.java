package com.robot.logutils;

import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;


import com.blankj.utilcode.util.ToastUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class LogRecordActivity extends AppCompatActivity {

    private static final int SCROLL_DOWN_CODE = 1005;

    private long scrollTime;

    private RecyclerView rvDebugApi;

    private DebugApiAdapter debugApiAdapter;

    private final SimpleDateFormat debugApiDateFormat = new SimpleDateFormat("MM-dd hh:mm:ss.SSS");


    private Handler mMainHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {

                case SCROLL_DOWN_CODE:
                    if (debugApiAdapter != null && debugApiAdapter.getData().size() > 0) {
                        debugApiAdapter.notifyDataSetChanged();
                        synchronized (debugApiAdapter.getData()) {
                            rvDebugApi.scrollToPosition(debugApiAdapter.getData().size() - 1);
                        }
                    }
                    break;
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_record);
        rvDebugApi = findViewById(R.id.rv_debug_api);
        debugApiAdapter = new DebugApiAdapter(mOnLongClickListener);
        rvDebugApi.setAdapter(debugApiAdapter);
        debugApiAdapter.getData().addAll(LogDataUtils.getInstance().getData());
        debugApiAdapter.notifyDataSetChanged();
        scrollToBottom();
    }


    public DebugApiAdapter.OnLongClickListener mOnLongClickListener = () -> {
        ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ArrayList<LogEntity> copyList;
        synchronized (LogRecordActivity.this.debugApiAdapter.getData()) {
            copyList = new ArrayList<>(LogRecordActivity.this.debugApiAdapter.getData());
        }
        cm.setText(copyList.toString());
        ToastUtils.showShort("调试信息全部复制成功");
    };


    /**
     * Scroll to down
     */
    private void scrollToBottom() {
        mMainHandler.removeMessages(SCROLL_DOWN_CODE);
        if (System.currentTimeMillis() - scrollTime > 200) {
            scrollTime = System.currentTimeMillis();
            mMainHandler.sendEmptyMessage(SCROLL_DOWN_CODE);
        } else {
            mMainHandler.sendEmptyMessageDelayed(SCROLL_DOWN_CODE, 200);
        }
    }

}
