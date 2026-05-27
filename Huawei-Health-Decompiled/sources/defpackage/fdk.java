package defpackage;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public class fdk extends fdh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f12913a;
    private boolean b = true;
    private CharSequence c;
    private String d;
    private View.OnClickListener e;
    private String f;
    private int i;

    public fdk() {
    }

    public fdk(String str, CharSequence charSequence, String str2, int i, int i2, View.OnClickListener onClickListener) {
        this.d = str;
        this.c = charSequence;
        this.f = str2;
        this.i = i;
        this.f12913a = i2;
        this.e = onClickListener;
    }

    public fdk a(int i) {
        super.c(i);
        return this;
    }

    public String d() {
        return this.d;
    }

    public CharSequence e() {
        return this.c;
    }

    public String i() {
        return this.f;
    }

    public int h() {
        return this.i;
    }

    public int j() {
        return this.f12913a;
    }

    public View.OnClickListener ajj_() {
        return this.e;
    }

    public boolean f() {
        return !TextUtils.isEmpty(this.d);
    }

    public boolean g() {
        return this.b;
    }

    public void b(boolean z) {
        this.b = z;
    }

    public void ajk_(SpannableString spannableString) {
        this.c = spannableString;
    }
}
