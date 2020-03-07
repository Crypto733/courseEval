package com.example.theretrocourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener{
    Intent intent;
    EditText e_name,e_pass;
    Button Login;
    DatabaseOperation mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        e_name=(EditText)findViewById(R.id.editText);
        e_pass=(EditText)findViewById(R.id.editText2);
        Login = findViewById(R.id.login);
        Login.setOnClickListener(this);
        mydb= new DatabaseOperation(this);
    }
    public void addData(){
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = mydb.insertLoginData(e_name.getText().toString(),e_pass.getText().toString());
                if(isInserted=true)
                    Toast.makeText(Login.this,"Data inserted!", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(Login.this,"Error: data not inserted", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(MainActivity.type=="s"){
            addData();
            intent = new Intent(this,StudentMainPage.class);
            startActivity(intent);
        }
        if(MainActivity.type=="e"){
            addData();
            intent = new Intent(this,TeacherMainPAge.class);
            startActivity(intent);
        }
        if(MainActivity.type=="a"){
            addData();
            intent = new Intent(this,Creation.class);
            startActivity(intent);
        }

    }
}
