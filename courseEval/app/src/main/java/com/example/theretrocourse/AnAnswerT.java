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

public class AnAnswerT extends AppCompatActivity{
    DatabaseOperation mydb;
    private String[] temp = new String[12];
    private String[] words = new String[12];
    private TextView txt, rt1,rt2,rt3,rt4,rt5,rt6,rt7,rubric, studentNum;
    private EditText comment;
    String courseID = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_an_answer);
        mydb = new DatabaseOperation(this);
        comment = findViewById(R.id.editText5);
        rubric = findViewById(R.id.courseName);
        studentNum = findViewById(R.id.studentNum);
        studentNum.setText(seeStudentAnswersT.text); // printar ut student x
        rubric.setText(TeacherMainPAge.text2); //printar ut kursens namn

        //settar radiobutton svaren
        rt1 = findViewById(R.id.tr1);
        rt2 = findViewById(R.id.tr2);
        rt3 = findViewById(R.id.tr3);
        rt4 = findViewById(R.id.tr4);
        rt5 = findViewById(R.id.tr5);
        rt6 = findViewById(R.id.tr6);
        rt7 = findViewById(R.id.tr7);


        //dessa två metoder borde funka, men de innehåller null detta måste fixas annars crashas systemet
        setKeywords(); //settar keywords
        courseID = seeStudentAnswersT.text.split(" ")[1];
        setCommentandRadioButtons(courseID); //settar kommentarsfältet och radiobutton svaren


    }

    private void setCommentandRadioButtons(String courseID) {
        Cursor cursor = mydb.resultTable();
        while (cursor.moveToNext()){
            if(courseID.equals(cursor.getString(0))) {
              comment.setText(cursor.getString(8));
                rt1.setText(cursor.getString(1));
                rt2.setText(cursor.getString(2));
                rt3.setText(cursor.getString(3));
                rt4.setText(cursor.getString(4));
                rt5.setText(cursor.getString(5));
              //  rt6.setText(cursor.getString(6));
                rt7.setText(cursor.getString(7));

            }
        }
    }


    public void setKeywords(){
        Cursor cursor = mydb.findKeywords();
        while (cursor.moveToNext()){
            if(TeacherMainPAge.text2.equals(cursor.getString(0))) {
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

}
