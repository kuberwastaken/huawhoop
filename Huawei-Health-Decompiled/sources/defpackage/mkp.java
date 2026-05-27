package defpackage;

import android.content.Context;

/* JADX INFO: loaded from: classes6.dex */
public class mkp extends mks {
    private static mkp e;

    public mkp(Context context, String str) {
        super(context, str);
    }

    public static mkp b(Context context) {
        mkp mkpVar;
        synchronized (mkp.class) {
            if (e == null) {
                e = new mkp(context, "HwIDAuthInfo");
            }
            mkpVar = e;
        }
        return mkpVar;
    }
}
