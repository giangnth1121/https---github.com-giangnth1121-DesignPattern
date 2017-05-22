package com.example.tuanjio.mvcexample.mvp.presenter;

import android.content.Context;


import com.example.tuanjio.mvcexample.mvp.model.Student;
import com.example.tuanjio.mvcexample.mvp.view.MvpView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TuanJio on 5/17/2017.
 */

public class MvpPresenter {
    private Context mContext;
    private MvpView mView;

    public MvpPresenter(Context context, MvpView view) {
        this.mContext = context;
        this.mView = view;
    }

    public void initDataForList() {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Student student = new Student("Xuan" + i, 26 + i);
            students.add(student);
        }
        mView.initDateStudentSuggest(students);
    }

    public void addNewStudent(List<Student> students) {
        students.add(new Student("Tuan", 26));
        mView.updateSucces(students);
    }
}
