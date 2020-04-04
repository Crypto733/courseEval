package com.example.theretrocourse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class EvaluationStudent extends AppCompatActivity implements View.OnClickListener{

    AnswerEvaluation answerEvaluation;
    RadioGroup rg1,rg2,rg3,rg4,rg5,rg6,rg7;
    RadioButton btnSelected1,btnSelected2,btnSelected3,btnSelected4,btnSelected5,btnSelected6,btnSelected7;
    EditText comment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluation_student);

        rg1 = findViewById(R.id.radioGroup);
        rg2 = findViewById(R.id.radioGroup2);
        rg3 = findViewById(R.id.radioGroup3);
        rg4 = findViewById(R.id.radioGroup4);
        rg5 = findViewById(R.id.radioGroup5);
        rg6 = findViewById(R.id.radioGroup6);
        rg7 = findViewById(R.id.radioGroup7);

        comment=(EditText)findViewById(R.id.editText5);

    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSubmit:
                validateData();
                break;
        }

    }
    public void validateData(){
        String str_comment=comment.getText().toString().trim();
        if (str_comment.isEmpty()) {
            comment.setError("Field can't be empty");
        }

        storeInformation(str_comment);
    }
    public void storeInformation(String str_comment){
        btnSelected1=findViewById(rg1.getCheckedRadioButtonId());
        btnSelected2=findViewById(rg2.getCheckedRadioButtonId());
        btnSelected3=findViewById(rg3.getCheckedRadioButtonId());
        btnSelected4=findViewById(rg4.getCheckedRadioButtonId());
        btnSelected5=findViewById(rg5.getCheckedRadioButtonId());
        String btn1=btnSelected1.getText().toString();
        String btn2=btnSelected2.getText().toString();
        String btn3=btnSelected3.getText().toString();
        String btn4=btnSelected4.getText().toString();
        String btn5=btnSelected5.getText().toString();

        //
        answerEvaluation = new AnswerEvaluation("1122",Login.mail,btn1,btn2,btn3,btn4,btn5,
                str_comment);

        Toast.makeText(EvaluationStudent.this, answerEvaluation.toString(),Toast.LENGTH_LONG).show();
    }
}
