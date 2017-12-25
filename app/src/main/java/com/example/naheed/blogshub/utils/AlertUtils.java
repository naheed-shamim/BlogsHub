package com.example.naheed.blogshub.utils;

import android.widget.Toast;

import com.example.naheed.blogshub.BlogsHubApp;

/**
 * Created by Naheed on 25/12/17.
 */

public class AlertUtils {

    public static void showShortToast(String msg)
    {
        Toast.makeText(BlogsHubApp.getAppContext(),msg,Toast.LENGTH_SHORT).show();
    }

    public static void showLongToast(String msg)
    {
        Toast.makeText(BlogsHubApp.getAppContext(),msg,Toast.LENGTH_LONG).show();
    }
}
