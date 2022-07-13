package com.example.tablayoutclick;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class CallActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_icon, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) { int id = item.getItemId();
        switch (id) {
//            case R.id.home:
//                Intent intent1 = new Intent(CallActivity.this, MainActivity3.class);
//                startActivity(intent1);
//                break;
//            case R.id.meaning:
//                Intent intent2 = new Intent(Novel2Activity.this, Meaning3.class);
//                startActivity(intent2);
//                break;
//            case R.id.pronounciation:
//                Intent intent3 = new Intent(Novel2Activity.this, Pronounciation3.class);
//                startActivity(intent3);
//                break;
//            case R.id.note:
//                Intent intent4 = new Intent(Novel2Activity.this, Note3.class);
//                startActivity(intent4);
//                break;
//            case R.id.globe:
//                Intent intent5 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
//                startActivity(intent5);
//                break;
        }
        return super.onOptionsItemSelected(item); }
}