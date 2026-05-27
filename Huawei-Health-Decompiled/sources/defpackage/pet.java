package defpackage;

import android.content.Context;

/* JADX INFO: loaded from: classes7.dex */
public class pet {
    private static float c = 1.0f;

    protected pet() {
        throw new UnsupportedOperationException();
    }

    public static void d(Context context) {
        c = context.getResources().getDisplayMetrics().density;
    }

    public static float b(float f) {
        return f * c;
    }
}
