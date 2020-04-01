package com.example.theretrocourse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseOperation extends SQLiteOpenHelper {
    public static final String database_name ="retro.db";
    public static final String table_name ="teacher_table";
    public static final String table_name2 ="student_table";
    public static final String table_name3 ="admin_table";
    public static final String table_name4 ="course_table";
    public static final String table_name5 ="studentcourse_table";

    public static final String col_1 ="BTH_mail";
    public static final String col_2 ="Password";
    public static final String col_1c ="CourseCode";
    public static final String col_2c ="CourseName";
    public static final String col_2sc ="CourseID";

    public DatabaseOperation(Context context){
        super(context, database_name, null, 1);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE "+ table_name+"(BTH_mail VARCHAR PRIMARY KEY,Password TEXT)");
        db.execSQL("CREATE TABLE "+ table_name2+"(BTH_mail VARCHAR PRIMARY KEY,Password TEXT)");
        db.execSQL("CREATE TABLE "+ table_name3+"(BTH_mail VARCHAR PRIMARY KEY,Password TEXT)");
        db.execSQL("CREATE TABLE "+ table_name4 +"(CourseCode VARCHAR PRIMARY KEY,CourseName TEXT, " +
                "FOREIGN KEY (BTH_mail) REFERENCES "+ table_name+ "(BTH_mail))");
        db.execSQL("CREATE TABLE "+ table_name5+"(CourseID INT PRIMARY KEY,BTH_mail VARCHAR)");
    }

    public Cursor findLoginData(String bth_mail, String pass){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if (MainActivity.type=="e")
            cursor = db.rawQuery("SELECT*FROM "+ table_name,null);
        if (MainActivity.type=="s")
            cursor = db.rawQuery("SELECT*FROM "+ table_name2,null);
        if (MainActivity.type=="a")
            cursor = db.rawQuery("SELECT*FROM "+ table_name3,null);
        return cursor;
    }
    public Cursor findCourses(){
        SQLiteDatabase db = this.getReadableDatabase();
           Cursor cursor = db.rawQuery("SELECT*FROM "+ table_name4,null);
        return cursor;
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS "+ table_name);
        db.execSQL("DROP TABLE IF EXISTS "+ table_name2);
        db.execSQL("DROP TABLE IF EXISTS "+ table_name3);
        db.execSQL("DROP TABLE IF EXISTS "+ table_name4);
        db.execSQL("DROP TABLE IF EXISTS "+ table_name5);
        onCreate(db);
    }
    public void insertLoginData(String BTH_mail, String pass, String type){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_1,BTH_mail);
        contentValues.put(col_2,pass);
        if (type=="e")
            db.insert(table_name,null,contentValues);
        if (type=="s")
            db.insert(table_name2,null,contentValues);
        if (type=="a")
            db.insert(table_name3,null,contentValues);
    }
    public void insertCourseData(String CourseCode, String CourseName, String BTH_mail){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_1c,CourseCode);
        contentValues.put(col_2c,CourseName);
        contentValues.put(col_1,BTH_mail);
        db.insert(table_name4,null,contentValues);
    }
    public void insertStudentCourseData(int CourseID, String BTH_mail){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_2sc, CourseID);
        contentValues.put(col_1,BTH_mail);
        db.insert(table_name5,null,contentValues);
    }
}