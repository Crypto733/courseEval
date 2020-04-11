package com.example.theretrocourse;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class GenerateResultT extends AppCompatActivity {
    DatabaseOperation mydb;
    TextView txt ;
    EditText Teacherscomment;
    int[] array;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_result);
        mydb = new DatabaseOperation(this);
        txt = findViewById(R.id.textViewRubric);
        Teacherscomment = findViewById(R.id.editText6);
        txt.setText(TeacherMainPAge.text2);
        array = new int[5];
        chart1();
        chart2();
        chart3();
        chart4();
        chart5();
       // chart6();
        chart7();

        validateAndStoreData();
    }
    public void validateAndStoreData(){
        String str_comment=Teacherscomment.getText().toString().trim();
        if (str_comment.isEmpty()) {
            Teacherscomment.setError("Field can't be empty");
        }
       // storeInformation(str_comment);
    }

    private void chart1() {
         int ans1 = 0,ans2 =0,ans3=0,ans4=0,ans5 = 0;
        PieChartView pieChartView = findViewById(R.id.chart);
        List< SliceValue > pieData = new ArrayList<>();
        Cursor cursor = mydb.resultTableb1();
        while (cursor.moveToNext()){
            if(cursor.getString(1).equals(TeacherMainPAge.text2)){
                if(cursor.getString(0).equals("1"))
                    ans1++;
                if(cursor.getString(0).equals("2"))
                    ans2++;
                if(cursor.getString(0).equals("3"))
                    ans3++;
                if(cursor.getString(0).equals("4"))
                    ans4++;
                if(cursor.getString(0).equals("5"))
                    ans5++;
            }
        }
        array[0] = ans1;
        array[1] = ans2;
        array[2] = ans3;
        array[3] = ans4;
        array[4] = ans5;

        pieData.add(new SliceValue(ans1, Color.BLUE).setLabel("1"));
        pieData.add(new SliceValue(ans2, Color.YELLOW).setLabel("2"));
        pieData.add(new SliceValue(ans3, Color.RED).setLabel("3"));
        pieData.add(new SliceValue(ans4, Color.GREEN).setLabel("4"));
        pieData.add(new SliceValue(ans5, Color.MAGENTA).setLabel("5"));;

        PieChartData pieChartData = new PieChartData(pieData);
        pieChartView.setPieChartData(pieChartData);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);
        pieChartData.setHasCenterCircle(true).setCenterText1("Question 1").setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#0097A7"));
    }
    private void chart2() {
        int ans1 = 0,ans2 =0,ans3=0,ans4=0,ans5 = 0;
        PieChartView pieChartView = findViewById(R.id.chart2);
        List< SliceValue > pieData = new ArrayList<>();
        Cursor cursor = mydb.resultTableb2();
        while (cursor.moveToNext()){
            if(cursor.getString(1).equals(TeacherMainPAge.text2)){
                if(cursor.getString(0).equals("1"))
                    ans1++;
                if(cursor.getString(0).equals("2"))
                    ans2++;
                if(cursor.getString(0).equals("3"))
                    ans3++;
                if(cursor.getString(0).equals("4"))
                    ans4++;
                if(cursor.getString(0).equals("5"))
                    ans5++;
            }
        }
        pieData.add(new SliceValue(ans1, Color.BLUE).setLabel("1"));
        pieData.add(new SliceValue(ans2, Color.YELLOW).setLabel("2"));
        pieData.add(new SliceValue(ans3, Color.RED).setLabel("3"));
        pieData.add(new SliceValue(ans4, Color.GREEN).setLabel("4"));
        pieData.add(new SliceValue(ans5, Color.MAGENTA).setLabel("5"));;

        PieChartData pieChartData = new PieChartData(pieData);
        pieChartView.setPieChartData(pieChartData);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);
        pieChartData.setHasCenterCircle(true).setCenterText1("Question 2").setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#0097A7"));
    }
    private void chart3() {
        int ans1 = 0,ans2 =0,ans3=0,ans4=0,ans5 = 0;
        PieChartView pieChartView = findViewById(R.id.chart3);
        List< SliceValue > pieData = new ArrayList<>();
        Cursor cursor = mydb.resultTableb3();
        while (cursor.moveToNext()){
            if(cursor.getString(1).equals(TeacherMainPAge.text2)){
                if(cursor.getString(0).equals("1"))
                    ans1++;
                if(cursor.getString(0).equals("2"))
                    ans2++;
                if(cursor.getString(0).equals("3"))
                    ans3++;
                if(cursor.getString(0).equals("4"))
                    ans4++;
                if(cursor.getString(0).equals("5"))
                    ans5++;
            }
        }
        pieData.add(new SliceValue(ans1, Color.BLUE).setLabel("1"));
        pieData.add(new SliceValue(ans2, Color.YELLOW).setLabel("2"));
        pieData.add(new SliceValue(ans3, Color.RED).setLabel("3"));
        pieData.add(new SliceValue(ans4, Color.GREEN).setLabel("4"));
        pieData.add(new SliceValue(ans5, Color.MAGENTA).setLabel("5"));;

        PieChartData pieChartData = new PieChartData(pieData);
        pieChartView.setPieChartData(pieChartData);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);
        pieChartData.setHasCenterCircle(true).setCenterText1("Question 3").setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#0097A7"));
    }
    private void chart4() {
        int ans1 = 0,ans2 =0,ans3=0,ans4=0,ans5 = 0;
        PieChartView pieChartView = findViewById(R.id.chart4);
        List< SliceValue > pieData = new ArrayList<>();
        Cursor cursor = mydb.resultTableb4();
        while (cursor.moveToNext()){
            if(cursor.getString(1).equals(TeacherMainPAge.text2)){
                if(cursor.getString(0).equals("1"))
                    ans1++;
                if(cursor.getString(0).equals("2"))
                    ans2++;
                if(cursor.getString(0).equals("3"))
                    ans3++;
                if(cursor.getString(0).equals("4"))
                    ans4++;
                if(cursor.getString(0).equals("5"))
                    ans5++;
            }
        }
        pieData.add(new SliceValue(ans1, Color.BLUE).setLabel("1"));
        pieData.add(new SliceValue(ans2, Color.YELLOW).setLabel("2"));
        pieData.add(new SliceValue(ans3, Color.RED).setLabel("3"));
        pieData.add(new SliceValue(ans4, Color.GREEN).setLabel("4"));
        pieData.add(new SliceValue(ans5, Color.MAGENTA).setLabel("5"));;

        PieChartData pieChartData = new PieChartData(pieData);
        pieChartView.setPieChartData(pieChartData);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);
        pieChartData.setHasCenterCircle(true).setCenterText1("Question 4").setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#0097A7"));
    }
    private void chart5() {
        int ans1 = 0,ans2 =0,ans3=0,ans4=0,ans5 = 0;
        PieChartView pieChartView = findViewById(R.id.chart5);
        List< SliceValue > pieData = new ArrayList<>();
        Cursor cursor = mydb.resultTableb5();
        while (cursor.moveToNext()){
            if(cursor.getString(1).equals(TeacherMainPAge.text2)){
                if(cursor.getString(0).equals("1"))
                    ans1++;
                if(cursor.getString(0).equals("2"))
                    ans2++;
                if(cursor.getString(0).equals("3"))
                    ans3++;
                if(cursor.getString(0).equals("4"))
                    ans4++;
                if(cursor.getString(0).equals("5"))
                    ans5++;
            }
        }
        pieData.add(new SliceValue(ans1, Color.BLUE).setLabel("1"));
        pieData.add(new SliceValue(ans2, Color.YELLOW).setLabel("2"));
        pieData.add(new SliceValue(ans3, Color.RED).setLabel("3"));
        pieData.add(new SliceValue(ans4, Color.GREEN).setLabel("4"));
        pieData.add(new SliceValue(ans5, Color.MAGENTA).setLabel("5"));;

        PieChartData pieChartData = new PieChartData(pieData);
        pieChartView.setPieChartData(pieChartData);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);
        pieChartData.setHasCenterCircle(true).setCenterText1("Question 5").setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#0097A7"));
    }
    private void chart6() {
        int ans1 = 0,ans2 =0,ans3=0,ans4=0,ans5 = 0;
        PieChartView pieChartView = findViewById(R.id.chart6);
        List< SliceValue > pieData = new ArrayList<>();
        Cursor cursor = mydb.resultTableb6();
        while (cursor.moveToNext()){
            if(cursor.getString(1).equals(TeacherMainPAge.text2)){
                if(cursor.getString(0).equals("1"))
                    ans1++;
                if(cursor.getString(0).equals("2"))
                    ans2++;
                if(cursor.getString(0).equals("3"))
                    ans3++;
                if(cursor.getString(0).equals("4"))
                    ans4++;
                if(cursor.getString(0).equals("5"))
                    ans5++;
            }
        }
        pieData.add(new SliceValue(ans1, Color.BLUE).setLabel("1"));
        pieData.add(new SliceValue(ans2, Color.YELLOW).setLabel("2"));
        pieData.add(new SliceValue(ans3, Color.RED).setLabel("3"));
        pieData.add(new SliceValue(ans4, Color.GREEN).setLabel("4"));
        pieData.add(new SliceValue(ans5, Color.MAGENTA).setLabel("5"));;

        PieChartData pieChartData = new PieChartData(pieData);
        pieChartView.setPieChartData(pieChartData);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);
        pieChartData.setHasCenterCircle(true).setCenterText1("Question 6").setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#0097A7"));
    }
    private void chart7() {
        int ans1 = 0,ans2 =0,ans3=0,ans4=0,ans5 = 0;
        PieChartView pieChartView = findViewById(R.id.chart7);
        List< SliceValue > pieData = new ArrayList<>();
        Cursor cursor = mydb.resultTableb7();
        while (cursor.moveToNext()){
            if(cursor.getString(1).equals(TeacherMainPAge.text2)){
                if(cursor.getString(0).equals("1"))
                    ans1++;
                if(cursor.getString(0).equals("2"))
                    ans2++;
                if(cursor.getString(0).equals("3"))
                    ans3++;
                if(cursor.getString(0).equals("4"))
                    ans4++;
                if(cursor.getString(0).equals("5"))
                    ans5++;
            }
        }
        pieData.add(new SliceValue(ans1, Color.BLUE).setLabel("1"));
        pieData.add(new SliceValue(ans2, Color.YELLOW).setLabel("2"));
        pieData.add(new SliceValue(ans3, Color.RED).setLabel("3"));
        pieData.add(new SliceValue(ans4, Color.GREEN).setLabel("4"));
        pieData.add(new SliceValue(ans5, Color.MAGENTA).setLabel("5"));;

        PieChartData pieChartData = new PieChartData(pieData);
        pieChartView.setPieChartData(pieChartData);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);
        pieChartData.setHasCenterCircle(true).setCenterText1("Question 7").setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#0097A7"));
    }

}

