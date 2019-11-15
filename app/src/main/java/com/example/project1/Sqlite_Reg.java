package com.example.project1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

import java.util.ArrayList;

public class Sqlite_Reg extends SQLiteOpenHelper {
    private String t1Name ="user1";
    private String u1Name ="username";
    private String u1Pass="password";

    private String t2Name="user2";
    private String u2Name="t_name";
    private String u2email="t_email";
    private String u2course="t_course";
    public Sqlite_Reg(Context context)
    {
        super(context,"db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="Create table "+t1Name+"("+u1Name+" text,"+u1Pass+" text )";
        db.execSQL(sql);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public long add_user(String name,String pass){
        SQLiteDatabase db= getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(u1Name,name);
        values.put(u1Pass,pass);

        long l= db.insert(t1Name,"",values);
        return l;
    }
    public long add_user2(String nm, String id, String cr)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues values1=new ContentValues();
        values1.put(u2Name,nm);
        values1.put(u2email,id);
        values1.put(u2course,cr);
        long l=db.insert(t2Name,"",values1);
        return l;
    }
    public boolean passname(String name, String pass){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor=db.rawQuery(" select *from "+t1Name+" where "+u1Name+" "+" =? and "+u1Pass+"=?", new String[]{name,pass});
        return cursor.moveToNext();
    }

  /*  public String getName() {
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor=db.rawQuery("s")
    }
    public String getId(){
        return u2email;
    }
    public String getCourse(){
        return u2course;
    }
    /* public ArrayList<String> getUser(){
        SQLiteDatabase db1= getReadableDatabase();
        Cursor cr = db1.rawQuery("select *from "+t1Name,null);
        ArrayList<String>arrayList=new ArrayList<>();
        while (cr.moveToNext())
        {
            arrayList.add(cr.getString(0)+" "+cr.getString(1));
        }
        return arrayList;
    }*/
}
