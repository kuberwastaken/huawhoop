package defpackage;

import android.content.Context;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes5.dex */
public class ikt {
    public static int e(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }
}
