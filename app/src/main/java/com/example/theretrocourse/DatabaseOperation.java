package com.example.theretrocourse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.reflect.Array;


public class DatabaseOperation extends SQLiteOpenHelper {
    public static final String database_name ="retro.db";
    public static final String table_name ="teacher_table";
    public static final String table_name2 ="student_table";
    public static final String table_name3 ="admin_table";
    public static final String table_name4 ="course_table";

    public static final String col_1 ="BTH_mail";
    public static final String col_2 ="Password";

    public static final String col_1c ="course_code";
    public static final String col_2c ="course_name";
    public static final String col_3c ="BTH_mail";

    public DatabaseOperation(Context context){
        super(context, database_name, null, 1);

    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE "+ table_name+"(BTH_mail VARCHAR PRIMARY KEY,Password TEXT)");
        db.execSQL("CREATE TABLE "+ table_name2+"(BTH_mail VARCHAR PRIMARY KEY,Password TEXT)");
        db.execSQL("CREATE TABLE "+ table_name3+"(BTH_mail VARCHAR PRIMARY KEY,Password TEXT)");
        db.execSQL("CREATE TABLE "+ table_name4 +"(course_code VARCHAR PRIMARY KEY,course_name TEXT, FOREIGN KEY (BTH_mail) REFERENCES "+ table_name+ "(BTH_mail))");    }

    public Cursor findLoginData(String bth_mail, String pass){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=null;
        if (MainActivity.type.equals("e")) {
            cursor = db.rawQuery("SELECT*FROM " + table_name, null);
        }
        if (MainActivity.type.equals("s")) {
            cursor = db.rawQuery("SELECT*FROM " + table_name2, null);
        }
        if (MainActivity.type.equals("a")) {
            cursor = db.rawQuery("SELECT*FROM " + table_name3, null);
        }
        return cursor;
    }

    // om vi ska visa kurserna senare kan vi kalla på denna metoden
    public Cursor displayCourse(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT*FROM "+ table_name4,null);
        return cursor;
    }
    // om vi ska visa kurserna senare kan vi kalla på denna metoden


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS "+ table_name);
        db.execSQL("DROP TABLE IF EXISTS "+ table_name2);
        db.execSQL("DROP TABLE IF EXISTS "+ table_name3);
        db.execSQL("DROP TABLE IF EXISTS "+ table_name4);
        onCreate(db);
    }
    public void insertLoginData(String BTH_mail, String pass){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_1,BTH_mail);
        contentValues.put(col_2,pass);
        db.insert(table_name,null,contentValues);
        db.insert(table_name2,null,contentValues);
        db.insert(table_name3,null,contentValues);
    }
    public void insertCourseData(String course_code, String course_name, String BTH_mail){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_1c,course_code);
        contentValues.put(col_2c,course_name);
        contentValues.put(col_3c,BTH_mail);
        db.insert(table_name4,null,contentValues);
    }
}