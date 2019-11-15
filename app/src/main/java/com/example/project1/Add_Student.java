package com.example.project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Add_Student extends AppCompatActivity {
    TextView stu;
    EditText stu_id,stu_cr;
    Button add_stu,button4,del_stu;
    Sql_Student sql2=new Sql_Student(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__student);
        stu=findViewById(R.id.stu);
        stu_id=findViewById(R.id.stu_id);
        stu_cr=findViewById(R.id.stu_cr);
        add_stu=findViewById(R.id.add_stu);
        button4=findViewById(R.id.button4);
        del_stu=findViewById(R.id.del_stu);

        add_stu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long isInserted= sql2.add_stu(stu_id.getText().toString(),stu_cr.getText().toString());
                if(isInserted>0)
                    Toast.makeText(Add_Student.this,"Student Added",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Add_Student.this,"Student Not Added",Toast.LENGTH_SHORT).show();
                }
            });
        del_stu.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String s1=stu_id.getText().toString();
                String s2=stu_cr.getText().toString();
                Boolean checkstu_id =sql2.id_course(s1,s2);

                if(checkstu_id)
                {
                 sql2.deleteuser(s1,s2);
                 Toast.makeText(Add_Student.this,"Student deleted",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Add_Student.this,"Student not deleted",Toast.LENGTH_SHORT).show();
                }
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(Add_Student.this,Show_Student.class);
                startActivity(intent1);
                finish();
            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_content, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.home) {
            Intent i1=new Intent(Add_Student.this, Profile.class);
            startActivity(i1);
        }

        return super.onOptionsItemSelected(item);
    }
}
