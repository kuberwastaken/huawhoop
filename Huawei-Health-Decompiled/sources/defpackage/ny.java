package defpackage;

import android.content.Context;
import com.alipay.sdk.m.q0.d;
import java.util.zip.Adler32;

/* JADX INFO: loaded from: classes9.dex */
public class ny {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static nq f16227a;
    public static final Object c = new Object();

    public static nq d(Context context) {
        synchronized (ny.class) {
            nq nqVar = f16227a;
            if (nqVar != null) {
                return nqVar;
            }
            if (context == null) {
                return null;
            }
            nq nqVarE = e(context);
            f16227a = nqVarE;
            return nqVarE;
        }
    }

    public static long b(nq nqVar) {
        if (nqVar == null) {
            return 0L;
        }
        String str = String.format("%s%s%s%s%s", nqVar.b(), nqVar.e(), Long.valueOf(nqVar.d()), nqVar.a(), nqVar.c());
        if (ng.a(str)) {
            return 0L;
        }
        Adler32 adler32 = new Adler32();
        adler32.reset();
        adler32.update(str.getBytes());
        return adler32.getValue();
    }

    public static nq e(Context context) {
        if (context == null) {
            return null;
        }
        synchronized (c) {
            String strA = d.c(context).a();
            if (ng.a(strA)) {
                return null;
            }
            if (strA.endsWith("\n")) {
                strA = strA.substring(0, strA.length() - 1);
            }
            nq nqVar = new nq();
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strE = nk.e(context);
            String strC = nk.c(context);
            nqVar.b(strE);
            nqVar.a(strE);
            nqVar.a(jCurrentTimeMillis);
            nqVar.c(strC);
            nqVar.d(strA);
            nqVar.d(b(nqVar));
            return nqVar;
        }
    }
}
