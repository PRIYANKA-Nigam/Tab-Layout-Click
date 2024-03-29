package com.example.tablayoutclick;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class InfoActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        drawerLayout=findViewById(R.id.idraw);
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
    public void ClickNote(View view){ MainActivity.redirectActivity(this,NoteActivity.class); }
    public void ClickAboutUs(View view){ recreate(); }
    public void ClickLogout(View view){
        MainActivity.logout(this);
    }
    public void ClickFacebook(View view){MainActivity.redirectActivity2(this,AppLinkActivity.class,"f");}
    public void ClickWhatsapp(View view){MainActivity.redirectActivity(this,WhatsappActivity.class);}
    public void ClickInsta(View view){MainActivity.redirectActivity2(this,AppLinkActivity.class,"i");}
    public void ClickLinkedIn(View view){MainActivity.redirectActivity2(this,AppLinkActivity.class,"l");}
    public void ClickTwitter(View view){MainActivity.redirectActivity2(this,AppLinkActivity.class,"t");}
    public void ClickMeet(View view){MainActivity.redirectActivity(this,VideoCallActivity.class);}
    protected void onPause() { super.onPause(); MainActivity.closeDrawer(drawerLayout); }
}