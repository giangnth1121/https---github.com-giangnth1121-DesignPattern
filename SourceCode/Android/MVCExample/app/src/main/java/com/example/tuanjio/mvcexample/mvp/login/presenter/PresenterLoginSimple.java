package com.example.tuanjio.mvcexample.mvp.login.presenter;

import com.example.tuanjio.mvcexample.mvp.login.model.ModelLoginSimple;
import com.example.tuanjio.mvcexample.mvp.login.model.User;
import com.example.tuanjio.mvcexample.mvp.login.view.ViewLoginSimple;

/**
 * Created by TuanJio on 5/17/2017.
 */

public class PresenterLoginSimple {
    private ViewLoginSimple mView;
    private ModelLoginSimple mModel;

    public static PresenterLoginSimple getInstance(ViewLoginSimple view) {
        PresenterLoginSimple presenter = new PresenterLoginSimple();
        presenter.mView = view;
        return presenter;
    }

    public void handleLogin(String userName, String passWord) {
        mModel = new ModelLoginSimple();
        User user = mModel.getUserLoginApi();

        if (userName.equals(user.getName()) && passWord.equals(user.getPassWord())) {
            mView.onLoginSuccess();
        } else {
            mView.onLoginFailed();
        }
    }
}
