package defpackage;

import com.fasterxml.jackson.core.util.JacksonFeature;

/* JADX INFO: loaded from: classes9.dex */
public final class yh<F extends JacksonFeature> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f19316a;

    protected yh(int i) {
        this.f19316a = i;
    }

    public static <F extends JacksonFeature> yh<F> d(F[] fArr) {
        if (fArr.length > 31) {
            throw new IllegalArgumentException(String.format("Can not use type `%s` with JacksonFeatureSet: too many entries (%d > 31)", fArr[0].getClass().getName(), Integer.valueOf(fArr.length)));
        }
        int mask = 0;
        for (F f : fArr) {
            if (f.enabledByDefault()) {
                mask |= f.getMask();
            }
        }
        return new yh<>(mask);
    }

    public yh<F> d(F f) {
        int mask = f.getMask() | this.f19316a;
        return mask == this.f19316a ? this : new yh<>(mask);
    }

    public boolean a(F f) {
        return (f.getMask() & this.f19316a) != 0;
    }
}
