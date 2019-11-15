package com.example.project1;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class View_Attd extends AppCompatActivity {
    Sql_Student sql2=new Sql_Student(this);
    EditText e1,textView5,textView6,start,end;
    TextView text,total;
    Button viewatt,sub;
    int total_days=0;
    int present;
    ImageButton imageButton2;
    private final String CHANNEL_ID="personal_notifications";
    private final int NOTIFICATION_ID=001;

    // CalendarView cal1,cal2;
    RadioButton selectedRadioButton,ab,pre;
    ListView list_stu;
    RadioGroup rg;
    String date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__attd);
        e1=findViewById(R.id.edit1);
        textView5=findViewById(R.id.textView5);
        textView6=findViewById(R.id.textView6);
        viewatt=findViewById(R.id.viewatt);
        imageButton2=findViewById(R.id.imageButton2);
        sql2 =  new Sql_Student(this);
        rg=findViewById(R.id.rg);
        ab=findViewById(R.id.ab);
        pre=findViewById(R.id.pre);
        text=findViewById(R.id.text);
        list_stu=findViewById(R.id.list_stu);
        total=findViewById(R.id.total);
        viewatt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String s1=textView5.getText().toString();
                String s2=textView6.getText().toString();
                Boolean checkstu_id =sql2.id_course(s1,s2);

                if(checkstu_id)
                {
                   ArrayList<String> l= sql2.get_attend(textView5.getText().toString());
                    ArrayAdapter<String> arrayAdapter=new ArrayAdapter
                            (View_Attd.this,android.R.layout.simple_list_item_1,l);
                    list_stu.setAdapter(arrayAdapter);

                    total.setText("Total no of working days"+ list_stu.getAdapter().getCount());
                   /* Intent intent=getIntent();
                    int s=intent.getIntExtra("message",0);
                    total.setText(""+s);*/

                }

                else {
                    Toast.makeText(View_Attd.this,"Wrong User",Toast.LENGTH_SHORT).show();
                }

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
            Intent i1=new Intent(View_Attd.this, Profile.class);
            startActivity(i1);
        }

        return super.onOptionsItemSelected(item);
    }
    public void displayNotification(View v)
    {   createNotificationChannel();
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,CHANNEL_ID);
        builder.setSmallIcon(R.drawable.ic_sms_notification);
        builder.setContentTitle("Simple Notification");
        builder.setContentText("Download Complete");
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManagerCompat=NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(NOTIFICATION_ID,builder.build());
    }
    private void createNotificationChannel()
    {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {
            CharSequence name="Personal Notifications";
            String description="Include all";
            int importance= NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel notificationChannel=new NotificationChannel(CHANNEL_ID,name,importance);
            notificationChannel.setDescription(description);
            NotificationManager notificationManager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
}
