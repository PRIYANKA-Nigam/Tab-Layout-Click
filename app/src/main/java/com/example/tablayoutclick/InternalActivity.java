package com.example.tablayoutclick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InternalActivity extends AppCompatActivity {
    Button b1,b2; EditText e1,e2; TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal);
        textView=findViewById(R.id.textView5);
        e1=(EditText)findViewById(R.id.editTextTextPersonName2); e2=(EditText)findViewById(R.id.editTextTextPersonName3);
        b1=(Button)findViewById(R.id.button8); b2=(Button)findViewById(R.id.button9);
        b1.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View v) {
            String file=e1.getText().toString(); String data=e2.getText().toString();
            FileOutputStream fileOutputStream;
            try { fileOutputStream=openFileOutput(file, Context.MODE_PRIVATE); fileOutputStream.write(data.getBytes());
                fileOutputStream.close();
                Toast.makeText(getApplicationContext(),file + " Your Data is Saved",Toast.LENGTH_LONG).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace(); } }});
        b2.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View v) { String file=e1.getText().toString(); StringBuffer stringBuffer=new StringBuffer();
            try { BufferedReader buffer=new BufferedReader( new InputStreamReader(openFileInput(file)));
                String inputString; while ((inputString=buffer.readLine())!=null){
                    stringBuffer.append(inputString + "\n"); }
            } catch (IOException e) {
                e.printStackTrace(); }
            Toast.makeText(getApplicationContext(),stringBuffer.toString(),Toast.LENGTH_LONG).show();
            String fileContents= "Saved File Content: "+"\n" +stringBuffer.toString(); textView.setText(fileContents);}});
    }
}