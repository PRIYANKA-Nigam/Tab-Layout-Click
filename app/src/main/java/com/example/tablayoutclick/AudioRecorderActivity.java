package com.example.tablayoutclick;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;

import com.scwang.wave.MultiWaveHeader;

import java.io.File;
import java.io.IOException;

public class AudioRecorderActivity extends AppCompatActivity {
    private static final int MICROPHONE_CODE = 200;
    TextView textView; MultiWaveHeader w1,w2;
  MediaRecorder mediaRecorder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_recorder);
        textView=(TextView)findViewById(R.id.textView); mediaRecorder=new MediaRecorder();
        if (isMicroPhonePresent()){
            getMicroPhonePermission();
        }
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
    public void onclick(View view) throws Exception { if (view.getId()==R.id.imageView){ record();
    }else if (view.getId()==R.id.imageView2){ stopAudio();
    }else if (view.getId()==R.id.imageView3){ playAudio(); } }
    private void playAudio() throws IOException { MediaPlayer mediaPlayer=new MediaPlayer();
        mediaPlayer.setDataSource(getRecordingFilePath());mediaPlayer.prepare();mediaPlayer.start();
        textView.setText("Playing Recorded Audio"); }
    private void stopAudio() { mediaRecorder.stop();mediaRecorder.release();
    mediaRecorder=null;
    textView.setText("Recording Stopped");}
    private void record() throws IOException { mediaRecorder=new MediaRecorder();
     mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
     mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
     mediaRecorder.setOutputFile(getRecordingFilePath());
     mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        mediaRecorder.prepare();
            mediaRecorder.start();
            textView.setText("Audio Recording .........");

    }
    public boolean isMicroPhonePresent(){
        if (this.getPackageManager().hasSystemFeature(PackageManager.FEATURE_MICROPHONE)){
            return  true;
        }else {
            return false;
        }
    }
    public  void getMicroPhonePermission(){
        if (ContextCompat.checkSelfPermission(this,Manifest.permission.RECORD_AUDIO)==PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.RECORD_AUDIO},MICROPHONE_CODE);
        }
    }
    private String getRecordingFilePath(){
        ContextWrapper contextWrapper=new ContextWrapper(getApplicationContext());
        File mediaDir =contextWrapper.getExternalFilesDir(Environment.DIRECTORY_MUSIC);
        File file=new File(mediaDir,"testRecordingFile"+".mp3");
        return file.getPath();
    }

}