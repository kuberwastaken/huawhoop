package defpackage;

import android.graphics.Typeface;

/* JADX INFO: loaded from: classes3.dex */
public class fo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f13049a;
    private final float b;
    private final String c;
    private Typeface d;
    private final String e;

    public fo(String str, String str2, String str3, float f) {
        this.f13049a = str;
        this.e = str2;
        this.c = str3;
        this.b = f;
    }

    public String a() {
        return this.f13049a;
    }

    public String c() {
        return this.e;
    }

    public String b() {
        return this.c;
    }

    public Typeface ah_() {
        return this.d;
    }

    public void ai_(Typeface typeface) {
        this.d = typeface;
    }
}
