package defpackage;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes3.dex */
public class ec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Bitmap f12531a;
    private final int b;
    private final String c;
    private final String d;
    private final String e;
    private final int f;

    public ec(int i, int i2, String str, String str2, String str3) {
        this.f = i;
        this.b = i2;
        this.c = str;
        this.d = str2;
        this.e = str3;
    }

    public int a() {
        return this.f;
    }

    public int e() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public Bitmap F_() {
        return this.f12531a;
    }

    public void G_(Bitmap bitmap) {
        this.f12531a = bitmap;
    }

    public ec e(float f) {
        ec ecVar = new ec((int) (this.f * f), (int) (this.b * f), this.c, this.d, this.e);
        Bitmap bitmap = this.f12531a;
        if (bitmap != null) {
            ecVar.G_(Bitmap.createScaledBitmap(bitmap, ecVar.f, ecVar.b, true));
        }
        return ecVar;
    }
}
