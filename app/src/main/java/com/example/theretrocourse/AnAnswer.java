package com.example.theretrocourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class AnAnswer extends AppCompatActivity implements View.OnClickListener {
DatabaseOperation mydb;
    private String[] temp = new String[12];
    private String[] words = new String[12];
    private TextView txt;
    private EditText comment;
    private Button button;
    private String id = "";
    RadioGroup rg1,rg2,rg3,rg4,rg5,rg6,rg7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_an_answer);
        comment = findViewById(R.id.editText5);
        button = findViewById(R.id.remove);
        button.setOnClickListener(this);
        txt = findViewById(R.id.tttttt);
        txt.setText(seeStudentAnswers.text);

        //dessa två metoder borde funka, men de innehåller null detta måste fixas annars crashas systemet
        setKeywords();
        setCommentandRadioButtons();


        rg1 = findViewById(R.id.radioGroup);
        rg2 = findViewById(R.id.radioGroup2);
        rg3 = findViewById(R.id.radioGroup3);
        rg4 = findViewById(R.id.radioGroup4);
        rg5 = findViewById(R.id.radioGroup5);
        rg6 = findViewById(R.id.radioGroup6);
        rg7 = findViewById(R.id.radioGroup7);

    }

    private void setCommentandRadioButtons() {
        Cursor cursor = mydb.resultTable();
        while (cursor.moveToNext()){
            if(seeStudentAnswers.text.equals(cursor.getString(0))) {
              comment.setText(cursor.getString(8));
                rg1.check(Integer.parseInt(cursor.getString(1)));
                rg2.check(Integer.parseInt(cursor.getString(2)));
                rg3.check(Integer.parseInt(cursor.getString(3)));
                rg4.check(Integer.parseInt(cursor.getString(4)));
                rg5.check(Integer.parseInt(cursor.getString(5)));
                rg6.check(Integer.parseInt(cursor.getString(6)));
                rg7.check(Integer.parseInt(cursor.getString(7)));
            }
        }
    }


    public void setKeywords(){
        Cursor cursor = mydb.findKeywords();
        while (cursor.moveToNext()){
            if(StudentMainPage.text.equals(cursor.getString(0))) {
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //har inte testat om denna fungerar
            case R.id.remove:
                //ta bort svaret och gå tillbaka
                id = txt.getText().toString();
                int id2 = Integer.parseInt(id);
                mydb.deleteStudentAnswer(id2);
                Toast.makeText(this,"You removed a students answer!",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(AnAnswer.this,seeStudentAnswers.class);
                startActivity(intent);
                break;
        }
    }
}
