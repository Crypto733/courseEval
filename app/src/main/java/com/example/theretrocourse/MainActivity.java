package com.example.theretrocourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static String type = "";
    Intent intent;
    DatabaseOperation mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb = new DatabaseOperation(this);

        Button Student = findViewById(R.id.student);
        Button Employee = findViewById(R.id.employee);
        Button Admin = findViewById(R.id.admin);

        Student.setOnClickListener(this);
        Employee.setOnClickListener(this);
        Admin.setOnClickListener(this);
        insertTestData();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.student:
                type = "s";
                intent = new Intent(this, Login.class);
                startActivity(intent);
                break;
            case R.id.employee:
                type = "e";
                intent = new Intent(this, Login.class);
                startActivity(intent);
                break;
            case R.id.admin:
                type = "a";
                intent = new Intent(this, Login.class);
                startActivity(intent);
                break;

        }
    }
    public void insertTestData() {
        mydb.insertLoginData("@student.bth.se", "1", "s");

        mydb.insertLoginData("c@bth.se", "1", "a");

        mydb.insertLoginData("hej@bth.se", "q", "e");

        mydb.insertCourseData("FY1423", "Fysik 2", "@student.bth.se");
        mydb.insertCourseData("MA1447", "Flerdimensionell Analys", "hej@bth.se");
        mydb.insertCourseData("PA1459", "Objektorienterad Design", "hej@bth.se");
    }

}
