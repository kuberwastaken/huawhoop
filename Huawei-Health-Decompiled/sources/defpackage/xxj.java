package defpackage;

/* JADX INFO: loaded from: classes8.dex */
public class xxj {
    public static boolean a(byte b, int i) {
        return (((long) b) & (1 << i)) != 0;
    }

    public static byte b(byte b, int i) {
        return (byte) (b & (~(1 << i)));
    }

    public static byte c(byte b, int i) {
        return (byte) (b | (1 << i));
    }
}
