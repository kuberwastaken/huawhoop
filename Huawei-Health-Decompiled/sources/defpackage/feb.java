package defpackage;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes4.dex */
public class feb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12929a;
    private final int d;
    private final Drawable e;

    public feb(String str, Drawable drawable, int i) {
        this.f12929a = str;
        this.e = drawable;
        this.d = i;
    }

    public String c() {
        return this.f12929a;
    }

    public Drawable ajB_() {
        return this.e;
    }

    public int b() {
        return this.d;
    }

    public String toString() {
        return "ActivityStatus{mText='" + this.f12929a + "', mColorDrawable=" + this.e + ", mVisibility=" + this.d + '}';
    }
}
