package com.example.theretrocourse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class CourseData extends SQLiteOpenHelper {
    public static final String database_name ="course.db";
    public static final String table_name ="course_table";

    public static final String col_1 ="Course_name";
    public static final String col_2 ="Course_code";
    public static final String col_3 ="BTH_mail";

    public CourseData(Context context){
        super(context, database_name, null, 1);

    }

    public void onCreate( SQLiteDatabase db){
        db.execSQL("create table "+ table_name+"(Course_name TEXT,Course_code TEXT,BTH_mail VARCHAR)");
    }

    public void onUpgrade( SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS "+ table_name);
        onCreate(db);
    }

    public boolean insertLoginData(String Course_name, String Course_code, String BTH_mail){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_1,Course_name);
        contentValues.put(col_2,Course_code);
        contentValues.put(col_3,BTH_mail);
        long result =db.insert(table_name,null,contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }

    public Cursor getResultData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+table_name,null);
        return res;
    }

}