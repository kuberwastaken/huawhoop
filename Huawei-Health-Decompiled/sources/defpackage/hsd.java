package defpackage;

import com.huawei.health.trusport_ee_jni.trusport_eeJNI;

/* JADX INFO: loaded from: classes5.dex */
public final class hsd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f13953a;
    public static final hsd b;
    private static hsd[] c;
    public static final hsd d;
    public static final hsd e;
    private final int g;
    private final String h;

    static {
        hsd hsdVar = new hsd("TRUSPORT_EE_INTENSITY_LOW", trusport_eeJNI.TRUSPORT_EE_INTENSITY_LOW_get());
        b = hsdVar;
        hsd hsdVar2 = new hsd("TRUSPORT_EE_INTENSITY_MEDIUM");
        d = hsdVar2;
        hsd hsdVar3 = new hsd("TRUSPORT_EE_INTENSITY_HIGH");
        e = hsdVar3;
        c = new hsd[]{hsdVar, hsdVar2, hsdVar3};
        f13953a = 0;
    }

    public final int d() {
        return this.g;
    }

    public String toString() {
        return this.h;
    }

    private hsd(String str) {
        this.h = str;
        int i = f13953a;
        f13953a = i + 1;
        this.g = i;
    }

    private hsd(String str, int i) {
        this.h = str;
        this.g = i;
        f13953a = i + 1;
    }
}
