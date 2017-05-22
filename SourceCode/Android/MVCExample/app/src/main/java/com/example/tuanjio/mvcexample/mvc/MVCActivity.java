package com.example.tuanjio.mvcexample.mvc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.tuanjio.mvcexample.R;
import com.example.tuanjio.mvcexample.mvc.controllers.RecyclerTouchListener;
import com.example.tuanjio.mvcexample.listener.ClickListener;
import com.example.tuanjio.mvcexample.mvc.models.MainModel;
import com.example.tuanjio.mvcexample.mvc.models.objects.Student;
import com.example.tuanjio.mvcexample.mvc.views.ItemAdapter;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class MVCActivity extends AppCompatActivity implements Observer {

    private RecyclerView mRecyclerView;
    private Button mBtnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvc);
        init();
    }

    private void init() {

        // Khoi tao model
        final MainModel mainModel = new MainModel();
        mainModel.addObserver(MVCActivity.this);

        // Anh xa cac view
        mBtnAdd = (Button) findViewById(R.id.btn_add);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycleview);

        mRecyclerView.hasFixedSize();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MVCActivity.this, LinearLayoutManager.VERTICAL, false));

        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainModel.addNewItem();
            }
        });

        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), mRecyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int postion) {
                String studentName = mainModel.getItemName(postion);
                Toast.makeText(getApplicationContext(), studentName, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        mRecyclerView.setAdapter(new ItemAdapter(mainModel.getmItemSinhViens()));
    }

    @Override
    public void update(Observable observable, Object data) {
        List<Student> students = (List<Student>) data;
        mRecyclerView.setAdapter(new ItemAdapter(students));
    }
}
