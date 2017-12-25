package com.example.naheed.blogshub.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.naheed.blogshub.BlogsHubApp;
import com.example.naheed.blogshub.R;

/**
 * Created by Naheed on 21/12/17.
 */

public class NetworkUtils
{
    /**
     * method to check the connection
     *
     * @return true if network connection is available
     */
    public static boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) BlogsHubApp.getAppContext().getSystemService(
                Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();

        if (info == null)
            return false;

        NetworkInfo.State network = info.getState();
        return (network == NetworkInfo.State.CONNECTED || network == NetworkInfo.State.CONNECTING);
    }

    /**
     * method to toast message if internet is not connected
     *
     * @return true if internet is connected
     */
    public static boolean isInternetConnected() {
        if (isNetworkAvailable()) {
            return true;
        } else
            {
                AlertUtils.showShortToast("No Internet");
//            showToast(RTMApplication.getsApplicationContext().getString(R.string.no_internet));
            return false;
        }
    }
}
