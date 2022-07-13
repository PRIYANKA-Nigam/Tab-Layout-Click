package com.example.tablayoutclick;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class PhoneActivity extends AppCompatActivity {
    private static final int REQUEST_CALL=1;
    private EditText e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        e=(EditText)findViewById(R.id.editTextTextPersonName);
        ImageView imageView=findViewById(R.id.img);
        Intent intent=getIntent();
        String s=intent.getStringExtra("call");
        e.setText(s);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhoneCall();
            }
        });
    }

    private void makePhoneCall() {
        String num=e.getText().toString();
        if(num.trim().length()>0){
            if(ContextCompat.checkSelfPermission(PhoneActivity.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(PhoneActivity.this,new String[] {Manifest.permission.CALL_PHONE},REQUEST_CALL); }
            else { String dial="tel:"+ num;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial))); } }
        else { Toast.makeText(PhoneActivity.this,"Enter Phone Number",Toast.LENGTH_SHORT).show(); }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall();
            } else {
                Toast.makeText(this, "PERMISSION DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }
}