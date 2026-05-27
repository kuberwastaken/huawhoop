package defpackage;

import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public class fdj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Drawable f12912a;
    private String b;
    private String c;
    private String d;
    private View.OnClickListener e;
    private String g;
    private feb h;

    public fdj(String str, String str2, Drawable drawable, feb febVar, String str3, View.OnClickListener onClickListener) {
        this.g = str;
        this.b = str2;
        this.f12912a = drawable;
        this.h = febVar;
        this.c = str3;
        this.e = onClickListener;
    }

    public fdj(String str, String str2, feb febVar, String str3, View.OnClickListener onClickListener, String str4) {
        this.g = str;
        this.b = str2;
        this.h = febVar;
        this.c = str3;
        this.e = onClickListener;
        this.d = str4;
    }

    public String d() {
        return this.d;
    }

    public String c() {
        return this.g;
    }

    public String e() {
        return this.b;
    }

    public feb j() {
        return this.h;
    }

    public String b() {
        return this.c;
    }

    public View.OnClickListener ajn_() {
        return this.e;
    }

    public String toString() {
        return "Section16_9Card_01_BannerItem{mTitle='" + this.g + "', mDesc='" + this.b + "', mTopRightStatus=" + this.h + ", mBottomRightText='" + this.c + "', mOnClickListener=" + this.e + '}';
    }
}
