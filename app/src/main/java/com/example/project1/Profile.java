package com.example.project1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class Profile extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener {
    TextView d1,d2,d3,s1,s2,s3,editText5,nm1,eid;
    ImageView pro;
    Sqlite_Reg sql5 =new Sqlite_Reg(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        d1=findViewById(R.id.d1);
        d2=findViewById(R.id.d2);
        d3=findViewById(R.id.d3);
        s1=findViewById(R.id.s1);
        s2=findViewById(R.id.s2);
        s3=findViewById(R.id.s3);
        nm1=findViewById(R.id.nm1);
        eid=findViewById(R.id.eid);
        editText5=findViewById(R.id.editText5);
        pro=findViewById(R.id.pro);

        SharedPreferences preferences=getSharedPreferences("pref",MODE_PRIVATE);
        String t1=preferences.getString("n","");
        s1.setText(t1);
        String t2=preferences.getString("i","");
        s2.setText(t2);
        String t3=preferences.getString("c","");
        s3.setText(t3);

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
            Intent i1=new Intent(Profile.this, Profile.class);
            startActivity(i1);
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.Profile) {
            Intent intent=new Intent(Profile.this,Teacher.class);
            startActivity(intent);
        } else if (id == R.id.Take) {
            Intent intent1=new Intent(Profile.this,Take_Att.class);
            startActivity(intent1);
        } else if (id == R.id.Give) {
            Intent intent2=new Intent(Profile.this,View_Attd.class);
            startActivity(intent2);

        } else if (id == R.id.Logout) {
            Intent intent3;
            intent3 = new Intent(Profile.this, Login.class);
            startActivity(intent3);
        } else if(id==R.id.Add){
            Intent intent4=new Intent(Profile.this,Add_Student.class);
            startActivity(intent4);
        }
        DrawerLayout drawer = findViewById(R.id.drawer);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
