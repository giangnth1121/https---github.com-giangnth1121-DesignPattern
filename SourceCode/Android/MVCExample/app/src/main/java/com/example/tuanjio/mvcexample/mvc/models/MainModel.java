package com.example.tuanjio.mvcexample.mvc.models;

import com.example.tuanjio.mvcexample.mvc.models.objects.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by TuanJio on 5/12/2017.
 */

/*Liên quan đến xử lý lấy dữ liệu, không bao gồm model class
* */
public class MainModel extends Observable {
    private static List<Student> sMItemStudents;
    private static int mCurrentId;

    public MainModel() {
        sMItemStudents = new ArrayList<>();
        loadDataItemSinhVien();
    }

    public void loadDataItemSinhVien() {
        for (int i = 0; i < 6; i++) {
            sMItemStudents.add(new Student("Tuan", 12 + i));
        }
        mCurrentId = 6;
    }

    //Toa method tra ve danh sach Items cho view
    public List<Student> getmItemSinhViens() {
        return sMItemStudents;
    }

    // Tao method add item
    public void addNewItem() {
        sMItemStudents.add(new Student("Sinh vien moi " + (mCurrentId + 1), 15));
        mCurrentId++;
        setChanged();
        notifyObservers(sMItemStudents);
    }

    // Tao ham tra ve id 1 item
    public String getItemName(int position) {
        return sMItemStudents.get(position).getName();
    }
}
