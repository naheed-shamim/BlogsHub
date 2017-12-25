package com.example.naheed.blogshub;

import android.app.Application;
import android.content.Context;

/**
 * Created by Naheed on 25/12/17.
 */

public class BlogsHubApp extends Application
{
    private static Context context;

    public void onCreate() {
        super.onCreate();
        BlogsHubApp.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return BlogsHubApp.context;
    }
}
