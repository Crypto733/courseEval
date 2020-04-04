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
        //Man får ändra denna väldigt ofta för att SQLite filen inte uppdateras endast om man inte lägger till
        mydb.insertLoginData("mumt17@student.bth.se","mumt17","s");
        mydb.insertLoginData("saab17@student.bth.se","saab17","s");
        mydb.insertLoginData("adab17@student.bth.se","adab17","s");
        mydb.insertLoginData("malo17@student.bth.se","malo17","s");
        mydb.insertLoginData("liab18@student.bth.se","liab18","s");
        mydb.insertLoginData("mahi18@student.bth.se","mahi18","s");
        mydb.insertLoginData("raha18@student.bth.se","raha18","s");
        mydb.insertLoginData("lyto18@student.bth.se","lyto18","s");
        mydb.insertLoginData("flop19@student.bth.se","flop19","s");
        mydb.insertLoginData("tryo19@student.bth.se","tryo19","s");

        mydb.insertLoginData("martin@bth.se","m12","e");
        mydb.insertLoginData("hej@bth.se","q","e");
        mydb.insertLoginData("abbas@bth.se","a","e");

        mydb.insertCourseData("DV1558" , "Tillämpad Programmering i Java" , "abbas@bth.se");
        mydb.insertCourseData("DV1559" , "Inledande Programmering i Java" , "abbas@bth.se");
        mydb.insertCourseData("IY1417" , "Mikroekonomi" , "martin@bth.se");
        mydb.insertCourseData("PA1459", "Objektorienterad Design", "hej@bth.se");
        mydb.insertCourseData("MA1446" , "Analys 2" , "hej@bth.se");
        mydb.insertCourseData("FY1424" , "Fysik 3" , "hej@bth.se");

        mydb.insertLoginData("riab@bth.se","riab","a");
        mydb.insertLoginData("rash@bth.se","rash","a");
        mydb.insertLoginData("macy@bth.se","macy","a");
        mydb.insertLoginData("wito@bth.se","wito","a");
    }

}
