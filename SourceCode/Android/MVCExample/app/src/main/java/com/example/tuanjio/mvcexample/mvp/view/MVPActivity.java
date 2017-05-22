package com.example.tuanjio.mvcexample.mvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.tuanjio.mvcexample.R;
import com.example.tuanjio.mvcexample.mvp.model.Student;
import com.example.tuanjio.mvcexample.mvp.presenter.MvpPresenter;

import java.util.List;

public class MVPActivity extends AppCompatActivity implements MvpView, View.OnClickListener {

    private MvpPresenter mPresenter;
    private RecyclerView mRecyclerView;
    private Button mBtnAdd;
    private ItemAdapter mAdapter;
    private List<Student> mStudents;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        init();
    }

    private void init() {
        mPresenter = new MvpPresenter(MVPActivity.this, this);

        // Anh xa cac view
        mBtnAdd = (Button) findViewById(R.id.btn_add);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycleview);

        mRecyclerView.hasFixedSize();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MVPActivity.this, LinearLayoutManager.VERTICAL, false));
        mPresenter.initDataForList();

        mBtnAdd.setOnClickListener(this);
    }

    @Override
    public void initDateStudentSuggest(List<Student> students) {
        mStudents = students;
        mAdapter = new ItemAdapter(mStudents);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void updateSucces(List<Student> students) {
        mStudents = students;
        mAdapter.notifyDataSetChanged();
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_add) {
            mPresenter.addNewStudent(mStudents);
        }
    }
}
