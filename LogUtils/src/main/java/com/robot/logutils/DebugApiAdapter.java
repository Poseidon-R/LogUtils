package com.robot.logutils;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import me.goldze.mvvmhabit.utils.StringUtils;

public class DebugApiAdapter extends RecyclerView.Adapter<DebugApiAdapter.ViewHolder> implements View.OnLongClickListener {

    private final List<LogEntity> data = new ArrayList<>();
    private final OnLongClickListener mOnLongClickListener;

    public DebugApiAdapter(OnLongClickListener onLongClickListener) {
        mOnLongClickListener = onLongClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_debug_api, parent, false);
        v.setOnLongClickListener(this);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        synchronized (data) {
            if (position < data.size()) {
                if (StringUtils.equals(data.get(position).getType(), "v")) {
                    // log -v
                    holder.mTv.setTextColor(Color.parseColor("#ffffff"));
                    holder.mTv.setText(data.get(position).getData(), 0, data.get(position).getData().length);
                } else if (StringUtils.equals(data.get(position).getType(), "d")) {
                    // log -d
                    holder.mTv.setTextColor(Color.parseColor("#ffffff"));
                    holder.mTv.setText(data.get(position).getData(), 0, data.get(position).getData().length);
                } else if (StringUtils.equals(data.get(position).getType(), "i")) {
                    // log -i
                    holder.mTv.setTextColor(Color.parseColor("#ffffff"));
                    holder.mTv.setText(data.get(position).getData(), 0, data.get(position).getData().length);
                } else if (StringUtils.equals(data.get(position).getType(), "w")) {
                    // log -w
                    holder.mTv.setTextColor(Color.parseColor("#00ff00"));
                    holder.mTv.setText(data.get(position).getData(), 0, data.get(position).getData().length);
                } else {
                    // log -e
                    holder.mTv.setTextColor(Color.parseColor("#00ff00"));
                    holder.mTv.setText(data.get(position).getData(), 0, data.get(position).getData().length);
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        synchronized (data) {
            return data.size();
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTv = (TextView) itemView.findViewById(R.id.tv_debug_api);
        }
    }

    @Override
    public boolean onLongClick(View view) {
        mOnLongClickListener.onLongClick();
        return false;
    }

    /**
     * 长按点击回调
     */
    public interface OnLongClickListener {
        /**
         * Click event callback
         */
        void onLongClick();
    }

    public List<LogEntity> getData() {
        return data;
    }
}
