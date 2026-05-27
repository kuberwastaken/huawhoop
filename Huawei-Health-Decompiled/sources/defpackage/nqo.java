package defpackage;

import android.app.Activity;
import android.view.View;

/* JADX INFO: loaded from: classes7.dex */
public class nqo {
    public static <T extends View> T cnw_(View view, int i) {
        return (T) view.findViewById(i);
    }

    public static <T extends View> T cnv_(Activity activity, int i) {
        return (T) activity.findViewById(i);
    }
}
