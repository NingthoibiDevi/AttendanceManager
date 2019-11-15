package com.example.project1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class Sql_Student extends SQLiteOpenHelper {
    private String tName="user";
    private String t2name="date_table";
    private String u_stu="student_name1";
    private String u_roll="RollNo1";
    private String u_stu1="student_name";
    private String u_roll1="RollNo";
    private String u_date="date";
    private String u_status="status";
    //private String tab3=" tab";
    //private String sql=;
    //private String sql2=;
    //private String sql3="Create table "+tab3+" as Select *from "+t2name+" , "+ tName+" where "+t2name+"."+u_stu+"="+tName+"."+u_stu+" and "+t2name+"."+u_roll+"="+tName+"."+u_roll;

    public Sql_Student(Context context)
    {
        super(context,"db1",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db1) {

        db1.execSQL("Create table "+tName+"("+u_stu+" text,"+u_roll+" text)");
        db1.execSQL("Create table "+t2name+"("+u_stu1+" text,"+u_roll1+" text,"+u_date+" text,"+u_status+" text)");
        //db1.execSQL(sql3);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public long add_stu(String stu, String roll){
        SQLiteDatabase db1=getWritableDatabase();
        ContentValues values1=new ContentValues();
        values1.put(u_stu,stu);
        values1.put(u_roll,roll);
        return db1.insert(tName,"",values1);
    }
    public long add_user(String ob, String pr,String date,String status){
        SQLiteDatabase db1=getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(u_stu1,ob);
        values.put(u_roll1,pr);
        values.put(u_date,date);
        values.put(u_status,status);
        long l= db1.insert(t2name,"",values);
        return l;

    }
    public ArrayList<String> getUser(){
        SQLiteDatabase db1= getReadableDatabase();
        ArrayList<String>arrayList=new ArrayList<>();
        Cursor cr = db1.rawQuery("select *from "+tName,null);
        while (cr.moveToNext())
        {
            arrayList.add(cr.getString(0)+" "+cr.getString(1));
        }
        return arrayList;
    }
    public boolean id_course(String id, String course){
        SQLiteDatabase db1 = getReadableDatabase();
        Cursor cursor=db1.rawQuery(" select *from "+tName+" where "+u_stu+"=? and "+u_roll+"=?", new String[]{id,course});
        return cursor.moveToNext();
    }
    public ArrayList<String> get_attend(String stu_id){
        SQLiteDatabase db1=getReadableDatabase();
        Cursor cur=db1.rawQuery(" Select *from "+t2name+" where "+u_stu1+"=?",new String[]{stu_id} );
        ArrayList<String> arrayList=new ArrayList<>();
        while (cur.moveToNext()){
            arrayList.add(cur.getString(2)+"   "+cur.getString(3));
        }
        return  arrayList;
    }
    public void deleteuser(String s,String r)
    {
        SQLiteDatabase db1=getReadableDatabase();
        db1.execSQL("Delete from "+tName+" where "+u_stu+"=? and "+u_roll+"=?",new String[]{s,r});
        db1.close();

    }
    //public boolean check_stu(String Stu_id){
    //  SQLiteDatabase db1=getWritableDatabase();
    //Cursor cr=db1.rawQuery("select *from "+tName+" where "+u_stu+"=?",new String[]{Stu_id});
    //return cr.moveToNext();
    //}
}
