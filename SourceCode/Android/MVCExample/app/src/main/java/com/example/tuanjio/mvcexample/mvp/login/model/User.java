package com.example.tuanjio.mvcexample.mvp.login.model;

/**
 * Created by TuanJio on 5/17/2017.
 */

public class User {
    private String mName;
    private String mPassWord;

    public User(){

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
    }

    public String getPassWord() {
        return mPassWord;
    }

    public void setPassWord(String passWord) {
        mPassWord = passWord;
    }
}
