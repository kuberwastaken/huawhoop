package defpackage;

import android.text.TextUtils;
import com.google.android.clockwork.companion.partnerapi.SmartWatchInfo;

/* JADX INFO: loaded from: classes5.dex */
public class klj {
    private static SmartWatchInfo e;

    public static String e(String str) {
        return TextUtils.isEmpty(str) ? "" : str.endsWith("smart_watch") ? str.substring(0, str.length() - 11) : str;
    }

    public static SmartWatchInfo a() {
        return e;
    }
}
