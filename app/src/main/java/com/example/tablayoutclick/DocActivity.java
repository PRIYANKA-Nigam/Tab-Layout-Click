package com.example.tablayoutclick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.scwang.wave.MultiWaveHeader;

public class DocActivity extends AppCompatActivity {
Button b1,b2,b3,b4,b5,b6; MultiWaveHeader w1,w2;
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
}