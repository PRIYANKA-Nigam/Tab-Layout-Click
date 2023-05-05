package com.example.tablayoutclick;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.jitsi.meet.sdk.JitsiMeet;
import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;
import org.jitsi.meet.sdk.JitsiMeetView;

import java.net.MalformedURLException;
import java.net.URL;

public class VideoCallActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
EditText editText; Button button;
URL serverUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_call);
        drawerLayout=findViewById(R.id.mdraw);
        editText=findViewById(R.id.editTextTextPersonName7);
        button=findViewById(R.id.button10);
        try {
            serverUrl=new URL("https://meet.jit.si/");
            JitsiMeetConferenceOptions defaultOptions
                    = new JitsiMeetConferenceOptions.Builder()
                    .setServerURL(serverUrl)
                    .build();
            JitsiMeet.setDefaultConferenceOptions(defaultOptions);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        JitsiMeetConferenceOptions options
                = new JitsiMeetConferenceOptions.Builder()
                .setRoom(editText.getText().toString())
                .setAudioMuted(false)
                .setVideoMuted(false)
                .setAudioOnly(false)
                .build();
        JitsiMeetActivity.launch(VideoCallActivity.this, options);
    }
});
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
    public void ClickFacebook(View view){MainActivity.redirectActivity2(this,AppLinkActivity.class,"f");}
    public void ClickWhatsapp(View view){MainActivity.redirectActivity(this,WhatsappActivity.class);}
    public void ClickInsta(View view){MainActivity.redirectActivity2(this,AppLinkActivity.class,"i");}
    public void ClickLinkedIn(View view){MainActivity.redirectActivity2(this,AppLinkActivity.class,"l");}
    public void ClickTwitter(View view){MainActivity.redirectActivity2(this,AppLinkActivity.class,"t");}
    public void ClickMeet(View view){recreate();}

    protected void onPause() { super.onPause(); MainActivity.closeDrawer(drawerLayout); }
}