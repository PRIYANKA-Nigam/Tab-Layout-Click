package com.example.tablayoutclick;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.app.AlertDialog;
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
        AlertDialog.Builder builder=new AlertDialog.Builder(contactActivity);builder.setTitle("Logout");
        builder.setMessage("Are You Sure You Want to Logout ?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)  @Override
            public void onClick(DialogInterface dialog, int which) {
               contactActivity.finishAffinity(); System.exit(0); }});
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss(); }});builder.show(); }
    public static void logout(final NoteActivity noteActivity) {
        AlertDialog.Builder builder=new AlertDialog.Builder(noteActivity);builder.setTitle("Logout");
        builder.setMessage("Are You Sure You Want to Logout ?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)  @Override
            public void onClick(DialogInterface dialog, int which) {
                noteActivity.finishAffinity(); System.exit(0); }});
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() { @Override
        public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss(); }});builder.show(); }
    public static void logout(final InfoActivity infoActivity) {
        AlertDialog.Builder builder=new AlertDialog.Builder(infoActivity);builder.setTitle("Logout");
        builder.setMessage("Are You Sure You Want to Logout ?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)  @Override
            public void onClick(DialogInterface dialog, int which) {
                infoActivity.finishAffinity(); System.exit(0); }});
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() { @Override
        public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss(); }});builder.show(); }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout=(TabLayout)findViewById(R.id.tab);
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
    public static void logout(final MainActivity mainActivity) { AlertDialog.Builder builder=new AlertDialog.Builder(mainActivity);
        builder.setTitle("Logout");builder.setMessage("Are You Sure You Want to Logout ?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)  @Override
            public void onClick(DialogInterface dialog, int which) {
                mainActivity.finishAffinity();System.exit(0); }});
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() { @Override
        public void onClick(DialogInterface dialog, int which) { dialog.dismiss(); }}); builder.show(); }
    public static void redirectActivity(Activity activity, Class aclass) { Intent intent=new Intent(activity,aclass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); activity.startActivity(intent); } @Override
    protected void onPause() { super.onPause(); closeDrawer(drawerLayout); }
}