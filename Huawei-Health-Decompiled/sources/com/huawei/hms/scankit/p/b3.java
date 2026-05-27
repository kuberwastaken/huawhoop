package com.huawei.hms.scankit.p;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v0 com.huawei.hms.scankit.p.b3, still in use, count: 1, list:
  (r0v0 com.huawei.hms.scankit.p.b3) from 0x002e: FILLED_NEW_ARRAY 
  (r1v1 com.huawei.hms.scankit.p.b3)
  (r0v0 com.huawei.hms.scankit.p.b3)
  (r3v2 com.huawei.hms.scankit.p.b3)
  (r2v1 com.huawei.hms.scankit.p.b3)
 A[WRAPPED] elemType: com.huawei.hms.scankit.p.b3
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:252)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:180)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes5.dex */
public final class b3 {
    L(1),
    M(0),
    Q(3),
    H(2);

    private static final b3[] f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f5930a;

    static {
        f = new b3[]{b3Var, new b3(1), b3Var, new b3(3)};
    }

    public static b3 valueOf(String str) {
        return (b3) Enum.valueOf(b3.class, str);
    }

    public static b3[] values() {
        return (b3[]) g.clone();
    }

    private b3(int i) {
        this.f5930a = i;
    }

    public int b() {
        return this.f5930a;
    }

    public static b3 a(int i) {
        if (i >= 0) {
            b3[] b3VarArr = f;
            if (i < b3VarArr.length) {
                return b3VarArr[i];
            }
        }
        throw new IllegalArgumentException();
    }
}
