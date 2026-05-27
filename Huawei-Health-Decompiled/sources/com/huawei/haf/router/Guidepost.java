package com.huawei.haf.router;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.haf.application.BaseApplication;
import com.huawei.haf.router.core.AppRouterHelper;
import com.huawei.haf.router.core.AppRouterPostcard;
import com.huawei.openalliance.ad.constant.ParamConstants;
import com.huawei.operation.ble.BleConstants;

/* JADX INFO: loaded from: classes.dex */
public final class Guidepost extends AppRouterPostcard {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bundle f2173a;
    private int b;
    private int c;
    private String d;
    private Context e;
    private int f;
    private Bundle h;

    public Guidepost(String str, String str2, Uri uri) {
        super(str, str2, uri);
        this.f2173a = new Bundle();
        this.c = -1;
        this.b = -1;
    }

    public Object i() {
        return AppRouterHelper.a(a(), this, -1, (NaviCallback) null);
    }

    public Object d(Context context) {
        this.e = context;
        return AppRouterHelper.a(a(), this, -1, (NaviCallback) null);
    }

    public Object c(Context context, NaviCallback naviCallback) {
        this.e = context;
        return AppRouterHelper.a(a(), this, -1, naviCallback);
    }

    public void Bi_(Activity activity, int i) {
        this.e = activity;
        AppRouterHelper.a(a(), this, i, (NaviCallback) null);
    }

    public void Bj_(Activity activity, int i, NaviCallback naviCallback) {
        this.e = activity;
        AppRouterHelper.a(a(), this, i, naviCallback);
    }

    public Guidepost Bk_(Bundle bundle) {
        Bundle bundle2;
        if (bundle != null && !bundle.isEmpty() && bundle != (bundle2 = this.f2173a)) {
            bundle2.putAll(bundle);
        }
        return this;
    }

    public Guidepost b(String str, boolean z) {
        this.f2173a.putBoolean(str, z);
        return this;
    }

    public Guidepost a(String str, byte b) {
        this.f2173a.putByte(str, b);
        return this;
    }

    public Guidepost d(String str, short s) {
        this.f2173a.putShort(str, s);
        return this;
    }

    public Guidepost d(String str, int i) {
        this.f2173a.putInt(str, i);
        return this;
    }

    public Guidepost b(String str, long j) {
        this.f2173a.putLong(str, j);
        return this;
    }

    public Guidepost c(String str, char c) {
        this.f2173a.putChar(str, c);
        return this;
    }

    public Guidepost e(String str, float f) {
        this.f2173a.putFloat(str, f);
        return this;
    }

    public Guidepost b(String str, double d) {
        this.f2173a.putDouble(str, d);
        return this;
    }

    public Guidepost c(String str, String str2) {
        this.f2173a.putString(str, str2);
        return this;
    }

    public Guidepost Bl_(String str, Parcelable parcelable) {
        this.f2173a.putParcelable(str, parcelable);
        return this;
    }

    public Guidepost b(int i, int i2) {
        this.c = i;
        this.b = i2;
        return this;
    }

    public Guidepost d(String str) {
        this.d = str;
        return this;
    }

    public Guidepost e(int i) {
        this.f = i;
        return this;
    }

    public Guidepost c(int i) {
        this.f = i | this.f;
        return this;
    }

    public int h() {
        return this.f;
    }

    public int b() {
        return this.c;
    }

    public int e() {
        return this.b;
    }

    public String c() {
        return this.d;
    }

    public Bundle Bh_() {
        return this.h;
    }

    public Bundle Bg_() {
        return this.f2173a;
    }

    public Context a() {
        if (this.e == null) {
            this.e = BaseApplication.xE_();
        }
        Context context = this.e;
        return context == null ? BaseApplication.a() : context;
    }

    static Bundle Bf_(Guidepost guidepost) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("uri", guidepost.Bs_());
        bundle.putString(BleConstants.KEY_PATH, guidepost.m());
        Bd_(bundle, guidepost);
        return bundle;
    }

    static Guidepost Bc_(Bundle bundle) {
        bundle.setClassLoader(BaseApplication.a().getClassLoader());
        Uri uri = (Uri) bundle.getParcelable("uri");
        if (uri != null) {
            Guidepost guidepostBp_ = AppRouterHelper.Bp_(uri);
            Be_(guidepostBp_, bundle);
            return guidepostBp_;
        }
        String string = bundle.getString(BleConstants.KEY_PATH);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        Guidepost guidepostA = AppRouterHelper.a(string);
        Be_(guidepostA, bundle);
        return guidepostA;
    }

    private static void Bd_(Bundle bundle, Guidepost guidepost) {
        bundle.putBundle("bundle", guidepost.Bg_());
        bundle.putInt(ParamConstants.Param.FLAGS, guidepost.h());
        bundle.putInt("enterAnim", guidepost.b());
        bundle.putInt("exitAnim", guidepost.e());
        bundle.putString("action", guidepost.c());
        Bundle bundleBh_ = guidepost.Bh_();
        if (bundleBh_ != null) {
            bundle.putBundle("optionBundle", bundleBh_);
        }
    }

    private static void Be_(Guidepost guidepost, Bundle bundle) {
        guidepost.Bk_(bundle.getBundle("bundle"));
        guidepost.e(bundle.getInt(ParamConstants.Param.FLAGS));
        guidepost.b(bundle.getInt("enterAnim"), bundle.getInt("exitAnim"));
        guidepost.d(bundle.getString("action"));
        Bundle bundle2 = bundle.getBundle("optionBundle");
        if (bundle2 != null) {
            guidepost.h = bundle2;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("Guidepost{");
        if (Bs_() != null) {
            sb.append("uri=");
            sb.append(Bs_());
        } else {
            sb.append("path=");
            sb.append(m());
        }
        if (!this.f2173a.isEmpty()) {
            sb.append(", extras=");
            sb.append(this.f2173a);
        }
        if (this.f != 0) {
            sb.append(", flags=");
            sb.append(this.f);
        }
        if (f() != 0) {
            sb.append(", extra=");
            sb.append(f());
        }
        if (this.c != 0) {
            sb.append(", enterAnim=");
            sb.append(this.c);
        }
        if (this.b != 0) {
            sb.append(", exitAnim=");
            sb.append(this.b);
        }
        if (!TextUtils.isEmpty(this.d)) {
            sb.append(", action=");
            sb.append(this.d);
        }
        if (k() != null) {
            sb.append(", provider=");
            sb.append(k());
        }
        sb.append("}");
        return sb.toString();
    }
}
