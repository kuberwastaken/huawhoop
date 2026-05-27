package ohos.ace.plugin.utilplugin;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.common.primitives.UnsignedBytes;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes2.dex */
public class UtilPlugin {
    private static final String TAG = "UtilPlugin";

    protected native void nativeInit();

    public UtilPlugin(Context context) {
        nativeInit();
    }

    public String encodeIntoChinese(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            Log.e(TAG, "Input or encoding is empty");
            return "";
        }
        try {
            for (byte b : str.getBytes(str2)) {
                String hexString = Integer.toHexString(b & UnsignedBytes.MAX_VALUE);
                if (hexString.length() < 2) {
                    sb.append(0);
                }
                sb.append(hexString);
            }
        } catch (UnsupportedEncodingException e) {
            Log.e(TAG, "Encoding to chinese failed, unsupported encode type");
            e.printStackTrace();
        }
        return sb.toString();
    }

    public String decode(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            Log.e(TAG, "Input or encoding is empty");
            return "";
        }
        try {
            return new String(new String(str.getBytes("latin1"), str2).getBytes("utf-8"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            Log.e(TAG, "Decode failed, unsupported encode type");
            e.printStackTrace();
            return "";
        }
    }
}
