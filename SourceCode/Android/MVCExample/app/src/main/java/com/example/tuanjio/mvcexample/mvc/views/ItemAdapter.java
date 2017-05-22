package com.example.tuanjio.mvcexample.mvc.views;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tuanjio.mvcexample.R;
import com.example.tuanjio.mvcexample.mvc.models.objects.Student;

import java.util.List;

/**
 * Created by TuanJio on 5/12/2017.
 */
/*
* Dùng để chứa adapter xử lý giao diện
* */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.StudentViewHold> {
    private List<Student> mStudents;

    public ItemAdapter(List<Student> students) {
        this.mStudents = students;
    }

    @Override
    public StudentViewHold onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
        return new StudentViewHold(view);
    }

    @Override
    public void onBindViewHolder(StudentViewHold holder, int position) {
        Student student = mStudents.get(position);
        holder.tvStudentName.setText(student.getName());
        holder.tvStudentAge.setText(student.getAge()+"");
    }

    @Override
    public int getItemCount() {
        return mStudents.size();
    }

    class StudentViewHold extends RecyclerView.ViewHolder {
        TextView tvStudentName;
        TextView tvStudentAge;

        public StudentViewHold(View itemView) {
            super(itemView);
            tvStudentName = (TextView) itemView.findViewById(R.id.tv_sinhvien_name);
            tvStudentAge = (TextView) itemView.findViewById(R.id.tv_sinhvien_age);
        }
    }
}
