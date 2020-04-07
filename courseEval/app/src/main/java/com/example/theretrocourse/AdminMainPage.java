package com.example.theretrocourse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AdminMainPage extends AppCompatActivity implements View.OnClickListener {
    int currentItem = 0;
    ArrayAdapter<String> adapterAvailableCourse;
    private TextView txt;
    public static String text;
    EditText acronym;
    ImageView picture;
    Button next;
    DatabaseOperation mydb;
    static Spinner avCourses;
    public static String name = "";
    public static ImageView yourpicture = null;
    ArrayList<String> avbCourseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main_page);
        mydb = new DatabaseOperation(this);

        acronym = findViewById(R.id.editText3);
        txt = findViewById(R.id.Welcometxt);
        next = findViewById(R.id.button);
        picture = findViewById(R.id.imageView5);

        next.setOnClickListener(this);

        avCourses = (Spinner) findViewById(R.id.spinner);
        avbCourseList = new ArrayList<String>();

        publishYourNameandPic();

        avCourses.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (currentItem == position) {
                    return;
                } else {
                    text = avCourses.getItemAtPosition(position).toString();
                    Intent intent = new Intent(AdminMainPage.this, CourseCRUDY.class);
                    startActivity(intent);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void publishYourNameandPic() {
        Cursor cursor1 = mydb.admin();
        while(cursor1.moveToNext()) {
              if(Login.mail.equals(cursor1.getString(0))){
                  txt.setText("Welcome " + cursor1.getString(1) + "!");
                  if(cursor1.getString(0).equals("riab@bth.se")){
                      picture.setImageResource(R.drawable.rim);
                  }
                  if(cursor1.getString(0).equals("rash@bth.se")){
                      picture.setImageResource(R.drawable.rania);
                  }
                  if(cursor1.getString(0).equals("wito@bth.se")){
                      picture.setImageResource(R.drawable.wito);
                  }
                  if(cursor1.getString(0).equals("macy@bth.se")){
                      picture.setImageResource(R.drawable.rim);
                  }
              }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                   // printa ut alla i spinner
                name = acronym.getText().toString().trim();
                insertDataSpinner(avbCourseList,avCourses,mydb);

        }
    }

    public void insertDataSpinner(ArrayList<String> avbCourseList, Spinner avCourses, DatabaseOperation mydb){
        avbCourseList.add("Choose below: ");
        Cursor cursor = mydb.findCreatedEval();
        while (cursor.moveToNext()){
            if (cursor.getString(1).equals(name)){
                    avbCourseList.add(cursor.getString(0));

            }
        }
        adapterAvailableCourse = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, avbCourseList);
        adapterAvailableCourse.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        avCourses.setAdapter(adapterAvailableCourse);
    }
}
