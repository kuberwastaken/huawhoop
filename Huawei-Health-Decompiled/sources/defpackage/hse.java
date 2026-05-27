package defpackage;

import com.huawei.health.trusport_ee_jni.trusport_eeJNI;

/* JADX INFO: loaded from: classes5.dex */
public final class hse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f13954a;
    public static final hse b;
    private static hse[] c;
    public static final hse d;
    public static final hse e;
    private final String h;
    private final int j;

    static {
        hse hseVar = new hse("TRUSPORT_EE_SEX_MALE", trusport_eeJNI.TRUSPORT_EE_SEX_MALE_get());
        d = hseVar;
        hse hseVar2 = new hse("TRUSPORT_EE_SEX_FEMALE");
        b = hseVar2;
        hse hseVar3 = new hse("TRUSPORT_EE_SEX_UNKNOWN");
        e = hseVar3;
        c = new hse[]{hseVar, hseVar2, hseVar3};
        f13954a = 0;
    }

    public final int e() {
        return this.j;
    }

    public String toString() {
        return this.h;
    }

    private hse(String str) {
        this.h = str;
        int i = f13954a;
        f13954a = i + 1;
        this.j = i;
    }

    private hse(String str, int i) {
        this.h = str;
        this.j = i;
        f13954a = i + 1;
    }
}
