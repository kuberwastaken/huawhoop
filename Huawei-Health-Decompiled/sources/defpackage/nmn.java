package defpackage;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes11.dex */
public class nmn {
    public nmr c(String str) throws nmp {
        nmr nmrVar = new nmr();
        if (TextUtils.isEmpty(str)) {
            return nmrVar;
        }
        int iE = 0;
        while (iE != str.length()) {
            try {
                String strSubstring = str.substring(iE, iE + 2);
                a aVarA = a(str, iE + strSubstring.length());
                int iB = aVarA.b();
                iE = aVarA.e();
                if (iB == 0) {
                    nmrVar.c().add(new nmo(strSubstring, iB, ""));
                } else {
                    int i = (iB * 2) + iE;
                    if (i > str.length()) {
                        throw new nmp();
                    }
                    String strSubstring2 = str.substring(iE, i);
                    iE += strSubstring2.length();
                    if ((Integer.parseInt(strSubstring, 16) >>> 7) == 1) {
                        nmrVar.e().add(c(strSubstring2));
                    } else {
                        nmrVar.c().add(new nmo(strSubstring, iB, strSubstring2));
                    }
                }
            } catch (IndexOutOfBoundsException | NumberFormatException unused) {
                throw new nmp();
            }
        }
        return nmrVar;
    }

    private a a(String str, int i) throws nmp {
        int i2;
        try {
            int i3 = Integer.parseInt(str.substring(i, i + 2), 16);
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (((i3 >>> 7) & 1) == 1) {
                if (i4 >= 4) {
                    throw new nmp();
                }
                int i7 = i + 2;
                int i8 = i3 & 127;
                if (i4 == 0) {
                    i5 = i8;
                } else if (i4 == 1) {
                    i6 = i8;
                }
                i3 = Integer.parseInt(str.substring(i7, i + 4), 16);
                i4++;
                i = i7;
            }
            if (i4 != 2) {
                if (i4 == 1) {
                    i2 = i5 * 128;
                }
                return new a(i3, i + 2);
            }
            i2 = (i5 * 16384) + (i6 * 128);
            i3 += i2;
            return new a(i3, i + 2);
        } catch (IndexOutOfBoundsException | NumberFormatException unused) {
            throw new nmp();
        }
    }

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f16038a;
        private int b;

        private a(int i, int i2) {
            this.b = i;
            this.f16038a = i2;
        }

        public int b() {
            return this.b;
        }

        public int e() {
            return this.f16038a;
        }
    }
}
