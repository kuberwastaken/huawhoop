package defpackage;

import android.content.Context;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;

/* JADX INFO: loaded from: classes8.dex */
public class vpd {
    public static Context d(Context context, int i, int i2) {
        return context.getTheme().resolveAttribute(i, new TypedValue(), false) ? context : new ContextThemeWrapper(context, i2);
    }
}
