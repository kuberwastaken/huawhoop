package defpackage;

/* JADX INFO: loaded from: classes6.dex */
public final class nnn {
    public static int a(String str, int i) {
        if (nnr.b(str)) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i;
        }
    }
}
