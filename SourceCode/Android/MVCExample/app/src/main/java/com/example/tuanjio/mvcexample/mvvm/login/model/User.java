package com.example.tuanjio.mvcexample.mvvm.login.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.tuanjio.mvcexample.BR;

/**
 * Created by TuanJio on 5/17/2017.
 */
/*two way binding*/
public class User extends BaseObservable {
    @Bindable
    private String mName;
    @Bindable
    private String mPassWord;

    public User() {
        mName = "";
        mPassWord = "";
    }

    public User(String name, String passWord) {
        mName = name;
        mPassWord = passWord;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
        // Cái này nó sẽ giúp cho bạn update dữ liệu lên view khi model thay đổi.
        notifyPropertyChanged(BR.name);
    }

    public String getPassWord() {
        return mPassWord;
    }

    public void setPassWord(String passWord) {
        mPassWord = passWord;
        notifyPropertyChanged(BR.passWord);
    }
}
