package com.example.theretrocourse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseOperation extends SQLiteOpenHelper {
    public static final String database_name ="retro.db";

    //tabeller
    public static final String teacher = "teacher_table"; //table_name
    public static final String student ="student_table";//table_name2
    public static final String admin ="admin_table"; //table_name3
    public static final String course ="course_table";//table_name4
    public static final String result ="result_table"; //table_name_result
    public static final String courseEval ="courseeval_table"; //table_name_keyword
    public static final String finished_courses_table ="finished_table";
    public static final String studentcourse ="StudentCouse_table";

    //kolumner för tabellerna
    public static final String username ="BTH_mail"; //col_1
    public static final String pass ="Password";//col_2
    public static final String coursecode ="CourseCode";//col_1c
    public static final String coursename ="CourseName";//col_2c
    public static final String keyword ="Keyword";//col_2k
    public static final String courseid ="CourseID";//col_2sc
    public static final String AdminName ="Name";

    public static final String col_b1 ="b1";
    public static final String col_b2 ="b2";
    public static final String col_b3 ="b3";
    public static final String col_b4 ="b4";
    public static final String col_b5 ="b5";
    public static final String col_b6 ="b7";
    public static final String col_b7 ="b7";

    public static final String col_m ="comment";

    public DatabaseOperation(Context context){
        super(context, database_name, null, 1);
    }

    public void onCreate(SQLiteDatabase db){
        /*db.execSQL("CREATE TABLE "+ table_name4 +"(CourseCode VARCHAR PRIMARY KEY,CourseName TEXT, " +
                "FOREIGN KEY (BTH_mail) REFERENCES "+ table_name+ "(BTH_mail))");*/
        db.execSQL("CREATE TABLE "+ teacher+"(BTH_mail VARCHAR PRIMARY KEY,Password TEXT)");
        db.execSQL("CREATE TABLE "+ student+"(BTH_mail VARCHAR PRIMARY KEY,Password TEXT)");
        db.execSQL("CREATE TABLE "+ admin+"(BTH_mail VARCHAR PRIMARY KEY,Name TEXT,Password TEXT)");
        db.execSQL("CREATE TABLE "+ course +"(CourseCode VARCHAR PRIMARY KEY,CourseName TEXT,BTH_mail)");
        db.execSQL("CREATE TABLE "+ courseEval+"(CourseCode VARCHAR PRIMARY KEY,Keyword TEXT,"+username+" TEXT,FOREIGN KEY ("+username+") REFERENCES "+teacher+" ("+username+"))");
        db.execSQL("CREATE TABLE "+ result+"(CourseID TEXT ,b1 TINYINT(1)," + "b2 TINYINT(1),"+"b3 TINYINT(1),"+"b4 TINYINT(1),"+"b5 TINYINT(1),"+"b6 TINYINT(1),"+"b7 TINYINT(1), " + "comment VARCHAR, CourseCode TEXT, FOREIGN KEY ("+coursecode+") REFERENCES "+courseEval+" ("+coursecode+"),FOREIGN KEY ("+courseid+") REFERENCES "+studentcourse+" ("+courseid+") )");
        db.execSQL("CREATE TABLE "+ finished_courses_table+"("+coursecode+" VARCHAR PRIMARY KEY, "+col_m+" TEXT, b1 TINYINT(1)," + "b2 TINYINT(1),"+"b3 TINYINT(1),"+"b4 TINYINT(1),"+"b5 TINYINT(1),"+"b6 TINYINT(1),"+"b7 TINYINT(1))");
        db.execSQL("CREATE TABLE "+studentcourse+" ("+courseid+" VARCHAR PRIMARY KEY, "+coursecode+" TEXT, "+username+" TEXT, FOREIGN KEY ("+coursecode+") REFERENCES "+course+" ("+coursecode+") , FOREIGN KEY ("+username+") REFERENCES "+student+" ("+username+") )");

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS "+ teacher);
        db.execSQL("DROP TABLE IF EXISTS "+ student);
        db.execSQL("DROP TABLE IF EXISTS "+ admin);
        db.execSQL("DROP TABLE IF EXISTS "+ course);
        db.execSQL("DROP TABLE IF EXISTS "+ result);
        db.execSQL("DROP TABLE IF EXISTS "+ courseEval);
        db.execSQL("DROP TABLE IF EXISTS "+ finished_courses_table);
        onCreate(db);
    }

    //find stuff from database
    public Cursor findLoginData(String bth_mail, String pass){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if (MainActivity.type.equals("e"))
            cursor = db.rawQuery("SELECT*FROM "+ teacher,null);
        if (MainActivity.type.equals("s"))
            cursor = db.rawQuery("SELECT*FROM "+ student,null);
        if (MainActivity.type.equals("a"))
            cursor = db.rawQuery("SELECT*FROM "+ admin,null);
        return cursor;
    }

    public Cursor admin(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor;
        cursor = db.rawQuery("SELECT*FROM "+ admin,null);
        return cursor;
    }

    public Cursor findFinishedCourses(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT*FROM "+ finished_courses_table,null);
        return cursor;
    }

    public Cursor findCourses(){
        SQLiteDatabase db = this.getReadableDatabase();
           Cursor cursor = db.rawQuery("SELECT*FROM "+ course,null);
        return cursor;
    }
    public Cursor findCreatedEval(){
        SQLiteDatabase db = this.getReadableDatabase();
        String str = "SELECT ct.CourseCode, ct.BTH_mail FROM course_table INNER JOIN courseeval_table ct on course_table.CourseCode = ct.CourseCode";
        Cursor cursor = db.rawQuery(str,null);
        return cursor;
    }

    public Cursor findKeywords(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ courseEval,null);
        return cursor;
    }

    public Cursor findID(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ studentcourse,null);
        return cursor;
    }

    public Cursor resultTable(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+ result,null);
        return cursor;
    }
    public Cursor resultTableb1(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT b1, coursecode FROM "+ result,null);
        return cursor;
    }
    public Cursor resultTableb2(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT b2, coursecode FROM "+ result,null);
        return cursor;
    }
    public Cursor resultTableb3(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT b3, coursecode FROM "+ result,null);
        return cursor;
    }
    public Cursor resultTableb4(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT b4, coursecode FROM "+ result,null);
        return cursor;
    }
    public Cursor resultTableb5(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT b5, coursecode FROM "+ result,null);
        return cursor;
    }
    public Cursor resultTableb6(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT b6, coursecode FROM "+ result,null);
        return cursor;
    }
    public Cursor resultTableb7(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT b7, coursecode FROM "+ result,null);
        return cursor;
    }


    public Cursor findStudentCourse(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT StudentCouse_table.courseCode, StudentCouse_table.BTH_mail FROM StudentCouse_table INNER JOIN courseeval_table ct on StudentCouse_table.CourseCode = ct.CourseCode",null);
        return cursor;
    }

    //remove stuff
    public void deleteEval(String code){
        SQLiteDatabase db = this.getReadableDatabase();
        db.delete(courseEval,coursecode +" = " + "'"+ code +"'" , null);
    }

    public void deleteAllAnswers(String Coursecode){
        SQLiteDatabase db = this.getReadableDatabase();
        db.delete(result,coursecode +" = " + "'"+ Coursecode +"'" , null);
    }

    public boolean deleteStudentAnswer(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        long res = db.delete(result,courseid +" = " + "'"+ id +"'" , null);

        if(res==-1){
            return false;
        }
        else{
            return true;
        }
    }

    //insert stuff in database because we dont have authority to a real database
    public void insertLoginData(String BTH_mail, String password, String type){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(username,BTH_mail);
        contentValues.put(pass,password);
        if (type=="e")
            db.insert(teacher,null,contentValues);
        if (type=="s")
            db.insert(student,null,contentValues);
        if (type=="a")
            db.insert(admin,null,contentValues);
    }

    public void insertFinishedTable(String user, String comment,String b1,String b2,String b3,String b4,String b5, String b6, String b7){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(username,user);
        contentValues.put(col_m,comment);
        contentValues.put(col_b1,b1);
        contentValues.put(col_b2,b2);
        contentValues.put(col_b3,b3);
        contentValues.put(col_b4,b4);
        contentValues.put(col_b5,b5);
        contentValues.put(col_b6,b6);
        contentValues.put(col_b7,b7);
        db.insert(finished_courses_table,null,contentValues);
    }

    public void insertLoginDataAdmin(String BTH_mail, String password,String name,String type){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(username,BTH_mail);
        contentValues.put(AdminName,name);
        contentValues.put(pass,password);
        db.insert(admin,null,contentValues);
    }

    public void insertFinishedCourses(String CourseID){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(courseid,CourseID);
        db.insert(finished_courses_table,null,contentValues);
    }

    public void insertCourseData(String CourseCode, String CourseName, String BTH_mail){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(coursecode,CourseCode);
        contentValues.put(coursename,CourseName);
        contentValues.put(username,BTH_mail);
        db.insert(course,null,contentValues);
    }

    public void insertSC(String name, String code, String ID){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(username, name);
        content.put(coursecode, code);
        content.put(courseid, ID);
        db.insert(studentcourse, null, content);

    }

    public void insertKeywordsCourseEval(String CourseCode, String Keyword, String name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(coursecode, CourseCode);
        contentValues.put(keyword, Keyword);
        contentValues.put(username, name);
        db.insert(courseEval,null,contentValues);
    }

    public void insertResulteData(String id,String b1,String b2,String b3,String b4,String b5, String b6, String b7, String comment, String code){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(courseid,id);
        contentValues.put(col_b1,b1);
        contentValues.put(col_b2,b2);
        contentValues.put(col_b3,b3);
        contentValues.put(col_b4,b4);
        contentValues.put(col_b5,b5);
        contentValues.put(col_b6,b6);
        contentValues.put(col_b7,b7);
        contentValues.put(col_m,comment);
        contentValues.put(coursecode,code);
        db.insert(result,null,contentValues);
    }
}