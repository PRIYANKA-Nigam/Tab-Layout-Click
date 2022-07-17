package com.example.tablayoutclick;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ContactActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        drawerLayout=findViewById(R.id.cdraw);
        fetchContact();
    }

    private void fetchContact() {
        ArrayList<String> contact=new ArrayList<>();
        ContentResolver resolver=getContentResolver();
        Uri uri= ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        String selection=null;
        String[] projection={ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER};
        String[] sel=null;String sortOrder=null;
        Cursor cursor=resolver.query(uri,projection,selection,sel, null);
//        while (cursor.moveToNext()){
//                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
//                String num = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
//                contact.add(name + "\n" + num);
//
//        }
        cursor.close();
        ((ListView)findViewById(R.id.ll)).setAdapter(new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,contact));

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