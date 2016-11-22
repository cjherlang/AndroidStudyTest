package com.my.android.demo.jhchen.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.my.android.demo.jhchen.R;
import com.my.android.demo.jhchen.SecondActivity;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;

/**
 * Created by ch999 on 2016/10/26.
 */

public class DynamicAddedFragment extends Fragment implements View.OnClickListener{
    public interface MyFragmentCallBackListener{
        void onFragmentCallBack(String content);
    }

    MyFragmentCallBackListener mListener;
    @ViewInject(id = R.id.test_bg)
    ImageView testBg;
    @ViewInject(id = R.id.jhchen, click = "onClick")
    TextView jhchen;
    @ViewInject(id = R.id.layout_content, click = "onClick")
    Button layoutContent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("DynamicAddedFragment", "DynamicAddedFragment====onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e("DynamicAddedFragment", "DynamicAddedFragment====onCreateView");

        View view = inflater.inflate(R.layout.relative_layout, null);
        FinalActivity.initInjectedView(this, view);
        Bundle data = getArguments();
        jhchen.setText(data.getString("tittle"));
        layoutContent.setText(data.getString("content"));
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e("DynamicAddedFragment", "DynamicAddedFragment===onActivityCreated");

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e("DynamicAddedFragment", "DynamicAddedFragment===onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("DynamicAddedFragment", "DynamicAddedFragment===onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("DynamicAddedFragment", "DynamicAddedFragment===onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e("DynamicAddedFragment", "DynamicAddedFragment===onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.layout_content:
                mListener.onFragmentCallBack("fragment back");
                break;
            case R.id.jhchen:
                Intent intent = new Intent(getActivity(), SecondActivity.class);
                intent.putExtra("hello", "I'm MainActivity");
                startActivityForResult(intent, 100);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        Toast.makeText(getActivity(), "onActivityResult" + resultCode, Toast.LENGTH_SHORT).show();
    }

    public void setListener(MyFragmentCallBackListener Listener) {
        this.mListener = Listener;
    }
}
