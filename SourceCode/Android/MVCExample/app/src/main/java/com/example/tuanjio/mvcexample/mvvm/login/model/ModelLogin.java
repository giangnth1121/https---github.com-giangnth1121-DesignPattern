package com.example.tuanjio.mvcexample.mvvm.login.model;

import com.example.tuanjio.mvcexample.mvp.login.model.User;
import com.example.tuanjio.mvcexample.mvp.login.presenter.LoginResponseToPresenterlistener;

/**
 * Created by TuanJio on 5/17/2017.
 */

public class ModelLogin {
   /*Xư lý logic*/
    private LoginResponseToPresenterlistener mCallBack;
    public ModelLogin(LoginResponseToPresenterlistener callBack){
        mCallBack = callBack;
    }

    // Giả định call Api
    public com.example.tuanjio.mvcexample.mvp.login.model.User getUserLoginApi() {
        com.example.tuanjio.mvcexample.mvp.login.model.User user = new com.example.tuanjio.mvcexample.mvp.login.model.User("tuannx", "1234");
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
