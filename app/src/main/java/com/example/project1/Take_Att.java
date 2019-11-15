package com.example.project1;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.zip.Inflater;

public class Take_Att extends AppCompatActivity {
    Sql_Student sql1=new Sql_Student(this);
    EditText textView2,textView3,textView4;
    Calendar calendar;
    TextView date1;
    Button date,update;
    RadioGroup rg;
    RadioButton r,pre;
    int day,month,year,total=0;
    Button button3,button4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take__att);
        textView2=findViewById(R.id.textView2);
        textView3=findViewById(R.id.textView3);
        textView4=findViewById(R.id.textView4);
        date=findViewById(R.id.date);
        date1=findViewById(R.id.date1);
        rg=findViewById(R.id.rg);
        update=findViewById(R.id.update);
        calendar=Calendar.getInstance();
        day=calendar.get(Calendar.DAY_OF_MONTH);
        month=calendar.get(Calendar.MONTH);
        year=calendar.get(Calendar.YEAR);
        month=month+1;
        date1.setText(day+"/"+month+"/"+year);
        Toolbar toolbar = findViewById(R.id.toolbar);



        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog=new DatePickerDialog(Take_Att.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month=month+1;
                        date1.setText(dayOfMonth+"/"+month+"/"+year);
                    }
                },year,month,day);
                dialog.show();
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean checkstu_id =sql1.id_course(textView2.getText().toString(),textView3.getText().toString());

                if(checkstu_id)
                { r=findViewById(rg.getCheckedRadioButtonId());
                    long l=sql1.add_user(textView2.getText().toString(),textView3.getText().toString(),date1.getText().toString(),r.getText().toString());
                    String s=r.getText().toString();
                    Toast.makeText(Take_Att.this,"Attendance Updated",Toast.LENGTH_SHORT).show();
                    Toast.makeText(Take_Att.this,""+s,Toast.LENGTH_SHORT).show();
                   /* if(pre.isChecked())
                    {   total++;
                       // String s=r.getText().toString();
                        Toast.makeText(Take_Att.this,""+total,Toast.LENGTH_SHORT).show();

                       /* Intent intent = new Intent(Take_Att.this,View_Attd.class);
                        intent.putExtra("message",total);
                        startActivity(intent);*/

                }
                else {
                    Toast.makeText(Take_Att.this,"Wrong User",Toast.LENGTH_SHORT).show();
                }

            }
        });

    /* public void pass(){

            String t1 = total.getText().toString();



            Intent i = new Intent(this,Profile.class);
            i.putExtra("teacher id",teach_id);
            i.putExtra("teacher cr",teach_cr);
            i.putExtra("teacher name", teach_nm);
            startActivity(i);

        }*/
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_content, menu);
        return true;
    }
}
