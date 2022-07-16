package com.example.tablayoutclick;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.scwang.wave.MultiWaveHeader;

import java.util.ArrayList;
import java.util.Locale;

public class CallActivity extends AppCompatActivity {
ImageView imageView;String num,name; EditText editText;
    MultiWaveHeader w1,w2; TextView textView,textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        imageView = findViewById(R.id.imageView);
        textView=findViewById(R.id.textView7);
        textView2=findViewById(R.id.textView8);
        editText=findViewById(R.id.editTextTextMultiLine3);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int image = bundle.getInt("Desc", 0);
            num = bundle.getString("Num");
            name = bundle.getString("Name");
            imageView.setImageResource(image);
        }
        textView.setText(name);
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
                        Intent intent=new Intent(CallActivity.this, TextToSpeechActivity.class);
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
            case R.id.pay:
                 startActivity(new Intent(CallActivity.this,PaymentActivity.class));
                break;
            case R.id.info:
                startActivity(new Intent(CallActivity.this,InfoActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item); }

    public void send(View view) {
String s=editText.getText().toString().trim();
editText.setText("");
textView2.setText(s);
    }

    public void video(View view) {
        startActivity(new Intent(CallActivity.this,VideoActivity.class));
    }

    public void camera(View view) {
        startActivity(new Intent(CallActivity.this,CameraActivity.class));
    }

    public void speech(View view) {
        Intent intent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Hi Speak Something.");
        try { startActivityForResult(intent,1);
        }catch (ActivityNotFoundException e){ Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT).show(); }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data); switch (requestCode){
            case 1:
                if (resultCode==RESULT_OK && data!=null){
                    ArrayList<String> result=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    editText.setText(result.get(0)); }
                break; } }
}