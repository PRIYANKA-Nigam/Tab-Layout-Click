package com.example.tablayoutclick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.scwang.wave.MultiWaveHeader;

public class EmailActivity extends AppCompatActivity {
    EditText e1,e2,e3;
    Button b;
    MultiWaveHeader w1,w2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        b=(Button)findViewById(R.id.button2);
        e1=(EditText) findViewById(R.id.editTextTextEmailAddress);
        e2=(EditText) findViewById(R.id.editTextTextPersonName3);
        e3=(EditText) findViewById(R.id.editTextTextPersonName4);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EmailActivity.this,"Message Ready to send",Toast.LENGTH_SHORT).show();
                sendMail();
            }
        });
        w1=findViewById(R.id.wave);
        w2=findViewById(R.id.wave2);
        w1.setVelocity(1);
        w1.setProgress(1);
        w1.isRunning();
        w1.setGradientAngle(45);
        w1.setWaveHeight(40);
        w1.setStartColor(Color.RED);
        w1.setCloseColor(Color.CYAN);
        w2.setVelocity(1);
        w2.setProgress(1);
        w2.isRunning();
        w2.setGradientAngle(45);
        w2.setWaveHeight(40);
        w2.setStartColor(Color.MAGENTA);
        w2.setCloseColor(Color.YELLOW);

    }
    private void sendMail(){
        String recipientList=e1.getText().toString();
        String[] recipients=recipientList.split(",");
        String subject=e2.getText().toString();
        String mssg=e3.getText().toString();
        Intent i=new Intent(Intent.ACTION_SEND);
        i.putExtra(Intent.EXTRA_EMAIL,recipients);
        i.putExtra(Intent.EXTRA_SUBJECT,subject);
        i.putExtra(Intent.EXTRA_TEXT,mssg);
        i.setType("message/rfc822");
        startActivity(Intent.createChooser(i,"choose an email client"));
    }
}