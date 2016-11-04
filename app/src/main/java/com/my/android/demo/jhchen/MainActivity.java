package com.my.android.demo.jhchen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.my.android.demo.jhchen.Fragment.DynamicAddedFragment;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, DynamicAddedFragment.MyFragmentCallBackListener{


    @ViewInject(id = R.id.hello_world_text)
    TextView helloWorldText;
    @ViewInject(id = R.id.add_fragment_btn, click = "onClick")
    Button addFragmentBtn;
    @ViewInject(id = R.id.change_activity_btn, click = "onClick")
    Button changeActivityBtn;
    @ViewInject(id = R.id.btn_view_group)
    LinearLayout btnViewGroup;
    @ViewInject(id = R.id.fragment_content_view_group)
    ScrollView fragmentContentViewGroup;
    @ViewInject(id = R.id.activity_main)
    RelativeLayout activityMain;

    FragmentManager mFragmentManager;
    DynamicAddedFragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("mainActivity", "mainActivity::onCreate()");
        setContentView(R.layout.activity_main);
        FinalActivity.initInjectedView(this);
        addFragment();
    }

    void addFragment(){
        mFragmentManager = getSupportFragmentManager();
        mFragment = new DynamicAddedFragment();
        mFragment.setListener(this);
        Bundle data = new Bundle();
        data.putString("tittle", "fragment1");
        data.putString("content", "contentFragment");
        mFragment.setArguments(data);
        mFragmentManager.beginTransaction().add(R.id.fragment_content_view_group, mFragment, "MAIN_ACTIVITY_FRAGMENT").commit();
        fragmentContentViewGroup.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_fragment_btn:
                fragmentContentViewGroup.setVisibility(View.VISIBLE);
                break;
            case R.id.change_activity_btn:
                Intent intent = new Intent(this, SecondActivity.class);
                intent.putExtra("hello", "I'm MainActivity");
                startActivityForResult(intent, 100);
                break;
            default:
                break;
        }

    }

    @Override
    public void onFragmentCallBack(String content) {
        Toast.makeText(this, content, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("mainActivity", "mainActivity::onActivityResult");
        switch (requestCode){
            case 100:
                if (resultCode == RESULT_OK) {
                    Toast.makeText(this, data.getExtras().getString("backHello"), Toast.LENGTH_LONG).show();
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("mainActivity", "mainActivity::onStart()");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("mainActivity", "mainActivity::onResume()");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("mainActivity", "mainActivity::onRestart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("mainActivity", "mainActivity::onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("mainActivity", "mainActivity::onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
