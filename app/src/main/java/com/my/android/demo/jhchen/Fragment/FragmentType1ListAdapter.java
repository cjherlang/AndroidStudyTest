package com.my.android.demo.jhchen.Fragment;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.joanzapata.android.BaseAdapterHelper;
import com.my.android.demo.jhchen.R;

import java.util.List;

/**
 * Created by jhchen on 2016/10/27.
 */

public class FragmentType1ListAdapter extends BaseAdapter {
    Context mContext;
    List<String> mDataList;

    public FragmentType1ListAdapter(Context context, List<String> mDataList) {
        mContext = context;
        this.mDataList = mDataList;
    }

    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BaseAdapterHelper helper = BaseAdapterHelper.get(mContext, convertView, parent, R.layout.list1_layout);
        helper.setText(R.id.list1_text, mDataList.get(position));
        return helper.getView();
    }

    @Override
    public Object getItem(int position) {
        return mDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
