package com.example.gogogo;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Course extends AppCompatActivity {
    private String name;
    private String date;
    private int imageResourceId;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.coursemain);

        ArrayList<Course> courses = new ArrayList<>();
        courses.add(new Course("코스 이름1", "2024.1.1", R.drawable._11));
        courses.add(new Course("코스 이름2", "2024.2.2", R.drawable.cimage1));
        courses.add(new Course("코스 이름3", "2024.3.3", R.drawable.cimage2));
        courses.add(new Course("코스 이름4", "2024.4.4", R.drawable.cimage3));
        courses.add(new Course("코스 이름5", "2024.5.5", R.drawable.cimage4));

        CourseAdapter adapter = new CourseAdapter(courses);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        ImageButton myButton = (ImageButton) findViewById(R.id.imageButton);
        myButton.setContentDescription("버튼 설명");


    }

    public Course(String name, String date, int imageResourceId) {
        this.name = name;
        this.date = date;
        this.imageResourceId = imageResourceId;
    }
    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }
    public int getImageResourceId() {
        return imageResourceId;
    }
}


