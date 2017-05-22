package com.example.tuanjio.mvcexample.mvp.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tuanjio.mvcexample.R;
import com.example.tuanjio.mvcexample.mvc.login.InfoActivity;
import com.example.tuanjio.mvcexample.mvp.login.presenter.PresenterLoginSimple;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivityMvpSimple extends AppCompatActivity implements ViewLoginSimple {

    @BindView(R.id.edt_name)
    EditText edtName;
    @BindView(R.id.edt_password)
    EditText edtPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    private PresenterLoginSimple mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        tvTitle.setText("Kiến trúc MVP simple");
        mPresenter = PresenterLoginSimple.getInstance(this);
    }


    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        String userName = edtName.getText().toString();
        String passWord = edtPassword.getText().toString();
        mPresenter.handleLogin(userName, passWord);
    }

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
