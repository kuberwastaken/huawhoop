package defpackage;

import android.util.Log;
import com.huawei.openalliance.ad.constant.VastAttribute;

/* JADX INFO: loaded from: classes11.dex */
public class vnt {

    static class d {
        int b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f18680a = false;
        boolean e = false;
        boolean d = false;

        d() {
        }
    }

    static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f18681a;
        boolean c;
        boolean d;

        e() {
        }
    }

    private static void a(char c, char[] cArr, e eVar, d dVar) {
        int i = dVar.b;
        if (i >= 3 || i < 0) {
            return;
        }
        if (c == 'd' && !dVar.f18680a) {
            dVar.b = i + 1;
            cArr[i] = 'd';
            dVar.f18680a = true;
        } else if (eVar.c && !dVar.e) {
            dVar.b = i + 1;
            cArr[i] = 'M';
            dVar.e = true;
        } else {
            if (c != 'y' || dVar.d) {
                Log.e("ICU", VastAttribute.ERROR);
                return;
            }
            dVar.b = i + 1;
            cArr[i] = 'y';
            dVar.d = true;
        }
    }

    public static char[] c(String str) {
        char[] cArr = new char[3];
        if (str == null) {
            Log.w("ICU", "getDateFormatOrder method: parms pattern is null");
            return cArr;
        }
        d dVar = new d();
        int length = str.length();
        int iIndexOf = 0;
        while (iIndexOf < length) {
            char cCharAt = str.charAt(iIndexOf);
            e eVarC = c(cCharAt);
            if (eVarC.d) {
                a(cCharAt, cArr, eVarC, dVar);
            } else if (cCharAt == 'G') {
                Log.w("TAG", "ignore");
            } else {
                if (eVarC.f18681a) {
                    Log.w("ICU", "Bad pattern character '" + cCharAt + "' in " + str);
                    return cArr;
                }
                if (cCharAt == '\'') {
                    if (iIndexOf >= str.length() - 1 || str.charAt(iIndexOf + 1) != '\'') {
                        iIndexOf = str.indexOf(39, iIndexOf + 1);
                    }
                    if (iIndexOf == -1) {
                        Log.w("ICU", "Bad quoting in " + str);
                        return cArr;
                    }
                    iIndexOf++;
                } else {
                    Log.w("TAG", "ignore");
                }
            }
            iIndexOf++;
        }
        return cArr;
    }

    private static e c(char c) {
        boolean z = true;
        boolean z2 = c == 'd' || c == 'L' || c == 'M' || c == 'y';
        boolean z3 = c == 'L' || c == 'M';
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
            z = false;
        }
        e eVar = new e();
        eVar.d = z2;
        eVar.c = z3;
        eVar.f18681a = z;
        return eVar;
    }
}
