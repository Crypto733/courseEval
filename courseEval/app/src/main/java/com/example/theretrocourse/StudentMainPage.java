package com.example.theretrocourse;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class StudentMainPage extends AppCompatActivity implements View.OnClickListener{
    int currentItem = 0;
    ArrayAdapter<String> adapterAvailableCourse;
    ArrayAdapter<String> adapterResultsCourse;
    public static String text;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_main_page);
        DatabaseOperation mydb = new DatabaseOperation(this);
        Button logout = findViewById(R.id.btnLogout);
        logout.setOnClickListener(this);
        final Spinner avCourses = (Spinner) findViewById(R.id.spinner2);
        Spinner reCourses = (Spinner) findViewById(R.id.spinner3);

        ArrayList<String> publishedCourseList = new ArrayList<String>();
        ArrayList<String> resCourseList = new ArrayList<String>();
        insertDataSpinner2(publishedCourseList,avCourses,mydb);
        insertDataSpinner3(resCourseList,reCourses,mydb);

        avCourses.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(currentItem==position){
                    return;
                }
                else{
                    text = avCourses.getItemAtPosition(position).toString();
                    Intent intent = new Intent(StudentMainPage.this, EvaluationStudent.class);
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
                else {

                   // Intent intent = new Intent(StudentMainPage.this, CourseAnswers.class);
                    //startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
// Toast.makeText(StudentMainPage.this, "Error: No available evaluation for " + Login.mail, Toast.LENGTH_LONG).show();
    public void insertDataSpinner2(ArrayList<String> publishedCourseList, Spinner avCourses, DatabaseOperation mydb){
        publishedCourseList.add("Choose below: ");
        Cursor cursor = mydb.findStudentCourse();
        while (cursor.moveToNext()){
            if (cursor.getString(1).equals(Login.mail)){
                publishedCourseList.add(cursor.getString(0));
            }
        }
        adapterAvailableCourse = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, publishedCourseList);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogout:
                Toast.makeText(this,"You have logged out!",Toast.LENGTH_SHORT).show();
                 Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}