package defpackage;

import android.text.TextUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public class law {
    private String b;
    private String d;
    private String e;

    public String b() {
        return this.e;
    }

    public void b(String str) {
        this.e = str;
    }

    public void e(String str) {
        this.b = str;
    }

    public String d() {
        return this.b;
    }

    public String a() {
        return this.d;
    }

    public void c(String str) {
        this.d = str;
    }

    public String c() {
        if (TextUtils.isEmpty(this.d) || this.d.length() <= 42) {
            return null;
        }
        return (this.d.substring(0, 4) + this.d.substring(20, 36)).toUpperCase(Locale.getDefault());
    }
}
