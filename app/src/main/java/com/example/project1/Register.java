package com.example.project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    Sqlite_Reg sql1=new Sqlite_Reg(this);
    EditText editText,editText2;
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        editText=findViewById(R.id.editText);
        editText2=findViewById(R.id.editText2);
        button2=findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=editText.getText().toString();
                String s2=editText2.getText().toString();
                if(s1.equals("")||s2.equals(""))
                {
                    Toast.makeText(Register.this,"Empty fields.Enter the name/password.",Toast.LENGTH_SHORT).show();
                }
                else {
                    long l=sql1.add_user(s1,s2);
                    if (l>0){
                        Toast.makeText(Register.this,"User added",Toast.LENGTH_SHORT).show();
                    }
                    Intent intent = new Intent(Register.this, Login.class);
                    startActivity(intent);
                }
            }
        });

    }

}

