package com.example.theretrocourse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.reflect.Array;


public class DatabaseOperation extends SQLiteOpenHelper {
    public static final String database_name ="login.db";
    public static final String table_name ="login_table";
    public static final String col_1 ="BTH_mail";
    public static final String col_2 ="Password";

    public DatabaseOperation(Context context){
        super(context, database_name, null, 1);

    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table "+ table_name+"(BTH_mail VARCHAR PRIMARY KEY,Password TEXT)");
    }

    public Cursor findLoginData(String bth_mail, String pass){
        SQLiteDatabase db = this.getReadableDatabase();
       /* Cursor cursor = db.rawQuery("SELECT*FROM "+ table_name+ " WHERE "+col_1+" = "+bth_mail+ " AND "+ col_2+" = "+pass,
                null);*/
        Cursor cursor = db.rawQuery("SELECT*FROM "+ table_name,null);
        return cursor;
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS "+ table_name);
        onCreate(db);
    }
    public boolean insertLoginData(String BTH_mail, String pass){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_1,BTH_mail);
        contentValues.put(col_2,pass);
        long result =db.insert(table_name,null,contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }
}
