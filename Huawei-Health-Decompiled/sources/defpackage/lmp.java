package defpackage;

import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class lmp {
    public static byte[] a() {
        return dte.a(dte.a(1) + dte.a(0));
    }

    public static byte[] e(long j, long j2) {
        String str = ("" + dte.a(1)) + dte.a(0);
        if (j != 0) {
            String str2 = (str + dte.a(3) + dte.a(4)) + dte.c(j);
            if (j2 != 0) {
                str = (str2 + dte.a(4) + dte.a(4)) + dte.c(j2);
            } else {
                str = str2;
            }
        }
        return dte.a(str);
    }

    public static byte[] a(int i) {
        return dte.a(((("" + dte.a(129)) + dte.a(4)) + dte.a(2)) + dte.a(2) + dte.b(i));
    }

    public static byte[] e(int i, int i2) {
        return dte.a(((((("" + dte.a(129)) + dte.a(8)) + dte.a(2)) + dte.a(2) + dte.b(i)) + dte.a(3)) + dte.a(2) + dte.b(i2));
    }

    public static byte[] a(long j, long j2) {
        String str = dte.a(129) + dte.a(0);
        if (j != 0) {
            String str2 = (str + dte.a(3) + dte.a(4)) + dte.c(j);
            if (j2 != 0) {
                str = (str2 + dte.a(4) + dte.a(4)) + dte.c(j2);
            } else {
                str = str2;
            }
        }
        return dte.a(str);
    }

    public static byte[] c(int i) {
        return dte.a(((("" + dte.a(129)) + dte.a(4)) + dte.a(2)) + dte.a(2) + dte.b(i));
    }

    public static byte[] b(long j, long j2) {
        String str = dte.a(129) + dte.a(0);
        if (j != 0) {
            String str2 = (str + dte.a(3) + dte.a(4)) + dte.c(j);
            if (j2 != 0) {
                str = (str2 + dte.a(4) + dte.a(4)) + dte.c(j2);
            } else {
                str = str2;
            }
        }
        return dte.a(str);
    }

    public static byte[] b(int i) {
        return dte.a(((("" + dte.a(129)) + dte.a(4)) + dte.a(2)) + dte.a(2) + dte.b(i));
    }

    public static byte[] d(List<lfd> list) {
        StringBuffer stringBuffer = new StringBuffer(16);
        int i = 0;
        for (lfd lfdVar : list) {
            stringBuffer.append(dte.a(2));
            stringBuffer.append(dte.a(5));
            stringBuffer.append(dte.a(lfdVar.e()));
            stringBuffer.append(dte.a(lfdVar.a()));
            stringBuffer.append(dte.b(lfdVar.d()));
            stringBuffer.append(dte.a(lfdVar.b()));
            i += 7;
        }
        return dte.a(dte.a(129) + dte.a(i) + stringBuffer.toString());
    }

    public static byte[] e() {
        return dte.a(dte.a(1) + dte.a(1) + dte.a(1));
    }
}
