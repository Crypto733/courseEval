package com.example.theretrocourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;


public class TeacherMainPAge extends AppCompatActivity {
    int currentItem = 0;
     ArrayAdapter<String> adapterAvailableCourse;
     ArrayAdapter<String> adapterResultsCourse;
    public static String text,text2;
    AnswerEvaluation [] evaluations;
    static Spinner avCourses,reCourses;
    ArrayList<String> avbCourseList,resCourseList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_main_page);
        DatabaseOperation mydb = new DatabaseOperation(this);
        avCourses = (Spinner) findViewById(R.id.spinner2);
        reCourses = (Spinner) findViewById(R.id.spinner3);



        evaluations = new AnswerEvaluation[10];
        avbCourseList = new ArrayList<String>();
        resCourseList = new ArrayList<String>();
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
                    text2 = reCourses.getItemAtPosition(position).toString();
                    Intent intent = new Intent(TeacherMainPAge.this, CourseAnswers.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
         public void insertDataSpinner2(ArrayList<String> avbCourseList, Spinner avCourses, DatabaseOperation mydb){
             avbCourseList.add("Choose below: ");
             Cursor cursor = mydb.findCourses();
             while (cursor.moveToNext()){
                 if (cursor.getString(2).equals(Login.mail)){
                     avbCourseList.add(cursor.getString(1));
                 }
             }
             adapterAvailableCourse = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, avbCourseList);
             adapterAvailableCourse.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
             avCourses.setAdapter(adapterAvailableCourse);
    }
    //viktigt att informationen är rätt i databasen för denna
    public void insertDataSpinner3(ArrayList<String> resCourseList,Spinner reCourses, DatabaseOperation mydb) {
        resCourseList.add("Choose below: ");
        Cursor cursor = mydb.findFinishedCourses();
            while (cursor.moveToNext()) {
                if (cursor.getCount()==0)
                    return;
                else
                resCourseList.add(cursor.getString(0));
            }
        adapterResultsCourse = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, resCourseList);
        adapterResultsCourse.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        reCourses.setAdapter(adapterResultsCourse);
    }
}