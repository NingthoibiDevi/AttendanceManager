package com.example.project1;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {
    EditText wel,wel1;
    ImageView img1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        wel = findViewById(R.id.wel);
        img1 = findViewById(R.id.img1);
        wel1 = findViewById(R.id.wel1);
        nextActivity();
    }
    public void nextActivity(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(Splash.this, Login.class);
                Splash.this.startActivity(i);
                Splash.this.finish();
            }
        },3000);
        //Splash.this.finish();
    }
}
