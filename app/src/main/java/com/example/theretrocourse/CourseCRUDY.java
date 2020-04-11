package com.example.theretrocourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class CourseCRUDY extends AppCompatActivity implements View.OnClickListener{
    public static TextView rubric;
    DatabaseOperation mydb;
    int num = 0;
    private TextView txt;
    Intent intent;
    private Button remove, seeAnswers;
    private String[] temp = new String[12];
    private String[] words = new String[12];
    public static String str = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_c_r_u_d_y);
        remove = findViewById(R.id.btnRemove);
        seeAnswers = findViewById(R.id.btnSeeAnswers);
        mydb = new DatabaseOperation(this);
        rubric = findViewById(R.id.tttttt);
        rubric.setText(AdminMainPage.text);
        remove.setOnClickListener(this);
        seeAnswers.setOnClickListener(this);

        // Tror att metoden funkar, men databasfilen uppdateras inte
        setKeywords();
    }
    public void setKeywords(){
        Cursor cursor = mydb.findKeywords();
        while (cursor.moveToNext()){
            if(AdminMainPage.text.equals(cursor.getString(0))) {
                temp = cursor.getString(1).split(",");
                // copying array org to copy
                words = Arrays.copyOf(temp, 12);
            }
        }
        for(int i = 0; i< words.length; i++){
            txt = findViewById(R.id.textView +(i+1));
            if (txt == null) {
            }
            else{
                txt.setText(words[i]);
            }
        }
    }
   /* private void setKeywords() {
        Cursor cursor = mydb.findKeywords();
        while (cursor.moveToNext()){
            if(StudentMainPage.text.equals(cursor.getString(0))) {
                temp = cursor.getString(1).split(",");
                for(int i = 0; i< temp.length; i++) {
                    Toast.makeText(this, temp.length + temp[i], Toast.LENGTH_LONG).show();
                }
                // copying array org to copy
                words = Arrays.copyOf(temp, 12);
            }
        }
        for(int i = 0; i< words.length; i++){
            txt = findViewById(R.id.textView +(i+1));
            if (!(txt).equals(null)) {
                txt.setText(words[i]);
            }
        }
    }*/

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRemove:
               // ta bort allting!! passa in kurscode rubric
                mydb.deleteEval(rubric.getText().toString());
               // deleteStudentAnswer(AdminMainPage.text, );
                break;
            case R.id.btnSeeAnswers:
                //viewa alla svar
                str = rubric.getText().toString();
                intent = new Intent(this,seeStudentAnswers.class);
                startActivity(intent);
                break;

        }
    }
}
