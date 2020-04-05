package com.example.theretrocourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class Creation extends AppCompatActivity implements View.OnClickListener{
    private Button btn, btnPublish;
    String [] words;
    private EditText keyword;
    private int num=0;
    public static TextView rubric;
    private TextView txt;
    DatabaseOperation mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation);

        rubric=findViewById(R.id.tttttt);
        rubric.setText(TeacherMainPAge.text);

        keyword=(EditText)findViewById(R.id.editTextKeyword);
        words = new String[13];
        mydb = new DatabaseOperation(this);
        btn = findViewById(R.id.btn);
        btnPublish = findViewById(R.id.btnSubmit);
        btn.setOnClickListener(this);
        btnPublish.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                num++;
                if(num<=12 && num>=1) {
                    txt = findViewById(R.id.textView + (num));
                    txt.setText(keyword.getText());
                    words[num]=txt.getText().toString();
                }
                else{
                    Toast.makeText(this,"You can't enter more keywords", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btnSubmit:
                boolean isInserted = insertData(words,num);
                if (isInserted=true) {
                    Toast.makeText(this, "Evaluation published successfully!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(this, "Error: Data not inserted!", Toast.LENGTH_LONG).show();
                break;
        }

    }
    public boolean insertData(String [] words, int num){
       for (int i=0;i<=num;i++){
           mydb.insertKeywordsCourseEval(TeacherMainPAge.text,words[i]);
        }
        return true;
    }
}
