package com.example.theretrocourse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Creation extends AppCompatActivity implements View.OnClickListener{
    DatabaseOperation mydb;
    AnswerEvaluation answerEvaluation;
    private Button btn, btnPublish;
private EditText keyword;
private RadioGroup rg1,rg2,rg3,rg4,rg5;
RadioButton btnSelected1,btnSelected2,btnSelected3,btnSelected4,btnSelected5;
EditText comment1,comment2,comment3,comment4,comment5;
private int num=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation);

        mydb = new DatabaseOperation(this);
        rg1 = findViewById(R.id.radioGroup);
        rg2 = findViewById(R.id.radioGroup2);
        rg3 = findViewById(R.id.radioGroup3);
        rg4 = findViewById(R.id.radioGroup4);
        rg5 = findViewById(R.id.radioGroup5);

        comment1=(EditText)findViewById(R.id.editText1);
        comment2=(EditText)findViewById(R.id.editText2);
        comment3=(EditText)findViewById(R.id.editText3);
        comment4=(EditText)findViewById(R.id.editText4);
        comment5=(EditText)findViewById(R.id.editText5);

        keyword=(EditText)findViewById(R.id.editTextKeyword);

        btn = findViewById(R.id.btn);
        btnPublish = findViewById(R.id.btnPublish);
        btn.setOnClickListener(this);
        btnPublish.setOnClickListener(this);
    }

    private TextView txt;

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                num++;
                if(num<=12 && num>=1) {
                    txt = findViewById(R.id.textView + (num));
                    txt.setText(keyword.getText());
                }
                else{
                    Toast.makeText(this,"You can't enter more keywords", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btnPublish:
                keyword.setVisibility(View.GONE);
                btn.setVisibility(View.GONE);
                // btnPublish.setVisibility(View.GONE);
                validateData();
                break;
        }

    }
    public void validateData(){
        String comment_1=comment1.getText().toString().trim();
        String comment_2=comment2.getText().toString().trim();
        String comment_3=comment3.getText().toString().trim();
        String comment_4=comment4.getText().toString().trim();
        String comment_5=comment5.getText().toString().trim();
        if (comment_1.isEmpty()) {
            comment1.setError("Field can't be empty");
        }
        if (comment_2.isEmpty()) {
            comment2.setError("Field can't be empty");
        }
        if (comment_3.isEmpty()) {
            comment3.setError("Field can't be empty");
        }
        if (comment_4.isEmpty()) {
            comment4.setError("Field can't be empty");
        }
        if (comment_5.isEmpty()) {
            comment5.setError("Field can't be empty");
        }

        storeInformation(comment_1,comment_2,comment_3,comment_4,comment_5);
    }
    public void storeInformation(String comment_1,String comment_2,String comment_3,String comment_4,String comment_5){
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
                comment_1,comment_2,comment_3,comment_4,comment_5);
        Toast.makeText(Creation.this, answerEvaluation.toString(),Toast.LENGTH_LONG).show();
    }
}
