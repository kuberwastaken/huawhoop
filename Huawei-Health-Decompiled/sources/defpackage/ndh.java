package defpackage;

import android.emcom.IOneHopAppCallback;
import android.emcom.IOneHopAuthReqCallback;

/* JADX INFO: loaded from: classes6.dex */
public class ndh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ndo f16009a;
    private static volatile ndh d;

    private ndh() {
        if (f16009a == null) {
            f16009a = ndo.e();
        }
    }

    public static ndh c() {
        ndh ndhVar;
        synchronized (ndh.class) {
            if (d == null) {
                d = new ndh();
            }
            ndhVar = d;
        }
        return ndhVar;
    }

    public int e(String str, int i, IOneHopAppCallback.Stub stub) {
        return f16009a.a(str, i, stub);
    }

    public String b() {
        return f16009a.a();
    }

    public int e(String str, IOneHopAuthReqCallback.Stub stub) {
        return f16009a.e(str, stub);
    }
}
