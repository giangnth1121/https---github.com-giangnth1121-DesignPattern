package com.example.tuanjio.mvcexample.mvp.login.model;

import com.example.tuanjio.mvcexample.mvp.login.presenter.LoginResponseToPresenterlistener;

/**
 * Created by TuanJio on 5/17/2017.
 */

public class ModelLogin {

    private LoginResponseToPresenterlistener mCallBack;
    public ModelLogin(LoginResponseToPresenterlistener callBack){
        mCallBack = callBack;
    }
    // Call Api
    public User getUserLoginApi() {
        User user = new User("tuannx", "1234");
        return user;
    }

    public void handleLogin(String userName, String passWord) {
        User user = getUserLoginApi();
        if (userName.equals(user.getName()) && passWord.equals(user.getPassWord())) {
            mCallBack.onLoginSuccess();
        } else {
            mCallBack.onLoginFailed();
        }
    }
}
