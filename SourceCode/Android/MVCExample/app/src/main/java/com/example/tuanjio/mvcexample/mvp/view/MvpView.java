package com.example.tuanjio.mvcexample.mvp.view;

import com.example.tuanjio.mvcexample.mvp.model.Student;

import java.util.List;

/**
 * Created by TuanJio on 5/17/2017.
 */

public interface MvpView {
    void initDateStudentSuggest(List<Student> students);

    void updateSucces(List<Student> students);
}
