package defpackage;

import android.os.Bundle;
import android.view.View;
import com.huawei.operation.OpAnalyticsConstants;

/* JADX INFO: loaded from: classes7.dex */
public class pwz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f16933a;
    private int b;
    private boolean c;
    private boolean d;
    private String e;
    private int f;
    private View.OnClickListener g;
    private int h;
    private String i;
    private int j;
    private String k;

    public pwz(int i) {
        this.b = -1;
        this.f16933a = null;
        this.k = null;
        this.f = -1;
        this.h = -1;
        this.d = false;
        this.i = "";
        this.c = false;
        this.g = null;
        this.j = i;
    }

    public pwz(int i, String str, String str2, int i2) {
        this.b = -1;
        this.f16933a = null;
        this.k = null;
        this.f = -1;
        this.h = -1;
        this.d = false;
        this.j = -1;
        this.i = "";
        this.c = false;
        this.g = null;
        this.b = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
        this.f16933a = (String) kqt.e(str);
        this.k = (String) kqt.e(str2);
        this.h = ((Integer) kqt.e(Integer.valueOf(i2))).intValue();
    }

    public pwz(int i, String str, String str2, boolean z, String str3) {
        this.b = -1;
        this.f16933a = null;
        this.k = null;
        this.f = -1;
        this.h = -1;
        this.d = false;
        this.j = -1;
        this.i = "";
        this.c = false;
        this.g = null;
        this.b = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
        this.f16933a = (String) kqt.e(str);
        this.k = (String) kqt.e(str2);
        this.d = ((Boolean) kqt.e(Boolean.valueOf(z))).booleanValue();
        this.e = (String) kqt.e(str3);
    }

    public boolean l() {
        return this.c;
    }

    public void b(boolean z) {
        this.c = z;
    }

    public String g() {
        return this.i;
    }

    public void c(String str) {
        this.i = str;
    }

    public int a() {
        return ((Integer) kqt.e(Integer.valueOf(this.j))).intValue();
    }

    public void d(int i) {
        this.j = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public boolean f() {
        return ((Boolean) kqt.e(Boolean.valueOf(this.d))).booleanValue();
    }

    public String d() {
        return (String) kqt.e(this.e);
    }

    public int b() {
        return ((Integer) kqt.e(Integer.valueOf(this.b))).intValue();
    }

    public String c() {
        return (String) kqt.e(this.f16933a);
    }

    public String h() {
        return (String) kqt.e(this.k);
    }

    public int j() {
        return ((Integer) kqt.e(Integer.valueOf(this.h))).intValue();
    }

    public View.OnClickListener dho_() {
        return (View.OnClickListener) kqt.e(this.g);
    }

    public void dhp_(View.OnClickListener onClickListener) {
        this.g = (View.OnClickListener) kqt.e(onClickListener);
    }

    public String toString() {
        return "SettingMainListItem [mId=" + this.b + ", mContent=" + this.f16933a + ", mSummary=" + this.k + ", mResIdRight=" + this.f + ",mResView=" + this.h + "]";
    }

    public Bundle dhn_() {
        Bundle bundle = new Bundle();
        bundle.putInt(OpAnalyticsConstants.OPERATION_ID, b());
        bundle.putString("mContent", c());
        return bundle;
    }
}
