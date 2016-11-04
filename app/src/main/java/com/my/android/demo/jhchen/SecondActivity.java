package com.my.android.demo.jhchen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.my.android.demo.jhchen.Fragment.ViewPagerFragmentType1;
import com.my.android.demo.jhchen.Fragment.ViewPagerFragmentType2;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ch999 on 2016/10/26.
 */

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{


    @ViewInject(id = R.id.back_btn, click = "onClick")
    Button backBtn;
    @ViewInject(id = R.id.second_activity_tittle)
    TextView secondActivityTittle;
    @ViewInject(id = R.id.secont_activity_tab)
    TabLayout secontActivityTab;
    @ViewInject(id = R.id.view_pager)
    android.support.v4.view.ViewPager viewPager;

    List<Fragment> mFragmentList = new ArrayList<Fragment>();
    List<String > mFragmentTittleList = new ArrayList<String>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity_layout);
        FinalActivity.initInjectedView(this);
        initView();
    }

    private void initView(){
        secontActivityTab.setTabMode(TabLayout.MODE_FIXED);

        initFragments();
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), mFragmentList, mFragmentTittleList));
        secontActivityTab.setupWithViewPager(viewPager);
    }

    private void initFragments(){
        ViewPagerFragmentType1 type1Fragment = new ViewPagerFragmentType1();
        ViewPagerFragmentType2 type2Fragment = new ViewPagerFragmentType2();
        //fragment list
        mFragmentList.clear();
        mFragmentList.add(type1Fragment);
        mFragmentList.add(type2Fragment);
        //tittle list
        mFragmentTittleList.clear();
        mFragmentTittleList.add("test 1");
        mFragmentTittleList.add("test 2");
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.back_btn){
            Intent intent = new Intent();
            intent.putExtra("backHello", "i'm second activity call back");
            setResult(Activity.RESULT_OK, intent);
            finish();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("SecondActivity", "SecondActivity::onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("SecondActivity", "SecondActivity::onResume: ");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("SecondActivity", "SecondActivity::onRestart: ");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("SecondActivity", "SecondActivity::onPause: ");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("SecondActivity", "SecondActivity::onDestroy: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("SecondActivity", "SecondActivity::onStop: ");

    }


    /**
     * 返回键重写
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        Intent intent =new Intent();
//        intent.putExtra("backHello", "i'm second activity call back");
//        setResult(1, intent);
        return super.onKeyDown(keyCode, event);
    }
}
