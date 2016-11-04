package com.my.android.demo.jhchen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.my.android.demo.jhchen.RecycleView.MyRecyclerViewAdapter;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jhchen on 2016/11/4.
 */

public class RecyclerViewActivity extends AppCompatActivity {
    @ViewInject(id = R.id.recycler_add_item)
    Button recyclerAddItem;
    @ViewInject(id = R.id.recycler_remove_item)
    Button recyclerRemoveItem;
    @ViewInject(id = R.id.recycler_view)
    android.support.v7.widget.RecyclerView recyclerView;

    List<String> mItemDataList = new ArrayList<String>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_activity_layout);
        FinalActivity.initInjectedView(this);
        initItemDataList();
        initRecyclerView();
    }

    void initRecyclerView(){
        //RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 4, OrientationHelper.VERTICAL, false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,  OrientationHelper.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new MyRecyclerViewAdapter(this, mItemDataList));
    }

    void initItemDataList(){
        mItemDataList.clear();
        for (int i = 0; i < 15; ++i){
            mItemDataList.add("item" + i);
        }
    }
}
