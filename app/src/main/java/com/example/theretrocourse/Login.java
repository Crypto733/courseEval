package com.example.theretrocourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity implements View.OnClickListener{
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button Login = findViewById(R.id.login);
        Login.setOnClickListener(this);
    }

    @Override
    //här behöver vi göra så att programmet tar fram rätt frame för student,teacher eller admin
    public void onClick(View v) {
        if(MainActivity.type=="s"){
            intent = new Intent(this,StudentMainPage.class);
            startActivity(intent);
        }
        if(MainActivity.type=="e"){
            intent = new Intent(this,TeacherMainPAge.class);
            startActivity(intent);
        }
        if(MainActivity.type=="a"){
            intent = new Intent(this,Creation.class);
            startActivity(intent);
        }

    }
}
