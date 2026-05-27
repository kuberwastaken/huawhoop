package defpackage;

import java.io.Serializable;

/* JADX INFO: loaded from: classes9.dex */
public class ws implements Serializable {
    public static final ws e = new ws(null, -1, -1, -1, -1);
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final int f18900a;
    protected final long b;
    final transient Object c;
    protected final int d;
    protected final long i;

    public ws(Object obj, long j, int i, int i2) {
        this(obj, -1L, j, i, i2);
    }

    public ws(Object obj, long j, long j2, int i, int i2) {
        this.c = obj;
        this.b = j;
        this.i = j2;
        this.f18900a = i;
        this.d = i2;
    }

    public long a() {
        return this.b;
    }

    public int hashCode() {
        Object obj = this.c;
        return ((((obj == null ? 1 : obj.hashCode()) ^ this.f18900a) + this.d) ^ ((int) this.i)) + ((int) this.b);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof ws)) {
            return false;
        }
        ws wsVar = (ws) obj;
        Object obj2 = this.c;
        if (obj2 == null) {
            if (wsVar.c != null) {
                return false;
            }
        } else if (!obj2.equals(wsVar.c)) {
            return false;
        }
        return this.f18900a == wsVar.f18900a && this.d == wsVar.d && this.i == wsVar.i && a() == wsVar.a();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(80);
        sb.append("[Source: ");
        a(sb);
        sb.append("; line: ");
        sb.append(this.f18900a);
        sb.append(", column: ");
        sb.append(this.d);
        sb.append(']');
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected java.lang.StringBuilder a(java.lang.StringBuilder r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.c
            if (r0 != 0) goto La
            java.lang.String r0 = "UNKNOWN"
            r7.append(r0)
            return r7
        La:
            boolean r1 = r0 instanceof java.lang.Class
            if (r1 == 0) goto L12
            r1 = r0
            java.lang.Class r1 = (java.lang.Class) r1
            goto L16
        L12:
            java.lang.Class r1 = r0.getClass()
        L16:
            java.lang.String r2 = r1.getName()
            java.lang.String r3 = "java."
            boolean r3 = r2.startsWith(r3)
            if (r3 == 0) goto L27
            java.lang.String r2 = r1.getSimpleName()
            goto L34
        L27:
            boolean r1 = r0 instanceof byte[]
            if (r1 == 0) goto L2e
            java.lang.String r2 = "byte[]"
            goto L34
        L2e:
            boolean r1 = r0 instanceof char[]
            if (r1 == 0) goto L34
            java.lang.String r2 = "char[]"
        L34:
            r1 = 40
            r7.append(r1)
            r7.append(r2)
            r1 = 41
            r7.append(r1)
            boolean r1 = r0 instanceof java.lang.CharSequence
            r2 = 500(0x1f4, float:7.0E-43)
            r3 = 0
            java.lang.String r4 = " chars"
            if (r1 == 0) goto L61
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r1 = r0.length()
            int r2 = java.lang.Math.min(r1, r2)
            java.lang.CharSequence r0 = r0.subSequence(r3, r2)
            java.lang.String r0 = r0.toString()
            int r0 = r6.d(r7, r0)
            goto L75
        L61:
            boolean r1 = r0 instanceof char[]
            if (r1 == 0) goto L78
            char[] r0 = (char[]) r0
            int r1 = r0.length
            java.lang.String r5 = new java.lang.String
            int r2 = java.lang.Math.min(r1, r2)
            r5.<init>(r0, r3, r2)
            int r0 = r6.d(r7, r5)
        L75:
            int r3 = r1 - r0
            goto L96
        L78:
            boolean r1 = r0 instanceof byte[]
            if (r1 == 0) goto L96
            byte[] r0 = (byte[]) r0
            int r1 = r0.length
            int r1 = java.lang.Math.min(r1, r2)
            java.lang.String r2 = new java.lang.String
            java.lang.String r4 = "UTF-8"
            java.nio.charset.Charset r4 = java.nio.charset.Charset.forName(r4)
            r2.<init>(r0, r3, r1, r4)
            r6.d(r7, r2)
            int r0 = r0.length
            int r3 = r0 - r1
            java.lang.String r4 = " bytes"
        L96:
            if (r3 <= 0) goto La8
            java.lang.String r0 = "[truncated "
            r7.append(r0)
            r7.append(r3)
            r7.append(r4)
            r0 = 93
            r7.append(r0)
        La8:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ws.a(java.lang.StringBuilder):java.lang.StringBuilder");
    }

    private int d(StringBuilder sb, String str) {
        sb.append('\"');
        sb.append(str);
        sb.append('\"');
        return str.length();
    }
}
