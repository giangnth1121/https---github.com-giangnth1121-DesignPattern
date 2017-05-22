package com.example.tuanjio.mvcexample.listener;

import android.view.View;

/**
 * Created by TuanJio on 5/17/2017.
 */

public interface ClickListener {
    void onClick(View view, int postion);

    void onLongClick(View view, int position);
}
