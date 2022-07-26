package com.example.tablayoutclick;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

public class TwitterActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter);
        drawerLayout = findViewById(R.id.twdraw);
    }

    public void twitter(View view) {
        String appLink = "twitter://user?screen_name=AndroidCoding_";
        String spackage = "com.example.tablayoutclick";
        String webLink = "https://twitter.com/AndroidCoding_";
        openLink(appLink, spackage, webLink);
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
    public void ClickContact(View view){ MainActivity.redirectActivity(this,ContactActivity.class); }
    public void ClickNote(View view){
        MainActivity.redirectActivity(this,NoteActivity.class);
    }
    public void ClickAboutUs(View view){
        MainActivity.redirectActivity(this,InfoActivity.class);
    }
    public void ClickLogout(View view){
        MainActivity.logout(this);
    }
    public void ClickFacebook(View view){MainActivity.redirectActivity(this,FaceBookActivity.class);}
    public void ClickWhatsapp(View view){MainActivity.redirectActivity(this,WhatsappActivity.class);}
    public void ClickInsta(View view){MainActivity.redirectActivity(this,InstaActivity.class);}
    public void ClickLinkedIn(View view){MainActivity.redirectActivity(this,LinkedInActivity.class);}
    public void ClickMeet(View view){MainActivity.redirectActivity(this,VideoCallActivity.class);}
    public void ClickTwitter(View view){recreate();}
    protected void onPause() { super.onPause(); MainActivity.closeDrawer(drawerLayout); }

}