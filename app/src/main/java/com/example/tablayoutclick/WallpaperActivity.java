package com.example.tablayoutclick;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.scwang.wave.MultiWaveHeader;

import java.io.IOException;

public class WallpaperActivity extends AppCompatActivity {
    TextView textView;   MultiWaveHeader w1,w2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper);
        textView=findViewById(R.id.textView);
        textView.setSelected(true);
        w1=findViewById(R.id.wave);
        w2=findViewById(R.id.wave2);
        w1.setVelocity(1);
        w1.setProgress(1);
        w1.isRunning();
        w1.setGradientAngle(45);
        w1.setWaveHeight(40);
        w1.setStartColor(Color.RED);
        w1.setCloseColor(Color.CYAN);
        w2.setVelocity(1);
        w2.setProgress(1);
        w2.isRunning();
        w2.setGradientAngle(45);
        w2.setWaveHeight(40);
        w2.setStartColor(Color.MAGENTA);
        w2.setCloseColor(Color.YELLOW);
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