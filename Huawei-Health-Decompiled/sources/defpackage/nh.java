package defpackage;

/* JADX INFO: loaded from: classes9.dex */
public class nh {
    public static byte[] d(int i) {
        return new byte[]{(byte) ((i >> 24) % 256), (byte) ((i >> 16) % 256), (byte) ((i >> 8) % 256), (byte) (i % 256)};
    }
}
