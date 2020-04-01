package com.example.theretrocourse;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class StudentMainPage extends AppCompatActivity{
    int currentItem = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_main_page);


        // gÃ¶r grejer med radiobuttons etc...
        Spinner avCourses = (Spinner) findViewById(R.id.spinner2);
        Spinner reCourses = (Spinner) findViewById(R.id.spinner3);


        avCourses.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(currentItem==position){
                    return;
                }
                else{
                    Intent intent = new Intent(StudentMainPage.this, Creation.class);
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
                if(currentItem==position){
                    return;
                }
                else{
                    Intent intent = new Intent(StudentMainPage.this, CourseAnswers.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}