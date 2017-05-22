package com.example.tuanjio.mvcexample.viper.interactor;

import com.example.tuanjio.mvcexample.mvp.login.model.User;
import com.example.tuanjio.mvcexample.mvp.login.presenter.LoginResponseToPresenterlistener;

/**
 * Created by TuanJio on 5/18/2017.
 */
/*Interactor chứa bussiness logic
* Interactor: bao gồm business logic mà được xác định bởi 1 Use Case.
* */

public class InteractorLogin {


    private LoginResponseToPresenterlistener mCallBack;

    public InteractorLogin(LoginResponseToPresenterlistener callBack) {
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
