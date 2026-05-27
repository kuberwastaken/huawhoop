package defpackage;

import android.text.TextUtils;
import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public class fdl extends fdh {
    private View.OnClickListener b;
    private int c;
    private String d;
    private String e;

    public fdl() {
    }

    public fdl(String str, String str2, int i, View.OnClickListener onClickListener) {
        this.e = str;
        this.d = str2;
        this.c = i;
        this.b = onClickListener;
    }

    public fdl a(int i) {
        super.c(i);
        return this;
    }

    public void d(String str) {
        this.d = str;
    }

    public String b() {
        return this.e;
    }

    public String j() {
        return this.d;
    }

    public int e() {
        return this.c;
    }

    public View.OnClickListener ajl_() {
        return this.b;
    }

    public boolean h() {
        return !TextUtils.isEmpty(this.e);
    }
}
