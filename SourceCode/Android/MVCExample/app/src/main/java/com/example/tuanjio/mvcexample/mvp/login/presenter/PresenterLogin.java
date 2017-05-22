package com.example.tuanjio.mvcexample.mvp.login.presenter;

import com.example.tuanjio.mvcexample.mvp.login.model.ModelLogin;
import com.example.tuanjio.mvcexample.mvp.login.model.ModelLoginSimple;
import com.example.tuanjio.mvcexample.mvp.login.model.User;
import com.example.tuanjio.mvcexample.mvp.login.view.ViewLoginSimple;

/**
 * Created by TuanJio on 5/17/2017.
 */

public class PresenterLogin implements LoginResponseToPresenterlistener {
    private ViewLoginSimple mView;
    private ModelLogin mModel;

    public static PresenterLogin getInstance(ViewLoginSimple view) {
        PresenterLogin presenter = new PresenterLogin();
        presenter.mView = view;
        return presenter;
    }

    public void recievedHandleLogin(String userName, String passWord) {
        mModel = new ModelLogin(this);
        mModel.handleLogin(userName, passWord);
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
