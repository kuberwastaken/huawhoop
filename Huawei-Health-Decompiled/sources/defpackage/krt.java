package defpackage;

import android.net.Uri;
import health.compact.a.CommonUtils;

/* JADX INFO: loaded from: classes.dex */
public class krt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f14859a = CommonUtils.h(".version.provider");
    private static String b = "content://" + f14859a + "/";

    public static Uri bMO_(String str) {
        return Uri.parse(new StringBuffer().append(b).append(str).toString());
    }
}
