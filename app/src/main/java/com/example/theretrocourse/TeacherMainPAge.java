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
    ArrayAdapter<String> adapterResultsCourse;
    public static String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_main_page);
        DatabaseOperation mydb = new DatabaseOperation(this);
        final Spinner avCourses = (Spinner) findViewById(R.id.spinner2);
        Spinner reCourses = (Spinner) findViewById(R.id.spinner3);

        ArrayList<String> avbCourseList = new ArrayList<String>();
        ArrayList<String> resCourseList = new ArrayList<String>();
        insertDataSpinner2(avbCourseList,avCourses,mydb);
        insertDataSpinner3(resCourseList,reCourses,mydb);

        avCourses.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (currentItem == position) {
                    return;
                } else {
                    text = avCourses.getItemAtPosition(position).toString();
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
         public void insertDataSpinner2(ArrayList<String> coursesList, Spinner avCourses, DatabaseOperation mydb){
        coursesList.add("Choose below: ");
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
    public void insertDataSpinner3(ArrayList<String> resCourseList,Spinner reCourses, DatabaseOperation mydb){
        resCourseList.add("Choose below: ");
        //fortsätt då studenter gjort course evaluation
        // och visa färdiga course evaluation som teacher kan kommentera på(hämta från evaluation_table för att se resultat)
        adapterResultsCourse = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, resCourseList);
        adapterResultsCourse.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        reCourses.setAdapter(adapterResultsCourse);
    }
}
