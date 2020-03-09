package com.example.theretrocourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static String type="";
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         Button Student = findViewById(R.id.student);
         Button  Employee = findViewById(R.id.employee);
         Button Admin= findViewById(R.id.admin);

         Student.setOnClickListener(this);
         Employee.setOnClickListener(this);
         Admin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.student:
                type="s";
                intent = new Intent(this,Login.class);
                startActivity(intent);
                break;
            case R.id.employee:
                type="e";
                intent = new Intent(this,Login.class);
                startActivity(intent);
                break;
            case R.id.admin:
                type="a";
                intent = new Intent(this,Login.class);
                startActivity(intent);
                break;

        }
    }
}
