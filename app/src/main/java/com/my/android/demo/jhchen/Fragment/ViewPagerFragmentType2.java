package com.my.android.demo.jhchen.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.my.android.demo.jhchen.R;

/**
 * Created by ch999 on 2016/10/26.
 */

public class ViewPagerFragmentType2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_type2_layout, null);
        return view;
    }
}
