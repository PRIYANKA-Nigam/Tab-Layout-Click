package com.example.tablayoutclick;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class CallActivity extends AppCompatActivity {
ImageView imageView;String num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        imageView = findViewById(R.id.imageView);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int image = bundle.getInt("Desc", 0);
            num = bundle.getString("Num");
            imageView.setImageResource(image);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_icon, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) { int id = item.getItemId();
        switch (id) {
            case R.id.call:
                Intent intent1 = new Intent(CallActivity.this, PhoneActivity.class);
                intent1.putExtra("call",num);
                startActivity(intent1);
                break;
            case R.id.contact:
                AlertDialog.Builder builder=new AlertDialog.Builder(CallActivity.this);
                View dialogView =LayoutInflater.from(CallActivity.this).inflate(R.layout.view_contact,null);
               TextView textView =dialogView.findViewById(R.id.textView3);
               ImageView i1=dialogView.findViewById(R.id.imageView2);
               i1.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       Intent intent1 = new Intent(CallActivity.this, PhoneActivity.class);
                       intent1.putExtra("call",num);
                       startActivity(intent1);
                   }
               });
                ImageView i2=dialogView.findViewById(R.id.imageView3);
                i2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(CallActivity.this,SMSActivity.class);
                        intent.putExtra("sms",num);
                       startActivity(intent);
                    }
                });
                ImageView i3=dialogView.findViewById(R.id.imageView4);
                i3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(CallActivity.this,EmailActivity.class);
                        startActivity(intent);
                    }
                });
                ImageView i4=dialogView.findViewById(R.id.imageView6);
                i4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(CallActivity.this,SpeechActivity.class);
                        intent.putExtra("sms",num);
                        startActivity(intent);
                    }
                });
               textView.setText(num);
                builder.setView(dialogView);
                builder.setCancelable(true);
                builder.show();
              break;
            case R.id.wallpaper:
                Intent intent3 = new Intent(CallActivity.this, WallpaperActivity.class);
                startActivity(intent3);
                break;
            case R.id.doc:
                Intent intent4 = new Intent(CallActivity.this, DocActivity.class);
                startActivity(intent4);
                break;
//            case R.id.globe:
//                Intent intent5 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
//                startActivity(intent5);
//                break;
        }
        return super.onOptionsItemSelected(item); }
}