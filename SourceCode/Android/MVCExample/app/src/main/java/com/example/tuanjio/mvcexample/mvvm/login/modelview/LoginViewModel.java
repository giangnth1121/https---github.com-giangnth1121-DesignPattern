package com.example.tuanjio.mvcexample.mvvm.login.modelview;

import android.databinding.ObservableField;

import com.example.tuanjio.mvcexample.mvp.login.presenter.LoginResponseToPresenterlistener;
import com.example.tuanjio.mvcexample.mvp.login.view.ViewLoginSimple;
import com.example.tuanjio.mvcexample.mvvm.login.model.ModelLogin;
import com.example.tuanjio.mvcexample.mvvm.login.model.User;

/**
 * Created by TuanJio on 5/17/2017.
 */

public class LoginViewModel implements LoginResponseToPresenterlistener {
    private ViewLoginSimple mView;
    private ModelLogin mModel;

    /*public ObservableField<String> userName;
    public ObservableField<String> passWord;*/
    public ObservableField<User> user;

    public LoginViewModel(ViewLoginSimple view) {
        /*this.userName = new ObservableField<>();
        this.passWord = new ObservableField<>();*/
        this.user = new ObservableField<User>(new User("",""));
        this.mView = view;
        // loadFullUser();
    }

    private void loadFullUser() {
       /* userName = new ObservableField<String>("tuanok");
        passWord = new ObservableField<String>("1234");*/
        user= new ObservableField<User>(new User("tuanok","1234"));
    }

    public void onClickLogin(LoginViewModel login) {
        // userName.set("tuannx");
        mModel = new ModelLogin(this);
        mModel.handleLogin(login.user.get().getName(), login.user.get().getPassWord());
    }

    public void recievedHandleLogin(User user) {
        mModel = new ModelLogin(this);
        mModel.handleLogin(user.getName(), user.getPassWord());
    }

    @Override
    public void onLoginSuccess() {
        mView.onLoginSuccess();
    }

    @Override
    public void onLoginFailed() {
        mView.onLoginFailed();
    }
}
