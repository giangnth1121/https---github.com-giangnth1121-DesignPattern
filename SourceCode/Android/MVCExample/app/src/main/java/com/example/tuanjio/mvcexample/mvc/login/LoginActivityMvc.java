package com.example.tuanjio.mvcexample.mvc.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tuanjio.mvcexample.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivityMvc extends AppCompatActivity {

    @BindView(R.id.edt_name)
    EditText edtName;
    @BindView(R.id.edt_password)
    EditText edtPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tv_title)
    TextView tvTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        tvTitle.setText("Kiến trúc MVC");
    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        String userName = edtName.getText().toString();
        String passWord = edtPassword.getText().toString();
        handleLogin(userName, passWord);
    }

    private void handleLogin(String userName, String passWord) {
        if (userName.equals("tuannx") && passWord.equals("1234")) {
            loginSuccess();
        } else {
            loginFail();
        }
    }

    private void loginFail() {
        Toast.makeText(getApplicationContext(), "Thông tin bạn nhập chưa chính xác vui lòng nhập lại!", Toast.LENGTH_SHORT).show();
    }

    private void loginSuccess() {
        openInfoScreen();
    }

    private void openInfoScreen() {
        Intent intent = new Intent(getApplicationContext(), InfoActivity.class);
        startActivity(intent);
    }
}
