package com.my.android.demo.jhchen.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.my.android.demo.jhchen.R;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jhchen on 2016/10/26.
 */

public class ViewPagerFragmentType1 extends Fragment{
    @ViewInject(id = R.id.fragment_list_view)
    ListView fragmentListView;

    List<String> mDataList = new ArrayList<String>();
    FragmentType1ListAdapter mListViewAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_teype1_layout, null);
        FinalActivity.initInjectedView(this, view);
        initListView();
        return view;
    }

    void initListView(){
        initDataList();
        mListViewAdapter = new FragmentType1ListAdapter(getActivity(), mDataList);
        fragmentListView.setAdapter(mListViewAdapter);
        fragmentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "onClick " + mDataList.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    void initDataList(){
        mDataList.clear();
        mDataList.add("item1");
        mDataList.add("item2");
        mDataList.add("item3");
        mDataList.add("item4");
        mDataList.add("item5");
        mDataList.add("item6");
        mDataList.add("item7");
        mDataList.add("item8");
        mDataList.add("item9");
        mDataList.add("item10");
        mDataList.add("item11");

    }

}
