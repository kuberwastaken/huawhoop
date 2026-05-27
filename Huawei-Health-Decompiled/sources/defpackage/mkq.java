package defpackage;

import android.content.Context;

/* JADX INFO: loaded from: classes6.dex */
public class mkq extends mks {
    private static mkq c;

    private mkq(Context context, String str) {
        super(context, str);
    }

    public static mkq b(Context context) {
        mkq mkqVar;
        synchronized (mkq.class) {
            if (c == null) {
                c = new mkq(context, "com.huawei.hwid.site_list_info");
            }
            mkqVar = c;
        }
        return mkqVar;
    }
}
