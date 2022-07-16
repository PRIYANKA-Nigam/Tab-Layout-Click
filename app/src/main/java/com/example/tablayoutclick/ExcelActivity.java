package com.example.tablayoutclick;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.scwang.wave.MultiWaveHeader;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelActivity extends AppCompatActivity {
    EditText e;
    private File filePath=new File(Environment.getExternalStorageDirectory() + "/Demos.xls");
    MultiWaveHeader w1,w2;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excel);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE
                ,Manifest.permission.READ_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);
        e=(EditText)findViewById(R.id.editTextTextPersonName);
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
    public void CreateExcel(View view) throws IOException { HSSFWorkbook hssfWorkbook=new HSSFWorkbook();
        HSSFSheet hssfSheet=hssfWorkbook.createSheet("Custom Sheet");
        Toast.makeText(this,"Cell record created ...",Toast.LENGTH_SHORT).show();
        HSSFRow hssfRow =hssfSheet.createRow(0);
        HSSFCell hssfCell =hssfRow.createCell(0);
        hssfCell.setCellValue(e.getText().toString());
        try { if (!filePath.exists()){ filePath.createNewFile(); }
            FileOutputStream fileOutputStream=new FileOutputStream(filePath);hssfWorkbook.write(fileOutputStream);
            if (fileOutputStream!=null){ fileOutputStream.flush();fileOutputStream.close(); }
        }catch (Exception e){ e.printStackTrace(); } }
}