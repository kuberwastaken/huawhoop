package com.huawei.hms.scankit.p;

import com.huawei.phoneservice.faq.base.constants.TrackConstants$Events;

/* JADX INFO: loaded from: classes5.dex */
class d0 implements v2 {
    public int a() {
        return 1;
    }

    private int a(y2 y2Var, StringBuilder sb, StringBuilder sb2, int i) {
        int length = sb.length();
        sb.delete(length - i, length);
        y2Var.d--;
        int iA = a(y2Var.c(), sb2);
        y2Var.k();
        return iA;
    }

    static void b(y2 y2Var, StringBuilder sb) {
        y2Var.a(a(sb, 0));
        sb.delete(0, 3);
    }

    int a(char c, StringBuilder sb) {
        if (c == ' ') {
            sb.append((char) 3);
            return 1;
        }
        if (c >= '0' && c <= '9') {
            sb.append((char) (c - ','));
            return 1;
        }
        if (c >= 'A' && c <= 'Z') {
            sb.append((char) (c - '3'));
            return 1;
        }
        if (c < ' ') {
            sb.append((char) 0);
            sb.append(c);
            return 2;
        }
        if (c >= '!' && c <= '/') {
            sb.append((char) 1);
            sb.append((char) (c - '!'));
            return 2;
        }
        if (c >= ':' && c <= '@') {
            sb.append((char) 1);
            sb.append((char) (c - '+'));
            return 2;
        }
        if (c >= '[' && c <= '_') {
            sb.append((char) 1);
            sb.append((char) (c - 'E'));
            return 2;
        }
        if (c >= '`' && c <= 127) {
            sb.append((char) 2);
            sb.append((char) (c - '`'));
            return 2;
        }
        sb.append("\u0001\u001e");
        return a((char) (c - 128), sb) + 2;
    }

    private static String a(CharSequence charSequence, int i) {
        int iCharAt = (charSequence.charAt(i) * 1600) + (charSequence.charAt(i + 1) * com.huawei.hms.network.embedded.g4.k) + charSequence.charAt(i + 2) + 1;
        return new String(new char[]{(char) (iCharAt / 256), (char) (iCharAt % 256)});
    }

    void a(y2 y2Var, StringBuilder sb) {
        int length = sb.length() / 3;
        int length2 = sb.length() % 3;
        int iA = y2Var.a() + (length * 2);
        y2Var.c(iA);
        int iA2 = y2Var.g().a() - iA;
        if (length2 == 2) {
            sb.append((char) 0);
            while (sb.length() >= 3) {
                b(y2Var, sb);
            }
            if (y2Var.i()) {
                y2Var.a((char) 254);
            }
        } else if (iA2 == 1 && length2 == 1) {
            while (sb.length() >= 3) {
                b(y2Var, sb);
            }
            if (y2Var.i()) {
                y2Var.a((char) 254);
            }
            y2Var.d--;
        } else if (length2 == 0) {
            while (sb.length() >= 3) {
                b(y2Var, sb);
            }
            if (iA2 > 0 || y2Var.i()) {
                y2Var.a((char) 254);
            }
        } else {
            try {
                throw new IllegalStateException("Unexpected case. Please report!");
            } catch (Exception unused) {
                o4.b(TrackConstants$Events.EXCEPTION, "Exception");
            }
        }
        y2Var.b(0);
    }

    @Override // com.huawei.hms.scankit.p.v2
    public void a(y2 y2Var) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!y2Var.i()) {
                break;
            }
            char c = y2Var.c();
            y2Var.d++;
            int iA = a(c, sb);
            int iA2 = y2Var.a() + ((sb.length() / 3) * 2);
            y2Var.c(iA2);
            int iA3 = y2Var.g().a() - iA2;
            if (!y2Var.i()) {
                StringBuilder sb2 = new StringBuilder();
                if (sb.length() % 3 == 2 && (iA3 < 2 || iA3 > 2)) {
                    iA = a(y2Var, sb, sb2, iA);
                }
                while (sb.length() % 3 == 1 && ((iA <= 3 && iA3 != 1) || iA > 3)) {
                    iA = a(y2Var, sb, sb2, iA);
                }
            } else if (sb.length() % 3 == 0 && d4.a(y2Var.d(), y2Var.d, a()) != a()) {
                y2Var.b(0);
                break;
            }
        }
        a(y2Var, sb);
    }

    d0() {
    }
}
