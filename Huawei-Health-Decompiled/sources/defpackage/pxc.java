package defpackage;

import android.widget.CompoundButton;

/* JADX INFO: loaded from: classes7.dex */
public class pxc {
    private int e = -1;
    private int c = 0;
    private int g = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f16934a = null;
    private String f = null;
    private String h = null;
    private boolean d = false;
    private CompoundButton.OnCheckedChangeListener j = null;
    private boolean i = false;
    private boolean b = true;

    public void c(int i) {
        this.e = i;
    }

    public int d() {
        return this.e;
    }

    public void b(String str) {
        this.f16934a = str;
    }

    public String e() {
        return this.f16934a;
    }

    public void a(String str) {
        this.f = str;
    }

    public String f() {
        return this.f;
    }

    public void c(String str) {
        this.h = str;
    }

    public String c() {
        return this.h;
    }

    public void b(int i) {
        this.g = i;
    }

    public int g() {
        return this.g;
    }

    public void d(boolean z) {
        this.d = z;
    }

    public boolean j() {
        return this.d;
    }

    public boolean h() {
        return this.i;
    }

    public void dhK_(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.j = onCheckedChangeListener;
    }

    public CompoundButton.OnCheckedChangeListener dhJ_() {
        return this.j;
    }

    public void d(int i) {
        this.c = i;
    }

    public int b() {
        return this.c;
    }

    public void b(boolean z) {
        this.b = z;
    }

    public boolean i() {
        return this.b;
    }

    public String toString() {
        return "DeviceSettingFactoryListItem [mId=" + this.e + ", mContent=" + this.f16934a + ", mSubContent=" + this.f + ", mIsChecked=" + this.d + ", mType=" + this.g + "]";
    }
}
