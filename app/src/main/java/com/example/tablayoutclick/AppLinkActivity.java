package com.example.tablayoutclick;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class AppLinkActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_link);
        drawerLayout=findViewById(R.id.wdraw);
        String link = getIntent().getStringExtra("link");
        String spackage = "com.example.tablayoutclick";
        String webLink = "";
        openLink(link, spackage, webLink);
    }
    private void openLink(String appLink, String spackage, String webLink) {
        try {
            Uri uri = Uri.parse(appLink);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } catch (ActivityNotFoundException activityNotFoundException) {
            Uri uri = Uri.parse(webLink);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
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
    public void ClickFacebook(View view){MainActivity.redirectActivity2(this,AppLinkActivity.class,"f");}
    public void ClickWhatsapp(View view){MainActivity.redirectActivity(this,WhatsappActivity.class);}
    public void ClickInsta(View view){MainActivity.redirectActivity2(this,AppLinkActivity.class,"i");}
    public void ClickLinkedIn(View view){MainActivity.redirectActivity2(this,AppLinkActivity.class,"l");}
    public void ClickTwitter(View view){MainActivity.redirectActivity2(this,AppLinkActivity.class,"t");}
    public void ClickMeet(View view){MainActivity.redirectActivity(this,VideoCallActivity.class);}
    protected void onPause() { super.onPause(); MainActivity.closeDrawer(drawerLayout); }
}