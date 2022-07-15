package com.example.tablayoutclick;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;

public class AudioRecorderActivity extends AppCompatActivity { TextView textView;
    MediaRecorder mediaRecorder; public static String filename="recorded.jpg";
    String file= Environment.getExternalStorageDirectory().getAbsolutePath()+ File.separator+filename;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_recorder);
        textView=(TextView)findViewById(R.id.textView); mediaRecorder=new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mediaRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        mediaRecorder.setOutputFile(file);
    }
    public void onclick(View view) throws IOException { if (view.getId()==R.id.imageView){ record();
    }else if (view.getId()==R.id.imageView2){ stopAudio();
    }else if (view.getId()==R.id.imageView3){ playAudio(); } }
    private void playAudio() throws IOException { MediaPlayer mediaPlayer=new MediaPlayer();
        mediaPlayer.setDataSource(file);mediaPlayer.prepare();mediaPlayer.start();
        textView.setText("Playing Recorded Audio"); }
    private void stopAudio() { mediaRecorder.stop();mediaRecorder.release();textView.setText("Recording Stopped");}
    private void record() throws IOException {
        mediaRecorder.prepare();
        mediaRecorder.start();
        textView.setText("Audio Recording ........."); }
}