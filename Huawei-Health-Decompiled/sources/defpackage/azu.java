package defpackage;

import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public class azu {
    public static final azu e = new azu();

    public void a(String str, String str2) {
    }

    public void c(String str, String str2) {
        Log.w("AutoParcelable", str + ":" + str2);
    }

    public void e(String str, String str2) {
        Log.e("AutoParcelable", str + ":" + str2);
    }

    public void b(String str, String str2, Throwable th) {
        Log.e("AutoParcelable", str + ":" + str2, th);
    }
}
