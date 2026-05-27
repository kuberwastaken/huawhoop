package defpackage;

import com.huawei.health.trusport_ee_jni.trusport_eeJNI;

/* JADX INFO: loaded from: classes5.dex */
public final class hsg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final hsg f13955a;
    public static final hsg b;
    public static final hsg c;
    public static final hsg d;
    public static final hsg e;
    public static final hsg f;
    public static final hsg g;
    public static final hsg h;
    public static final hsg i;
    public static final hsg j;
    public static final hsg k;
    public static final hsg l;
    public static final hsg m;
    public static final hsg n;
    public static final hsg o;
    public static final hsg p;
    public static final hsg q;
    public static final hsg r;
    public static final hsg s;
    public static final hsg t;
    public static final hsg u;
    public static final hsg v;
    public static final hsg w;
    public static final hsg x;
    private static int y;
    private static hsg[] z;
    private final String ab;
    private final int ac;

    static {
        hsg hsgVar = new hsg("TRUSPORT_EE_ERROR_OK", trusport_eeJNI.TRUSPORT_EE_ERROR_OK_get());
        x = hsgVar;
        hsg hsgVar2 = new hsg("TRUSPORT_EE_ERROR_NULL_POINTER");
        u = hsgVar2;
        hsg hsgVar3 = new hsg("TRUSPORT_EE_ERROR_BUFFER_OVERFLOW");
        f13955a = hsgVar3;
        hsg hsgVar4 = new hsg("TRUSPORT_EE_ERROR_DATA_SIZE_MISMATCH");
        d = hsgVar4;
        hsg hsgVar5 = new hsg("TRUSPORT_EE_ERROR_DATA_NOT_AVAILABLE");
        e = hsgVar5;
        hsg hsgVar6 = new hsg("TRUSPORT_EE_ERROR_INVALID_HR");
        n = hsgVar6;
        hsg hsgVar7 = new hsg("TRUSPORT_EE_ERROR_INVALID_SPEED");
        l = hsgVar7;
        hsg hsgVar8 = new hsg("TRUSPORT_EE_ERROR_INVALID_SR");
        m = hsgVar8;
        hsg hsgVar9 = new hsg("TRUSPORT_EE_ERROR_INVALID_AGE");
        i = hsgVar9;
        hsg hsgVar10 = new hsg("TRUSPORT_EE_ERROR_INVALID_HEIGHT");
        k = hsgVar10;
        hsg hsgVar11 = new hsg("TRUSPORT_EE_ERROR_INVALID_WEIGHT");
        v = hsgVar11;
        hsg hsgVar12 = new hsg("TRUSPORT_EE_ERROR_INVALID_ACTIVITY_CLASS");
        g = hsgVar12;
        hsg hsgVar13 = new hsg("TRUSPORT_EE_ERROR_INVALID_VO2MAX");
        r = hsgVar13;
        hsg hsgVar14 = new hsg("TRUSPORT_EE_ERROR_INVALID_STEP_LENGTH");
        q = hsgVar14;
        hsg hsgVar15 = new hsg("TRUSPORT_EE_ERROR_INVALID_TIMESTAMP");
        s = hsgVar15;
        hsg hsgVar16 = new hsg("TRUSPORT_EE_ERROR_INVALID_ACTION");
        f = hsgVar16;
        hsg hsgVar17 = new hsg("TRUSPORT_EE_ERROR_INVALID_VERBOSITY");
        t = hsgVar17;
        hsg hsgVar18 = new hsg("TRUSPORT_EE_ERROR_INVALID_EE");
        o = hsgVar18;
        hsg hsgVar19 = new hsg("TRUSPORT_EE_ERROR_INVALID_SWOLF");
        p = hsgVar19;
        hsg hsgVar20 = new hsg("TRUSPORT_EE_ERROR_INVALID_DISTANCE");
        j = hsgVar20;
        hsg hsgVar21 = new hsg("TRUSPORT_EE_ERROR_INVALID_DURATION");
        h = hsgVar21;
        hsg hsgVar22 = new hsg("TRUSPORT_EE_ERROR_CORRUPTED_DATA");
        c = hsgVar22;
        hsg hsgVar23 = new hsg("TRUSPORT_EE_ERROR_INCOMPATIBLE_COMMON");
        b = hsgVar23;
        hsg hsgVar24 = new hsg("TRUSPORT_EE_ERROR_UNKNOWN_ERROR");
        w = hsgVar24;
        z = new hsg[]{hsgVar, hsgVar2, hsgVar3, hsgVar4, hsgVar5, hsgVar6, hsgVar7, hsgVar8, hsgVar9, hsgVar10, hsgVar11, hsgVar12, hsgVar13, hsgVar14, hsgVar15, hsgVar16, hsgVar17, hsgVar18, hsgVar19, hsgVar20, hsgVar21, hsgVar22, hsgVar23, hsgVar24};
        y = 0;
    }

    public String toString() {
        return this.ab;
    }

    public static hsg a(int i2) {
        hsg[] hsgVarArr = z;
        if (i2 < hsgVarArr.length && i2 >= 0) {
            hsg hsgVar = hsgVarArr[i2];
            if (hsgVar.ac == i2) {
                return hsgVar;
            }
        }
        int i3 = 0;
        while (true) {
            hsg[] hsgVarArr2 = z;
            if (i3 < hsgVarArr2.length) {
                hsg hsgVar2 = hsgVarArr2[i3];
                if (hsgVar2.ac == i2) {
                    return hsgVar2;
                }
                i3++;
            } else {
                throw new IllegalArgumentException("No enum " + hsg.class + " with value " + i2);
            }
        }
    }

    private hsg(String str) {
        this.ab = str;
        int i2 = y;
        y = i2 + 1;
        this.ac = i2;
    }

    private hsg(String str, int i2) {
        this.ab = str;
        this.ac = i2;
        y = i2 + 1;
    }
}
