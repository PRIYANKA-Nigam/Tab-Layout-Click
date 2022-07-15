package com.example.tablayoutclick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class SpeechActivity extends AppCompatActivity {
    EditText e;
    Button b1,b2;
    TextView textView;
    TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech);
        e=findViewById(R.id.et);
        Intent intent=getIntent();
        String s=intent.getStringExtra("sms");
        e.setText(s);
        b1=findViewById(R.id.bt);
        b2=findViewById(R.id.bt2);
        textView=(TextView)findViewById(R.id.textView);
        textToSpeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override public void onInit(int status) {
                if (status==TextToSpeech.SUCCESS){ int lang=textToSpeech.setLanguage(Locale.ENGLISH); }
            }});
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View v) { String s=e.getText().toString();
            int speech =textToSpeech.speak(s,TextToSpeech.QUEUE_FLUSH,null); }});
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View v) { e.setText(" ");
            }});
    }

}