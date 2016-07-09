package com.kob.a3dgame.netUtils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Administrator on 2016/7/5.
 */
public class NetUtils {
    public static boolean netConnect(Activity activity) {
        boolean isconnect = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) activity.getApplication().
                getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isAvailable()) {
            isconnect = true;
        }
        return isconnect;
    }
}
