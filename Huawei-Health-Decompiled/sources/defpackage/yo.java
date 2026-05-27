package defpackage;

import com.fasterxml.jackson.core.Versioned;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes9.dex */
public class yo {
    private static final Pattern e = Pattern.compile("[-_./;:]");

    protected yo() {
    }

    public static wz d(Class<?> cls) {
        wz wzVarVersion;
        try {
            Class<?> cls2 = Class.forName(cls.getPackage().getName() + ".PackageVersion", true, cls.getClassLoader());
            try {
                wzVarVersion = ((Versioned) cls2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0])).version();
            } catch (Exception unused) {
                throw new IllegalArgumentException("Failed to get Versioned out of " + cls2);
            }
        } catch (Exception unused2) {
            wzVarVersion = null;
        }
        return wzVarVersion == null ? wz.b() : wzVarVersion;
    }

    public static wz a(String str, String str2, String str3) {
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.length() > 0) {
                String[] strArrSplit = e.split(strTrim);
                return new wz(b(strArrSplit[0]), strArrSplit.length > 1 ? b(strArrSplit[1]) : 0, strArrSplit.length > 2 ? b(strArrSplit[2]) : 0, strArrSplit.length > 3 ? strArrSplit[3] : null, str2, str3);
            }
        }
        return wz.b();
    }

    protected static int b(String str) {
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt > '9' || cCharAt < '0') {
                break;
            }
            i = (i * 10) + (cCharAt - '0');
        }
        return i;
    }

    public static final void e() {
        throw new RuntimeException("Internal error: this code path should never get executed");
    }
}
