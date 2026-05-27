package defpackage;

import android.view.View;

/* JADX INFO: loaded from: classes10.dex */
public final class avr {
    public static <T extends View> T gF_(View view, int i) {
        if (view != null) {
            return (T) view.findViewById(i);
        }
        return null;
    }
}
