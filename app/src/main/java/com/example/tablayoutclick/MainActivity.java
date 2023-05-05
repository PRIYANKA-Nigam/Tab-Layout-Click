package com.example.tablayoutclick;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.PictureInPictureParams;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
private TabLayout tabLayout;
private ViewPager viewPager;
private ViewPagerAdapter viewPagerAdapter;
    DrawerLayout drawerLayout;
    public static void logout(final ContactActivity contactActivity) {
        dialog(contactActivity);
    }

    private static void dialog(Activity activity) {
            AlertDialog.Builder builder=new AlertDialog.Builder(activity);builder.setTitle("Logout");
            builder.setMessage("Are You Sure You Want to Logout ?");
            builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)  @Override
                public void onClick(DialogInterface dialog, int which) {
                  activity.finishAffinity(); System.exit(0); }});
            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss(); }});builder.show();
    }

    public static void logout(final WhatsappActivity whatsappActivity) {
        dialog(whatsappActivity);
    }


    public static void logout(final VideoCallActivity videoCallActivity) {
        dialog(videoCallActivity);
    }

    public static void logout(final NoteActivity noteActivity) {
      dialog(noteActivity);
    }
    public static void logout(final AppLinkActivity infoActivity) {
        dialog(infoActivity);}
    public static void logout(final InfoActivity infoActivity) {
        dialog(infoActivity);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout=findViewById(R.id.tab);
        viewPager=findViewById(R.id.vv);  drawerLayout=(DrawerLayout)findViewById(R.id.hdraw);
        viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.AddFragment(new FragmentChat(),"Chat");
        viewPagerAdapter.AddFragment(new FragmentContact(),"Contact"); //adding Fragments
        viewPagerAdapter.AddFragment(new FragmentFav(),"Favourite");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.call);
        tabLayout.getTabAt(1).setIcon(R.drawable.chat);
        tabLayout.getTabAt(2).setIcon(R.drawable.favorite);
        ActionBar actionBar=getSupportActionBar();   //Remove Shadow from the action bar
        actionBar.setElevation(0);
    }
    @Override
    public void onUserLeaveHint () {
        PictureInPictureParams pictureInPictureParams= new PictureInPictureParams.Builder().build();
        enterPictureInPictureMode(pictureInPictureParams);

    }
    public void ClickMenu(View view){
        openDrawer(drawerLayout);
    }
    public static void openDrawer(DrawerLayout drawerLayout) { drawerLayout.openDrawer(GravityCompat.START); }
    public void ClickLogo(View view){
        closeDrawer(drawerLayout);
    }
    public static void closeDrawer(DrawerLayout drawerLayout) { if (drawerLayout.isDrawerOpen(GravityCompat.START)){
        drawerLayout.closeDrawer(GravityCompat.START); } }
    public void ClickHome(View view){
        recreate();
    }
    public void ClickContact(View view){
        redirectActivity(this,ContactActivity.class);
    }
    public void ClickNote(View view){
        redirectActivity(this,NoteActivity.class);
    }
    public void ClickAboutUs(View view){
        redirectActivity(this,InfoActivity.class);
    }
    public void ClickFacebook(View view){redirectActivity2(this,AppLinkActivity.class,"f");}
    public void ClickWhatsapp(View view){redirectActivity(this,WhatsappActivity.class);}
    public void ClickInsta(View view){redirectActivity2(this,AppLinkActivity.class,"i");}
    public void ClickLinkedIn(View view){redirectActivity2(this,AppLinkActivity.class,"l");}
    public void ClickMeet(View view){redirectActivity(this,VideoCallActivity.class);}
    public void ClickTwitter(View view){redirectActivity2(this,AppLinkActivity.class,"t");}

    public static void logout(final MainActivity mainActivity) {
        dialog(mainActivity);
    }
    public static void redirectActivity2(Activity activity, Class aclass,String s) { Intent intent=new Intent(activity,aclass);
        if(s=="l")
            intent.putExtra("link","https://www.linkedin.com/in/priyanka-nigam-083247172");
        if(s=="i")
            intent.putExtra("link","https://www.instagram.com/nigampriyanka042");
        if(s=="t")
            intent.putExtra("link","https://www.twitter.com/PriyankaN2504");
        if(s=="f")
            intent.putExtra("link","https://www.facebook.com/priyanka.nigam.9256");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); activity.startActivity(intent); }

    public static void redirectActivity(Activity activity, Class aclass) { Intent intent=new Intent(activity,aclass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); activity.startActivity(intent); } @Override
    protected void onPause() { super.onPause(); closeDrawer(drawerLayout); }
}