package com.example.theretrocourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;


public class TeacherMainPAge extends AppCompatActivity {
    int currentItem = 0;
    ArrayAdapter<String> adapterAvailableCourse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_main_page);
        DatabaseOperation mydb = new DatabaseOperation(this);
        Spinner avCourses = (Spinner) findViewById(R.id.spinner2);
        Spinner reCourses = (Spinner) findViewById(R.id.spinner3);

        ArrayList<String> coursesList = new ArrayList<String>();
        insertDataSpinner(coursesList,avCourses,mydb);

        avCourses.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (currentItem == position) {
                    return;
                } else {
                    Intent intent = new Intent(TeacherMainPAge.this, Creation.class);
                    startActivity(intent);
                     }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        reCourses.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (currentItem == position) {
                    return;
                } else {
                    Intent intent = new Intent(TeacherMainPAge.this, CourseAnswers.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
         public void insertDataSpinner(ArrayList<String> coursesList, Spinner avCourses, DatabaseOperation mydb){
             Cursor cursor = mydb.findCourses();
             while (cursor.moveToNext()){
                 if (cursor.getString(2).equals(Login.mail)){
                     coursesList.add(cursor.getString(1));
                 }
             }
             adapterAvailableCourse = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, coursesList);
             adapterAvailableCourse.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
             avCourses.setAdapter(adapterAvailableCourse);
    }
}
