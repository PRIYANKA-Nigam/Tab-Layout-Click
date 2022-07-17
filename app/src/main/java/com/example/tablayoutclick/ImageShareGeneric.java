package com.example.tablayoutclick;

import android.app.Application;
import android.content.Context;

public class ImageShareGeneric extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
    }
}
