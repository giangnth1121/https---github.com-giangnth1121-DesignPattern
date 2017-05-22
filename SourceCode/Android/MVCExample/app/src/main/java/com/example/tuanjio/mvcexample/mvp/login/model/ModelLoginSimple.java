package com.example.tuanjio.mvcexample.mvp.login.model;

/**
 * Created by TuanJio on 5/17/2017.
 */

public class ModelLoginSimple {
    // Call Api
    public User getUserLoginApi() {
        User user = new User("tuannx","1234");
        return user;
    }
}
