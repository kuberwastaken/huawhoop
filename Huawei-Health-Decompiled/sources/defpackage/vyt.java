package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebSettings;
import java.util.Locale;

/* JADX INFO: loaded from: classes8.dex */
public final class vyt {
    private static final Object b = new Object();
    private static String d;

    public static String d(Context context) {
        String property;
        if (TextUtils.isEmpty(d)) {
            synchronized (b) {
                try {
                    property = WebSettings.getDefaultUserAgent(context);
                } catch (Exception unused) {
                    property = System.getProperty("http.agent");
                }
                if (property == null) {
                    return d;
                }
                StringBuffer stringBuffer = new StringBuffer();
                int length = property.length();
                for (int i = 0; i < length; i++) {
                    char cCharAt = property.charAt(i);
                    if (cCharAt <= 31 || cCharAt >= 127) {
                        stringBuffer.append(String.format(Locale.ROOT, "\\u%04x", Integer.valueOf(cCharAt)));
                    } else {
                        stringBuffer.append(cCharAt);
                    }
                }
                d = stringBuffer.toString();
            }
        }
        return d;
    }

    public static boolean a(Context context) {
        vwc.e("Util", "getDarkTheme system", false);
        return (context.getApplicationContext().getResources().getConfiguration().uiMode & 32) != 0;
    }
}
