package com.shaoyuan.core.utils;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.util.Log;

import com.shaoyuan.net.netcheck.NetworkConnectChangedReceiver;


/**
 * Created by small-ho on 2019/7/4 14:37
 * title：网络状态实时监控
 */
public class NetModeHelper {
    private static final String Tag = "NetModeHelper";

    public static void init(Context context,boolean isDebug) {
        init(context,isDebug,new NetworkConnectChangedReceiver());
    }

    private static void init(Context context, boolean isDebug, NetworkConnectChangedReceiver receiver) {
        if (null == context) {
            Log.e(Tag,"init arg 'context' should not be null!");
        }else {
            if (isDebug) {
                IntentFilter filter =  new IntentFilter();
                filter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
                filter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
                filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
                context.registerReceiver(receiver, filter);
            }else {
                Log.i(Tag,"网络实时监控已关闭");
            }
        }
    }
}
