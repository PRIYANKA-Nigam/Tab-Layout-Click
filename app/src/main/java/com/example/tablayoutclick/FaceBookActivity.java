package com.example.tablayoutclick;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

public class FaceBookActivity extends AppCompatActivity {
DrawerLayout drawerLayout; TextView textView;
ImageView imageView;private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face_book);
        drawerLayout = findViewById(R.id.fdraw);
        textView=findViewById(R.id.textView15);
        imageView=findViewById(R.id.imageView9);
        button=findViewById(R.id.login_button);
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String appLink ="https://www.facebook.com/";
        String spackage = "com.example.tablayoutclick";
        String webLink ="https://www.facebook.com/1225173348249467";
        openLink(appLink,spackage,webLink);

    }
});

    }

    private void openLink(String appLink, String spackage, String webLink) {
        try{
            Uri uri = Uri.parse(appLink);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }catch (ActivityNotFoundException activityNotFoundException){
            Uri uri =Uri.parse(webLink);
            Intent intent =new Intent(Intent.ACTION_VIEW);
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
    public void ClickFacebook(View view){recreate();}
    public void ClickWhatsapp(View view){MainActivity.redirectActivity(this,WhatsappActivity.class);}
    protected void onPause() { super.onPause(); MainActivity.closeDrawer(drawerLayout); }
}