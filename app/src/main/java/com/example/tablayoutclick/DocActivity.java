package com.example.tablayoutclick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DocActivity extends AppCompatActivity {
Button b1,b2,b3,b4,b5,b6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc);
        b1=findViewById(R.id.button4);
        b2=findViewById(R.id.button5);
        b3=findViewById(R.id.button6);
        b4=findViewById(R.id.button7);
        b5=findViewById(R.id.button8);
        b6=findViewById(R.id.button9);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(DocActivity.this,ExternalActivity.class));
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DocActivity.this,InternalActivity.class));
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DocActivity.this,ExcelActivity.class));
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DocActivity.this,TextRecogitionMainActivity.class));

            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DocActivity.this,ImageShareActivity.class));

            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DocActivity.this,AudioRecorderActivity.class));

            }
        });
    }
}