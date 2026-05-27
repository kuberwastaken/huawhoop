package defpackage;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class arc {
    private static final arb b = arb.d();
    private static arc d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Integer, Integer> f277a = Collections.synchronizedMap(new HashMap());
    private int e = -1;

    public int a() {
        return 13;
    }

    public static arc b() {
        arc arcVar;
        synchronized (arc.class) {
            if (d == null) {
                d = new arc();
            }
            arcVar = d;
        }
        return arcVar;
    }

    public void e(int i) {
        b.e("SdkVersionManager", "recordServerVersion serverVersion: " + i);
        this.e = i;
    }

    private boolean d() {
        return this.e != -1;
    }

    public boolean c(int i, int i2) {
        if (i2 <= 8) {
            return true;
        }
        b.e("SdkVersionManager", "bothVersionGreaterThanTargetVersion pid: " + i + ", targetVersion: " + i2);
        return d() ? Math.min(this.e, a()) >= i2 : this.f277a.containsKey(Integer.valueOf(i)) && Math.min(this.f277a.get(Integer.valueOf(i)).intValue(), a()) >= i2;
    }
}
