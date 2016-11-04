package com.my.android.demo.jhchen.RecycleView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.my.android.demo.jhchen.R;

import java.util.List;

/**
 * Created by jhchen on 2016/11/4.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter{
    List<String> mItemDataList;
    Context mContext;

    public MyRecyclerViewAdapter(Context context, List<String> mItemDataList) {
        this.mItemDataList = mItemDataList;
        mContext = context;
    }

    public void updateData(List<String> mItemDataList){
        this.mItemDataList = mItemDataList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mItemDataList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_view_item_layout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //((ViewHolder)holder).text.setText(mItemDataList.get(position));
        View itemView = holder.itemView;
        TextView text = (TextView) itemView.findViewById(R.id.recycle_item_text);
        text.setText(mItemDataList.get(position));

    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView text;
        public ViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.recycle_item_text);
        }
    }
}
