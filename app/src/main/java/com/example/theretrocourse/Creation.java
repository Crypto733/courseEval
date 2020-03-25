package com.example.theretrocourse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Creation extends AppCompatActivity implements View.OnClickListener{
private Button btn, btnPublish;
private EditText keyword;
private int num=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(this);
        btnPublish = findViewById(R.id.btnPublish);
        btnPublish.setOnClickListener(this);
        keyword=(EditText)findViewById(R.id.editText5);
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
                break;
        }

    }
}
