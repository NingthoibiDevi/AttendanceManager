package com.example.project1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Teacher extends AppCompatActivity {
    Sqlite_Reg sql4=new Sqlite_Reg(this);

    EditText tch_nm,tch_id,tch_cr;
    Button add_tch;

    String teach_id;
    String teach_cr;
    String teach_nm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
        tch_nm=findViewById(R.id.tch_nm);
        tch_cr=findViewById(R.id.tch_cr);
        tch_id=findViewById(R.id.tch_id);
        add_tch=findViewById(R.id.add_tch);
        final SharedPreferences preferences=getSharedPreferences("pref",MODE_PRIVATE);



        add_tch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=preferences.edit();
                String name=tch_nm.getText().toString();
                editor.putString("n",name);
                String id=tch_id.getText().toString();
                editor.putString("i",id);
                String cr=tch_cr.getText().toString();
                editor.putString("c",cr);
                editor.commit();
                Intent intent=new Intent(Teacher.this, Profile.class);
                startActivity(intent);
               /* Toast.makeText(Teacher.this,"Details Added",Toast.LENGTH_SHORT);
                pass();
                Log.d("teacher activity", "onClick: data recived");*/
            }



    });
    }

/*
    public void pass (){

        String teach_id = tch_id.getText().toString();
        String teach_cr = tch_cr.getText().toString();
        String teach_nm = tch_nm.getText().toString();


        Intent i = new Intent(this,Profile.class);
        i.putExtra("teacher id",teach_id);
        i.putExtra("teacher cr",teach_cr);
        i.putExtra("teacher name", teach_nm);
        startActivity(i);
    }*/
}
