package com.example.tuanjio.mvcexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tuanjio.mvcexample.mvc.login.LoginActivityMvc;
import com.example.tuanjio.mvcexample.mvp.login.view.LoginActivityMvp;
import com.example.tuanjio.mvcexample.mvvm.login.view.LoginActivityMvvm;
import com.example.tuanjio.mvcexample.viper.view.LoginActivityViper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnMvc, mBtnMvp, mBtnMvvm, mBtnViper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mBtnMvc = (Button) findViewById(R.id.btn_mvc);
        mBtnMvp = (Button) findViewById(R.id.btn_mvp);
        mBtnMvvm = (Button) findViewById(R.id.btn_mvvm);
        mBtnViper = (Button) findViewById(R.id.btn_viper);

        mBtnMvc.setOnClickListener(this);
        mBtnMvp.setOnClickListener(this);
        mBtnMvvm.setOnClickListener(this);
        mBtnViper.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_mvc:
                startActivity(new Intent(getApplicationContext(), LoginActivityMvc.class));
                break;
            case R.id.btn_mvp:
                startActivity(new Intent(getApplicationContext(), LoginActivityMvp.class));
                break;
            case R.id.btn_mvvm:
                startActivity(new Intent(getApplicationContext(), LoginActivityMvvm.class));
                break;
            case R.id.btn_viper:
                startActivity(new Intent(getApplicationContext(), LoginActivityViper.class));
                break;
        }
    }
}
