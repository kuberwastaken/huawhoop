package defpackage;

import android.text.TextUtils;
import com.huawei.wearengine.auth.AuthListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes11.dex */
public class wqv {
    private static volatile wqv c;
    private Map<String, AuthListener> e = new ConcurrentHashMap();

    private wqv() {
    }

    public static wqv c() {
        if (c == null) {
            synchronized (wqv.class) {
                if (c == null) {
                    c = new wqv();
                }
            }
        }
        return c;
    }

    public void c(String str, AuthListener authListener) {
        if (TextUtils.isEmpty(str) || authListener == null || this.e == null) {
            return;
        }
        wro.a("AuthCallbackManage", "putCallbackToMap mAuthListenerMap != null");
        this.e.put(str, authListener);
    }

    public AuthListener a(String str) {
        if (TextUtils.isEmpty(str)) {
            wro.d("AuthCallbackManage", "getCallbackFromMap key == null");
            return null;
        }
        if (!this.e.containsKey(str)) {
            wro.d("AuthCallbackManage", "getCallbackFromMap mAuthListenerMap not containsKey");
            return null;
        }
        AuthListener authListener = this.e.get(str);
        this.e.remove(str);
        return authListener;
    }

    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            wro.d("AuthCallbackManage", "removeCallbackFromMap key isEmpty");
        } else if (!this.e.containsKey(str)) {
            wro.d("AuthCallbackManage", "removeCallbackFromMap mAuthListenerMap not containsKey");
        } else {
            this.e.remove(str);
        }
    }
}
