package com.example.gogogo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {
    private ArrayList<Course> courses;

    public CourseAdapter(ArrayList<Course> courses) {
        this.courses = courses;
    }

    @Override
    public CourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.coursemainlist, parent, false);
        return new CourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CourseViewHolder holder, int position) {
        Course course = courses.get(position);

        holder.courseImage.setImageResource(course.getImageResourceId());
        holder.courseName.setText("Course Name: " + course.getName());
        holder.courseDate.setText("Date: " + course.getDate());
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public static class CourseViewHolder extends RecyclerView.ViewHolder {
        ImageView courseImage;
        TextView courseName;
        TextView courseDate;

        public CourseViewHolder(View itemView) {
            super(itemView);

            courseImage = (ImageView) itemView.findViewById(R.id.coursemain_image);
            courseName = (TextView) itemView.findViewById(R.id.coursename);
            courseDate = (TextView) itemView.findViewById(R.id.date);
        }
    }
}
