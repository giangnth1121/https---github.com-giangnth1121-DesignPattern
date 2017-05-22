package com.example.tuanjio.mvcexample.mvvm.login.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.tuanjio.mvcexample.R;

import com.example.tuanjio.mvcexample.databinding.ActivityLoginMvvmBinding;
import com.example.tuanjio.mvcexample.mvc.login.InfoActivity;
import com.example.tuanjio.mvcexample.mvp.login.view.ViewLoginSimple;
import com.example.tuanjio.mvcexample.mvvm.login.modelview.LoginViewModel;


public class LoginActivityMvvm extends AppCompatActivity implements ViewLoginSimple {

    private LoginViewModel mLoginViewMode;
    private ActivityLoginMvvmBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_login_mvvm);
        init();
    }

    private void init() {
        mLoginViewMode = new LoginViewModel(this);
        mBinding.setViewModel(mLoginViewMode);
        mBinding.setView(this);


        // mUser = new User();
        // User user = new User("nickdangnhap","pass");
        //mBinding.setUser(mUser);
        /*// Test two way binding
        mBinding.getRoot().postDelayed(new Runnable() {
            @Override
            public void run() {
                mUser.setName("tuantuthan");
                mUser.setPassWord("1234");
            }
        }, 2000);*/

        //initUser2();
    }

   /* private void initUser2() {
        mUser2 = new User2();
        mBinding.setUser2(mUser2);

        // Test two way binding
        mBinding.getRoot().postDelayed(new Runnable() {
            @Override
            public void run() {
                mUser2.mName.set("tuantuthan");
                mUser2.mPassWord.set("1234");
            }
        }, 2000);
    }*/


    @Override
    public void onLoginSuccess() {
        Intent intent = new Intent(getApplicationContext(), InfoActivity.class);
        startActivity(intent);
    }

    @Override
    public void onLoginFailed() {
        Toast.makeText(getApplicationContext(), "Thông tin bạn nhập chưa chính xác vui lòng nhập lại!", Toast.LENGTH_SHORT).show();
    }
}
