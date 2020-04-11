package com.example.theretrocourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
// Detta är för TEACHER!
public class seeStudentAnswersT extends AppCompatActivity implements View.OnClickListener {
    int currentItem = 0;
    private Button btn;
    public static TextView rubric;
    ArrayAdapter<String> adapterStuAns;
    public static String text, text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answers);

        DatabaseOperation mydb = new DatabaseOperation(this);

        btn = findViewById(R.id.btnShowResult);
        btn.setOnClickListener(this);

        rubric = findViewById(R.id.CourseText);
        rubric.setText(TeacherMainPAge.text2);

        final Spinner answers = (Spinner) findViewById(R.id.spinner6);
        ArrayList<String> publishStuAnsList = new ArrayList<String>();
        insertDataSpinner6(publishStuAnsList,answers,mydb);

        answers.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(currentItem==position){
                    return;
                }
                else{
                    text = answers.getItemAtPosition(position).toString(); // setter student x
                    Intent intent = new Intent(seeStudentAnswersT.this, AnAnswerT.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    public void insertDataSpinner6(ArrayList<String> publishedCourseList, Spinner answers, DatabaseOperation mydb){
        publishedCourseList.add("Choose below: ");
        Cursor cursor = mydb.resultTable();
        while (cursor.moveToNext()){
            if (cursor.getString(9).equals(TeacherMainPAge.text2)){
                publishedCourseList.add("Student " + cursor.getString(0));
            }
        }
        adapterStuAns = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, publishedCourseList);
        adapterStuAns.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        answers.setAdapter(adapterStuAns);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnShowResult:
                Intent intent = new Intent(seeStudentAnswersT.this, GenerateResultT.class);
                startActivity(intent);
                break;
        }
    }
}
