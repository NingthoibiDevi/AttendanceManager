package com.example.project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    Sqlite_Reg sql=new Sqlite_Reg(this);
    EditText title,u_pass,u_name;
    TextView textView;
    Button button;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        title=findViewById(R.id.title);
        u_name=findViewById(R.id.u_name);
        u_pass=findViewById(R.id.u_pass);
        button=findViewById(R.id.button);
        img=findViewById(R.id.img);
        textView=findViewById(R.id.textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Login.this,Register.class);
                startActivity(i);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=u_name.getText().toString();
                String s2=u_pass.getText().toString();
                Boolean checkpassword =sql.passname(s1,s2);

                if(checkpassword)
                {
                    Intent i1=new Intent(Login.this, Profile.class);
                    startActivity(i1);
                }
                else {
                    Toast.makeText(Login.this,"Wrong Password",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
