package com.example.tuanjio.mvcexample.viper.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tuanjio.mvcexample.R;
import com.example.tuanjio.mvcexample.mvc.login.InfoActivity;
import com.example.tuanjio.mvcexample.mvp.login.view.ViewLoginSimple;
import com.example.tuanjio.mvcexample.viper.presenter.PresenterLogin;
import com.example.tuanjio.mvcexample.viper.routing.RoutingLogin;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*Trong trường hợp này chính là các ViewController, nhưng chúng bị động, chỉ chờ để nhận lệnh xử lí từ Presenter.
* View: hiển thị những gì nó được Presenter thông báo tới và gởi lại các sự kiện tương tác của user đến Presenter.*/
public class LoginActivityViper extends AppCompatActivity implements ViewLoginViper {

    @BindView(R.id.edt_name)
    EditText edtName;
    @BindView(R.id.edt_password)
    EditText edtPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    private PresenterLogin mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        tvTitle.setText("Kiến trúc VIPER");
        RoutingLogin routingLogin = new RoutingLogin(LoginActivityViper.this);
        mPresenter = PresenterLogin.getInstance(this, routingLogin);
    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        String userName = edtName.getText().toString();
        String passWord = edtPassword.getText().toString();
        mPresenter.recievedHandleLogin(userName, passWord);
    }

    @Override
    public void onLoginSuccess() {
        Intent intent = new Intent(getApplicationContext(), InfoActivity.class);
        startActivity(intent);
    }

    @Override
    public void onLoginFailed(String messageError) {
        Toast.makeText(getApplicationContext(), messageError, Toast.LENGTH_SHORT).show();
    }

}
