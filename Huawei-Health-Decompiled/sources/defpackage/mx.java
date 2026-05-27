package defpackage;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes9.dex */
public class mx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f15910a;
    public Boolean d;

    public boolean b() {
        Boolean bool = this.d;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public void e(String str) {
        this.f15910a = str;
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(this.f15910a, str);
    }

    public boolean c() {
        return this.d != null;
    }

    public void d(boolean z) {
        this.d = Boolean.valueOf(z);
    }
}
