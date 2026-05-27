package defpackage;

import com.fasterxml.jackson.core.JsonStreamContext;

/* JADX INFO: loaded from: classes9.dex */
public class wv {
    protected static final wv d = new wv();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final int f18941a;
    protected final String b;
    protected final wv c;
    protected final String e;

    protected wv() {
        this.c = null;
        this.e = "";
        this.f18941a = -1;
        this.b = "";
    }

    protected wv(String str, String str2, wv wvVar) {
        this.b = str;
        this.c = wvVar;
        this.e = str2;
        this.f18941a = a(str2);
    }

    protected wv(String str, String str2, int i, wv wvVar) {
        this.b = str;
        this.c = wvVar;
        this.e = str2;
        this.f18941a = i;
    }

    public static wv b(String str) throws IllegalArgumentException {
        if (str == null || str.length() == 0) {
            return d;
        }
        if (str.charAt(0) != '/') {
            throw new IllegalArgumentException("Invalid input: JSON Pointer expression must start with '/': \"" + str + "\"");
        }
        return d(str);
    }

    public static wv c(JsonStreamContext jsonStreamContext, boolean z) {
        if (jsonStreamContext == null) {
            return d;
        }
        if (!jsonStreamContext.hasPathSegment() && (!z || !jsonStreamContext.inRoot() || !jsonStreamContext.hasCurrentIndex())) {
            jsonStreamContext = jsonStreamContext.getParent();
        }
        wv wvVar = null;
        while (jsonStreamContext != null) {
            if (jsonStreamContext.inObject()) {
                String currentName = jsonStreamContext.getCurrentName();
                if (currentName == null) {
                    currentName = "";
                }
                wvVar = new wv(e(wvVar, currentName), currentName, wvVar);
            } else if (jsonStreamContext.inArray() || z) {
                int currentIndex = jsonStreamContext.getCurrentIndex();
                String strValueOf = String.valueOf(currentIndex);
                wvVar = new wv(e(wvVar, strValueOf), strValueOf, currentIndex, wvVar);
            }
            jsonStreamContext = jsonStreamContext.getParent();
        }
        return wvVar == null ? d : wvVar;
    }

    private static String e(wv wvVar, String str) {
        if (wvVar == null) {
            StringBuilder sb = new StringBuilder(str.length() + 1);
            sb.append('/');
            c(sb, str);
            return sb.toString();
        }
        String str2 = wvVar.b;
        StringBuilder sb2 = new StringBuilder(str.length() + 1 + str2.length());
        sb2.append('/');
        c(sb2, str);
        sb2.append(str2);
        return sb2.toString();
    }

    private static void c(StringBuilder sb, String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '/') {
                sb.append("~1");
            } else if (cCharAt == '~') {
                sb.append("~0");
            } else {
                sb.append(cCharAt);
            }
        }
    }

    public boolean c() {
        return this.c == null;
    }

    public String b() {
        return this.e;
    }

    public int e() {
        return this.f18941a;
    }

    public wv d() {
        return this.c;
    }

    public String toString() {
        return this.b;
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof wv)) {
            return this.b.equals(((wv) obj).b);
        }
        return false;
    }

    private static final int a(String str) {
        int length = str.length();
        if (length == 0 || length > 10) {
            return -1;
        }
        char cCharAt = str.charAt(0);
        if (cCharAt <= '0') {
            return (length == 1 && cCharAt == '0') ? 0 : -1;
        }
        if (cCharAt > '9') {
            return -1;
        }
        for (int i = 1; i < length; i++) {
            char cCharAt2 = str.charAt(i);
            if (cCharAt2 > '9' || cCharAt2 < '0') {
                return -1;
            }
        }
        if (length != 10 || xh.a(str) <= 2147483647L) {
            return xh.d(str);
        }
        return -1;
    }

    protected static wv d(String str) {
        int length = str.length();
        int i = 1;
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '/') {
                return new wv(str, str.substring(1, i), d(str.substring(i)));
            }
            i++;
            if (cCharAt == '~' && i < length) {
                return c(str, i);
            }
        }
        return new wv(str, str.substring(1), d);
    }

    protected static wv c(String str, int i) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(Math.max(16, length));
        if (i > 2) {
            sb.append((CharSequence) str, 1, i - 1);
        }
        int i2 = i + 1;
        e(sb, str.charAt(i));
        while (i2 < length) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == '/') {
                return new wv(str, sb.toString(), d(str.substring(i2)));
            }
            int i3 = i2 + 1;
            if (cCharAt == '~' && i3 < length) {
                e(sb, str.charAt(i3));
                i2 += 2;
            } else {
                sb.append(cCharAt);
                i2 = i3;
            }
        }
        return new wv(str, sb.toString(), d);
    }

    private static void e(StringBuilder sb, char c) {
        if (c == '0') {
            c = '~';
        } else if (c == '1') {
            c = '/';
        } else {
            sb.append('~');
        }
        sb.append(c);
    }
}
