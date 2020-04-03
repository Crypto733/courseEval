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

    public static final String col_b1 ="b1";
    public static final String col_b2 ="b2";
    public static final String col_b3 ="b3";
    public static final String col_b4 ="b4";
    public static final String col_b5 ="b5";

    public static final String col_m1 ="comment_1";
    public static final String col_m2 ="comment_2";
    public static final String col_m3 ="comment_3";
    public static final String col_m4 ="comment_4";
    public static final String col_m5 ="comment_5";

    public DatabaseOperation(Context context){
        super(context, database_name, null, 1);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE "+ table_name+"(BTH_mail VARCHAR PRIMARY KEY,Password TEXT)");
        db.execSQL("CREATE TABLE "+ table_name2+"(BTH_mail VARCHAR PRIMARY KEY,Password TEXT)");
        db.execSQL("CREATE TABLE "+ table_name3+"(BTH_mail VARCHAR PRIMARY KEY,Password TEXT)");
        db.execSQL("CREATE TABLE "+ table_name4 +"(CourseCode VARCHAR PRIMARY KEY,CourseName TEXT, " +
                "FOREIGN KEY (BTH_mail) REFERENCES "+ table_name+ "(BTH_mail))");
        db.execSQL("CREATE TABLE "+ table_name5+"(CourseID INT PRIMARY KEY,BTH_mail VARCHAR,b1 TINYINT(1)," +
                "b2 TINYINT(1),b3 TINYINT(1),b4 TINYINT(1),b5 TINYINT(1)," +
                "comment_1 VARCHAR, comment_2 VARCHAR, comment_3 VARCHAR, comment_4 VARCHAR, comment_5 VARCHAR)");
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
    //används inte ännu, får se om denna behövs. Den lagrar course evaluation. Har gjort setters and getters istället
    //i EvaluationResult
    public void insertStudentCourseData(String CourseID, String BTH_mail,String b1,String b2,String b3,String b4,String b5,
     String comment_1,String comment_2,String comment_3,String comment_4,String comment_5){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_2sc, CourseID);
        contentValues.put(col_1,BTH_mail);
        contentValues.put(col_b1,b1);
        contentValues.put(col_b2,b2);
        contentValues.put(col_b3,b3);
        contentValues.put(col_b4,b4);
        contentValues.put(col_b5,b5);
        contentValues.put(col_m1,comment_1);
        contentValues.put(col_m2,comment_2);
        contentValues.put(col_m3,comment_3);
        contentValues.put(col_m4,comment_4);
        contentValues.put(col_m5,comment_5);
        db.insert(table_name5,null,contentValues);
    }
}