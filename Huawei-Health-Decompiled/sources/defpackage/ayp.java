package defpackage;

import android.content.res.ColorStateList;
import android.graphics.Shader;

/* JADX INFO: loaded from: classes10.dex */
public final class ayp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Shader f382a;
    private int b;
    private final ColorStateList c;

    private ayp(Shader shader, ColorStateList colorStateList, int i) {
        this.f382a = shader;
        this.c = colorStateList;
        this.b = i;
    }

    static ayp e(int i) {
        return new ayp(null, null, i);
    }

    public Shader hw_() {
        return this.f382a;
    }

    public void hx_(Shader shader) {
        this.f382a = shader;
    }

    public int a() {
        return this.b;
    }

    public void d(int i) {
        this.b = i;
    }

    public boolean e() {
        return this.f382a != null;
    }

    public boolean d() {
        ColorStateList colorStateList;
        return this.f382a == null && (colorStateList = this.c) != null && colorStateList.isStateful();
    }

    public boolean a(int[] iArr) {
        if (d()) {
            ColorStateList colorStateList = this.c;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.b) {
                this.b = colorForState;
                return true;
            }
        }
        return false;
    }

    public boolean b() {
        return e() || this.b != 0;
    }
}
