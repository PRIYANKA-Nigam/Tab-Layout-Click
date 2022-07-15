package com.example.tablayoutclick;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class WallpaperActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper);
        textView=findViewById(R.id.textView);
        textView.setSelected(true);
    }
    public void btn(View view) {
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.wallpaper);
        WallpaperManager wallpaperManager=WallpaperManager.getInstance(getApplicationContext());
        try {
            wallpaperManager.setBitmap(bitmap);
            Toast.makeText(this,"Wallpaper Set",Toast.LENGTH_SHORT).show();
        }catch (IOException e){
            Toast.makeText(this,"Wallpaper Set",Toast.LENGTH_SHORT).show();

        }
    }
}