package ohos.ace.plugin.broadcastplugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class BroadcastPlugin {
    private static final int BATTERY_FULL_VALUE = 100;
    private static boolean BATTERY_LOW_FLAG = false;
    private static final int BATTERY_LOW_VALUE = 20;
    private static boolean BATTERY_NORMAL_FLAG = false;
    private static final String LOG_TAG = "BroadcastPlugin";
    private Map<String, BroadcastReceiver> broadcastReceiverMap;
    private Context context;

    protected native void nativeInit();

    protected native void nativeReceiveBroadcast(String str, String str2, String str3);

    public BroadcastPlugin(Context context) {
        if (context != null) {
            this.context = context;
        } else {
            Log.e(LOG_TAG, "context is null");
        }
        this.broadcastReceiverMap = new HashMap();
        nativeInit();
    }

    public BroadcastPlugin(Context context, boolean z) {
        if (context != null) {
            this.context = context;
        } else {
            Log.e(LOG_TAG, "context is null");
        }
        this.broadcastReceiverMap = new HashMap();
        if (z) {
            nativeInit();
        }
    }

    public boolean sendBroadcast(String str, String str2) {
        if (this.context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        Intent intent = new Intent(str);
        if (!TextUtils.isEmpty(str2)) {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    intent.putExtra(next, (String) jSONObject.get(next));
                }
            } catch (JSONException e) {
                Log.e(LOG_TAG, "Send broadcast failed, JSONException.");
                e.printStackTrace();
                return false;
            }
        }
        this.context.sendBroadcast(intent);
        return true;
    }

    public boolean registerBroadcast(String str, String[] strArr) {
        if (this.context == null || TextUtils.isEmpty(str) || strArr == null || strArr.length == 0) {
            return false;
        }
        IntentFilter intentFilter = new IntentFilter();
        for (String str2 : strArr) {
            if ("android.intent.action.BATTERY_LOW".equals(str2) || "android.intent.action.BATTERY_OKAY".equals(str2)) {
                intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            } else {
                intentFilter.addAction(str2);
            }
        }
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: ohos.ace.plugin.broadcastplugin.BroadcastPlugin.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    Bundle extras = intent.getExtras();
                    String str3 = "";
                    if (extras != null && extras.size() > 0) {
                        for (String str4 : extras.keySet()) {
                            jSONObject.put(str4, extras.get(str4) + "");
                        }
                    }
                    Iterator it = BroadcastPlugin.this.broadcastReceiverMap.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Map.Entry entry = (Map.Entry) it.next();
                        if (entry.getValue() == this) {
                            str3 = (String) entry.getKey();
                            break;
                        }
                    }
                    BroadcastPlugin.this.receiveBroadcast(str3, intent, jSONObject.toString());
                } catch (JSONException e) {
                    Log.e(BroadcastPlugin.LOG_TAG, "Receive broadcast failed, JSONException.");
                    e.printStackTrace();
                }
            }
        };
        this.context.registerReceiver(broadcastReceiver, intentFilter);
        this.broadcastReceiverMap.put(str, broadcastReceiver);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void receiveBroadcast(String str, Intent intent, String str2) {
        Log.i(LOG_TAG, " receiveBroadcast " + str);
        if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
            int intExtra = (intent.getIntExtra("level", 0) * 100) / intent.getIntExtra("scale", 100);
            if (intExtra <= 20 && str.contains("usual.event.BATTERY_LOW") && !BATTERY_LOW_FLAG) {
                nativeReceiveBroadcast(str, "android.intent.action.BATTERY_LOW", str2);
                BATTERY_LOW_FLAG = true;
                BATTERY_NORMAL_FLAG = false;
            }
            if (intExtra <= 20 || !str.contains("usual.event.BATTERY_OKAY") || BATTERY_NORMAL_FLAG) {
                return;
            }
            nativeReceiveBroadcast(str, "android.intent.action.BATTERY_OKAY", str2);
            BATTERY_NORMAL_FLAG = true;
            BATTERY_LOW_FLAG = false;
            return;
        }
        nativeReceiveBroadcast(str, intent.getAction(), str2);
    }

    public boolean unRegisterBroadcast(String str) {
        if (this.context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        Map<String, BroadcastReceiver> map = this.broadcastReceiverMap;
        if (map == null || map.size() <= 0) {
            return true;
        }
        for (String str2 : this.broadcastReceiverMap.keySet()) {
            if (str2.equals(str)) {
                this.context.unregisterReceiver(this.broadcastReceiverMap.get(str2));
                return true;
            }
        }
        return true;
    }
}
