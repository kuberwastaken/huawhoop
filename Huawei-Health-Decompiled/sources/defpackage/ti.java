package defpackage;

import android.content.Context;
import android.util.Log;
import java.util.Arrays;
import org.json.JSONException;

/* JADX INFO: loaded from: classes9.dex */
class ti {
    private static final ti d = new ti();

    static ti e() {
        return d;
    }

    private ti() {
    }

    tj c(Context context) {
        String strA = uq.a("browserSwitch.request", context);
        if (strA != null) {
            try {
                return tj.b(strA);
            } catch (JSONException e) {
                Log.d("BrowserSwitch", e.getMessage());
                Log.d("BrowserSwitch", Arrays.toString(e.getStackTrace()));
            }
        }
        return null;
    }

    void a(tj tjVar, Context context) {
        try {
            uq.e("browserSwitch.request", tjVar.c(), context);
        } catch (JSONException e) {
            Log.d("BrowserSwitch", e.getMessage());
            Log.d("BrowserSwitch", Arrays.toString(e.getStackTrace()));
        }
    }

    void b(tf tfVar, Context context) {
        try {
            uq.e("browserSwitch.result", tfVar.c(), context);
        } catch (JSONException e) {
            Log.d("BrowserSwitch", e.getMessage());
            Log.d("BrowserSwitch", Arrays.toString(e.getStackTrace()));
        }
    }

    tf e(Context context) {
        String strA = uq.a("browserSwitch.result", context);
        if (strA != null) {
            try {
                return tf.c(strA);
            } catch (JSONException e) {
                Log.d("BrowserSwitch", e.getMessage());
                Log.d("BrowserSwitch", Arrays.toString(e.getStackTrace()));
            }
        }
        return null;
    }

    void b(Context context) {
        uq.e("browserSwitch.request", context);
    }

    void a(Context context) {
        uq.e("browserSwitch.result", context);
        uq.e("browserSwitch.request", context);
    }
}
