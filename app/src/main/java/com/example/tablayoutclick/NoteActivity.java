package com.example.tablayoutclick;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class NoteActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        drawerLayout=findViewById(R.id.ndraw);

    }
    public void ClickMenu(View view){
        MainActivity.openDrawer(drawerLayout);
    }
    public void ClickLogo(View view){
        MainActivity.closeDrawer(drawerLayout);
    }
    public void ClickHome(View view){
        MainActivity.redirectActivity(this,MainActivity.class);
    }
    public void ClickContact(View view){MainActivity.redirectActivity(this,ContactActivity.class); }
    public void ClickNote(View view){ recreate(); }
    public void ClickAboutUs(View view){
        MainActivity.redirectActivity(this,InfoActivity.class);
    }
    public void ClickLogout(View view){
        MainActivity.logout(this);
    }
    protected void onPause() { super.onPause(); MainActivity.closeDrawer(drawerLayout); }
}