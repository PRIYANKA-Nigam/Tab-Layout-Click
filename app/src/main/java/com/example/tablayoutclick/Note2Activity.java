package com.example.tablayoutclick;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashSet;

public class Note2Activity extends AppCompatActivity {
    Button b1;
    EditText editText;int noteId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note2);
        editText=(EditText)findViewById(R.id.editTextTextMultiLine);
        b1=(Button)findViewById(R.id.c);
        Intent intent=getIntent();
        noteId =intent.getIntExtra("id",-1);
        if (noteId!=-1){
            editText.setText(NoteActivity.notes.get(noteId));
        }else {
          NoteActivity.notes.add("");noteId=NoteActivity.notes.size()-1;
           NoteActivity.arrayAdapter.notifyDataSetChanged();
        }
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ClipboardManager clipboardManager=(ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clip=ClipData.newPlainText("text",s);
                        clipboardManager.setPrimaryClip(clip);
                        Toast.makeText(Note2Activity.this,"Copied to Clipboard",Toast.LENGTH_SHORT).show();

                    }
                });

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
               NoteActivity.notes.set(noteId,String.valueOf(s));
              NoteActivity.arrayAdapter.notifyDataSetChanged();
                SharedPreferences sh=getApplicationContext().getSharedPreferences("com.example.noteapp", Context.MODE_PRIVATE);
                HashSet<String> set=new HashSet<>(NoteActivity.notes);
                sh.edit().putStringSet("notes",set).apply(); } @Override
            public void afterTextChanged(Editable s) { }}); }




}
