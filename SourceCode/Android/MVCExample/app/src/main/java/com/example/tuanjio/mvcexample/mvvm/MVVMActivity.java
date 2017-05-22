package com.example.tuanjio.mvcexample.mvvm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.tuanjio.mvcexample.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MVVMActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvvm);
        ButterKnife.bind(this);
    }
}
