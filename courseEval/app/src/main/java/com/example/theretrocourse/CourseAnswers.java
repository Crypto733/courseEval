package com.example.theretrocourse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.database.CursorWindowCompat;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.theretrocourse.R.id.btnSubmit2;

public class CourseAnswers extends AppCompatActivity implements View.OnClickListener {
    public static TextView result_rubric;
    private Button btn;
    private int num = 0;
    private EditText teacher_comment;
    DatabaseOperation mydb;
    ArrayList<String> resultList;
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_answers);

        result_rubric = findViewById(R.id.textView);
        result_rubric.setText("Results for " + TeacherMainPAge.text2);

        resultList = new ArrayList<String>();
        btn = findViewById(btnSubmit2);
        teacher_comment = (EditText) findViewById(R.id.editText4);
        mydb = new DatabaseOperation(this);
        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case btnSubmit2:
                printResultsTextView();

                break;
        }
    }
    public void printResultsTextView(){
        Cursor cursor = mydb.resultTable();
        while (cursor.moveToNext()){
            num++;
            resultList.add(cursor.getString(0)+","+cursor.getString(1)+","+
                    cursor.getString(2)+","+cursor.getString(3)+","+
                    cursor.getString(4)+","+cursor.getString(5)+","+
                    cursor.getString(6)+","+ cursor.getString(7));
            txt = findViewById(R.id.textView + (num));
            txt.setText(resultList.get(num));
        }
    }
}
