package com.example.tuanjio.mvcexample.viper.presenter;

import com.example.tuanjio.mvcexample.mvp.login.presenter.LoginResponseToPresenterlistener;
import com.example.tuanjio.mvcexample.mvp.login.view.ViewLoginSimple;
import com.example.tuanjio.mvcexample.viper.interactor.InteractorLogin;
import com.example.tuanjio.mvcexample.viper.routing.RoutingLogin;
import com.example.tuanjio.mvcexample.viper.view.ViewLoginViper;

/**
 * Created by TuanJio on 5/18/2017.
 */
/*Trái ngược với Interactor, Presenter chủ yếu chứa các logic để điều khiển UI.
* Presenter: bao gồm view logic để hiển thị các dữ liệu nhận được từ Interactor và xử lý user input (bằng cách yêu cầu dữ liệu mới từ Interactor).
* */
public class PresenterLogin implements LoginResponseToPresenterlistener {
    InteractorLogin interactorLogin;
    private ViewLoginViper mView;
    RoutingLogin routingLogin;

    public static PresenterLogin getInstance(ViewLoginViper view,RoutingLogin routingLogin) {
        PresenterLogin presenter = new PresenterLogin();
        presenter.mView = view;
        presenter.routingLogin = routingLogin;
        return presenter;
    }

    public void recievedHandleLogin(String userName, String passWord) {
        interactorLogin = new InteractorLogin(this);
        interactorLogin.handleLogin(userName, passWord);
    }

    @Override
    public void onLoginSuccess() {
        routingLogin.sangManHinhInfo();
    }

    @Override
    public void onLoginFailed() {
        mView.onLoginFailed("Loi roi em");
    }
}
