package com.example.theretrocourse;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseOperation extends SQLiteOpenHelper {
    public static final String database_name ="login.db";
    public static final String table_name ="login_table";
    public static final String col_1 ="BTH_mail";
    public static final String col_2 ="Password";
    //man kan också lägga till ID autoincrement som håller koll på registrationerna

    public DatabaseOperation(Context context){
        super(context, database_name, null, 1);

    }

    public void onCreate( SQLiteDatabase db){
        db.execSQL("create table "+ table_name+"(BTH_mail VARCHAR PRIMARY KEY,Password TEXT)");
    }

    public void onUpgrade( SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS "+ table_name);
        onCreate(db);
    }
    public boolean insertLoginData(String BTHmail, String name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_1,BTHmail);
        contentValues.put(col_2,name);
        long result =db.insert(table_name,null,contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }
}
