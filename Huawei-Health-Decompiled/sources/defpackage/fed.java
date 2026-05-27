package defpackage;

/* JADX INFO: loaded from: classes10.dex */
public class fed {
    public static int c(int i, int i2) {
        if (i == 0) {
            return 12000;
        }
        if (i2 <= 1) {
            return i;
        }
        int iD = d(i);
        if (iD < 1) {
            iD = 1;
        }
        int iPow = (int) Math.pow(10.0d, iD - 1);
        int i3 = 0;
        while (i3 < i) {
            i3 += (i2 - 1) * iPow;
        }
        return i3;
    }

    private static int d(int i) {
        int i2 = 0;
        do {
            i /= 10;
            if (i != 0) {
                i2++;
            }
        } while (i != 0);
        return i2;
    }
}
