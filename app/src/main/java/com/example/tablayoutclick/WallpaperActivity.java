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
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class WallpaperActivity extends AppCompatActivity {
    TextView textView;   MultiWaveHeader w1,w2;
    boolean running;
    int [] in=new int[] {R.drawable.chicken_snacks,R.drawable.cry,R.drawable.fries_with_hamburger,
    R.drawable.fritters,R.drawable.fritters,R.drawable.fruit_custard,R.drawable.octagon,R.drawable.p2};
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
        if (!running){
            new Timer().schedule(new MyTimer(),0,7000);
            running=true;
        }
//        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.wallpaper);
//        WallpaperManager wallpaperManager=WallpaperManager.getInstance(getApplicationContext());
//        try {
//            wallpaperManager.setBitmap(bitmap);
//            Toast.makeText(this,"Wallpaper Set",Toast.LENGTH_SHORT).show();
//        }catch (IOException e){
//            Toast.makeText(this,"Wallpaper Set",Toast.LENGTH_SHORT).show();
//
//        }
    }

    private class MyTimer extends TimerTask {
        @Override
        public void run() {
            try {  WallpaperManager wallpaperManager=WallpaperManager.getInstance(getBaseContext());
                Random random=new Random();
                wallpaperManager.setBitmap(BitmapFactory.decodeResource(getResources(),in[random.nextInt(8)]));
                Toast.makeText(WallpaperActivity.this,"Wallpaper Set",Toast.LENGTH_SHORT).show();
            }catch (Exception e){

            }
        }
    }
}