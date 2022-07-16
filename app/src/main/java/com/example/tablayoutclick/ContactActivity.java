package com.example.tablayoutclick;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class ContactActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        drawerLayout=findViewById(R.id.cdraw);
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
    public void ClickContact(View view){
        recreate();
    }
    public void ClickNote(View view){
        MainActivity.redirectActivity(this,NoteActivity.class);
    }
    public void ClickAboutUs(View view){
        MainActivity.redirectActivity(this,InfoActivity.class);
    }
    public void ClickLogout(View view){
        MainActivity.logout(this);
    }
    protected void onPause() { super.onPause(); MainActivity.closeDrawer(drawerLayout); }
}