package com.example.tuanjio.mvcexample.mvvm.login.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import com.example.tuanjio.mvcexample.BR;

/**
 * Created by TuanJio on 5/17/2017.
 */
/*two way binding*/
public class User2 {
    public final ObservableField<String> mName= new ObservableField<>();
    public final ObservableField<String> mPassWord= new ObservableField<>();

}
