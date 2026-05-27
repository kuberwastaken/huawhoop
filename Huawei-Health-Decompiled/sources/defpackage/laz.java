package defpackage;

import android.text.TextUtils;
import com.huawei.hwlogsmodel.LogUtil;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public class laz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15053a;
    private String b = "";
    private String c;
    private String d;
    private int e;

    public int c() {
        return this.e;
    }

    public void b(int i) {
        this.e = i;
    }

    public String a() {
        return this.c;
    }

    public void e(String str) {
        this.c = str;
    }

    public String d() {
        return this.d;
    }

    public void b(String str) {
        this.d = str;
    }

    public String e() {
        return this.f15053a;
    }

    public void b(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            LogUtil.j("ApduCommand", "setChecker checkers is null or length is 0");
            this.f15053a = null;
            return;
        }
        StringBuilder sb = new StringBuilder(16);
        for (int i = 0; i < strArr.length; i++) {
            sb.append(strArr[i].toUpperCase(Locale.getDefault()));
            if (i != strArr.length - 1) {
                sb.append("|");
            }
        }
        this.f15053a = sb.toString();
    }

    public String b() {
        return this.b;
    }

    public void d(String str) {
        this.b = str;
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 4) {
            LogUtil.j("ApduCommand", "setChecker responseString length is 0 or less SW_LENGTH");
            this.d = str;
        } else {
            this.d = str.substring(0, str.length() - 4);
            this.b = str.substring(str.length() - 4, str.length());
        }
    }

    public String toString() {
        return "ApduCommand{index=" + this.e + ", apdu='" + this.c + "', rapdu='" + this.d + "', checker='" + this.f15053a + "', sw='" + this.b + "'}";
    }
}
