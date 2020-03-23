package com.example.theretrocourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener{
    Intent intent;
    EditText e_mail,e_pass;
    Button Login;
    DatabaseOperation mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        e_mail=(EditText)findViewById(R.id.editText);
        e_pass=(EditText)findViewById(R.id.editText2);
        Login = findViewById(R.id.login);
        Login.setOnClickListener(this);
        mydb= new DatabaseOperation(this);
        insertTestData();
    }

    @Override
    public void onClick(View v) {

        String mail = e_mail.getText().toString();
        String pass = e_pass.getText().toString();
        Cursor cursor = mydb.findLoginData(mail,pass);

        switch (MainActivity.type){
            case "s":
                Boolean foundS = false;
                while (cursor.moveToNext()){
                    if (cursor.getString(0).equals((mail) ) &&
                            cursor.getString(0).contains("@student.bth.se") &&
                            cursor.getString(1).equals(pass))
                        foundS = true;
                }
                if (foundS==true){
                    Toast.makeText(Login.this,"Login successful!", Toast.LENGTH_LONG).show();
                    intent = new Intent(this, StudentMainPage.class);
                    startActivity(intent);
                }
                else if (foundS==false){
                    Toast.makeText(Login.this,"Error: Email or password incorrect", Toast.LENGTH_LONG).show();
                }
                break;
            case "e":
                Boolean foundE = false;
                while (cursor.moveToNext()){
                    if (cursor.getString(0).equals(mail)&&
                            cursor.getString(0).contains("@bth.se")
                            && cursor.getString(1).equals(pass))
                        foundE = true;
                }
                if (foundE==true){
                    Toast.makeText(Login.this,"Login successful!", Toast.LENGTH_LONG).show();
                    intent = new Intent(this, TeacherMainPAge.class);
                    startActivity(intent);
                }
                else if (foundE==false){
                    Toast.makeText(Login.this,"Error: Email or password incorrect", Toast.LENGTH_LONG).show();
                }
                break;
            case "a":
                Boolean foundA = false;
                while (cursor.moveToNext()){
                    if (cursor.getString(0).equals(mail) &&
                            cursor.getString(0).contains("@bth.se") &&
                            cursor.getString(1).equals(pass))
                        foundA = true;
                }
                if (foundA==true){
                    Toast.makeText(Login.this,"Login successful!", Toast.LENGTH_LONG).show();
                    intent = new Intent(this, AdminMainPage.class);
                    startActivity(intent);
                }
                else if (foundA==false){
                    Toast.makeText(Login.this,"Error: Email or password incorrect", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }
    // "@student.bth.se" om det är en student och "@bth.se" om admin eller lärare
    public void insertTestData(){
        mydb.insertLoginData("m@student.bth.se","12","s");
        mydb.insertLoginData("b@student.bth.se","b12","s");
        mydb.insertLoginData("c@bth.se","c12","e");
        mydb.insertLoginData("d@bth.se","d12","e");
        mydb.insertCourseData("MA1447" , "Flerdimensionell Analys" , "c@bth.se");
        mydb.insertCourseData("FY1423" , "Fysik 2" , "d@bth.se");
    }
}