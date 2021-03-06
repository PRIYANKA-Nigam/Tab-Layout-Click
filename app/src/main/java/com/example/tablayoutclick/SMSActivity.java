package com.example.tablayoutclick;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.scwang.wave.MultiWaveHeader;

public class SMSActivity extends AppCompatActivity {
    EditText e1,e2;
    Button button;  MultiWaveHeader w1,w2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_m_s);
        e1=(EditText)findViewById(R.id.editTextTextPersonName);
        e2=(EditText)findViewById(R.id.editTextTextMultiLine2);
        button=(Button)findViewById(R.id.button);
        Intent intent=getIntent();
        String s=intent.getStringExtra("sms");
        e1.setText(s);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(SMSActivity.this, Manifest.permission.SEND_SMS)== PackageManager.PERMISSION_GRANTED) {
                    sendSMS();
                }else {
                    ActivityCompat.requestPermissions(SMSActivity.this,new String[]{Manifest.permission.SEND_SMS},100);
                }
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
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100 && grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED) {
            sendSMS();
        } else {
            Toast.makeText(this, "PERMISSION DENIED !!!", Toast.LENGTH_SHORT).show();
        }
    }
    private void sendSMS() {
        String s1 = e1.getText().toString().trim();
        String s2 = e2.getText().toString().trim();
        if (!s1.equals("") && !s2.equals("")) {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(s1, null, s2, null, null);
            Toast.makeText(this, "Message Sent Successfully", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Enter Value First ....", Toast.LENGTH_LONG).show();

        }
    }
}