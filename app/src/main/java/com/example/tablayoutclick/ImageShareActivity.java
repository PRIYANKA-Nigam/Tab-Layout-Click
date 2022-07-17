package com.example.tablayoutclick;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ImageShareActivity extends AppCompatActivity {
    Button b; ImageView imageView;
    OutputStream outputStream;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_share);
        imageView=(ImageView)findViewById(R.id.img); Button button=findViewById(R.id.share); b=(Button)findViewById(R.id.save);
        b.setOnClickListener(new View.OnClickListener() { @Override public void onClick(View v) {
            BitmapDrawable drawable=(BitmapDrawable)imageView.getDrawable(); Bitmap bitmap=drawable.getBitmap();
            File filePath= Environment.getExternalStorageDirectory();File dir=new File(filePath.getAbsolutePath()+"/Demo/");
            dir.mkdir(); File file=new File(dir,System.currentTimeMillis()+".jpg");
            try { outputStream=new FileOutputStream(file); } catch (FileNotFoundException e) { e.printStackTrace(); }
            try { bitmap.compress(Bitmap.CompressFormat.JPEG,100,outputStream); }catch (NullPointerException e){ e.printStackTrace(); }
            Toast.makeText(getApplicationContext(),"Image Saved in Memory",Toast.LENGTH_SHORT).show();
            try { outputStream.flush(); } catch (IOException |NullPointerException e) { e.printStackTrace(); }
            try { outputStream.close(); } catch (IOException|NullPointerException e) {
                e.printStackTrace(); } }});button.setOnClickListener(new View.OnClickListener() {@Override
        public void onClick(View v) { String shareText="Winsoft_Tube"+"\n"+"SUBSCRIBE ME";Bitmap bitmap=getBitmapfromView(imageView);
            File file=new File(ImageShareGeneric.context.getExternalCacheDir(),"gg1.jpg");
            FileOutputStream fileOutputStream= null;
            try { fileOutputStream = new FileOutputStream(file); } catch (FileNotFoundException e) { e.printStackTrace(); }
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,fileOutputStream);
            try { fileOutputStream.flush(); } catch (IOException e) {
                e.printStackTrace(); }
            try { fileOutputStream.close(); } catch (IOException e) { e.printStackTrace(); }
            file.setReadable(true,false);
            Intent intent=new Intent();intent.setAction(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_TEXT,shareText);
            Uri uri= FileProvider.getUriForFile(ImageShareGeneric.context,ImageShareGeneric.context.getApplicationContext().getPackageName()+".provider",file);
            intent.putExtra(Intent.EXTRA_STREAM,uri);intent.setType("image/jpeg");intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);startActivity(Intent.createChooser(intent,null)); }});
    }
    public static Bitmap getBitmapfromView(View view){ Bitmap bit=Bitmap.createBitmap(view.getWidth(),view.getHeight(),Bitmap.Config.ARGB_4444);
        Canvas canvas=new Canvas(bit);       //convert img or any view to bitmap
        Drawable drawable=view.getBackground();if (drawable!=null){ drawable.draw(canvas); }else { canvas.drawColor(Color.WHITE); }
        view.draw(canvas);return bit; }
}