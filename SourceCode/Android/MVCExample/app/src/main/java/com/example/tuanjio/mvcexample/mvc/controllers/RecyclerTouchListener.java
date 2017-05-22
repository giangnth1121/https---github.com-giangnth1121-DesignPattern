package com.example.tuanjio.mvcexample.mvc.controllers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.example.tuanjio.mvcexample.listener.ClickListener;

/**
 * Created by TuanJio on 5/12/2017.
 */
// Controller: Ta coi Activity, Fragment,... chứa View, Controller( onclick, onTouch,...): có hai lớp class và xml
    /*Tại sao đã có view và controller ta lại còn tạo thêm 1 folder cho thằng controller
    * Ví dụ ta có một bài toán như sau: Sử dụng 1 recycleview khi click vào 1 button ta sẽ thêm vào 1 item
    * Với listview nó có sự kiện onItemClickListener có sẵn rồi nhưng thằng recycleView không có, vì vậy cần có thêm 1 package controller chứa các lớp bắt sự kiện không có sẵn
    * */

public class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

    private GestureDetector gestureDetector;
    private ClickListener clickListener;

    public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
        this.clickListener = clickListener;
        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                if (child != null && clickListener != null) {
                    clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                }
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

        View child = rv.findChildViewUnder(e.getX(), e.getY());
        if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
            clickListener.onClick(child, rv.getChildPosition(child));
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}

