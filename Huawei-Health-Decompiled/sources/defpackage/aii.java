package defpackage;

import java.lang.reflect.Array;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public final class aii {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private aij<Object[]> f235a;
    private aij<Object[]> b;
    private Object[] c;
    private int e;

    public Object[] e() {
        a();
        Object[] objArr = this.c;
        if (objArr != null) {
            return objArr;
        }
        Object[] objArr2 = new Object[12];
        this.c = objArr2;
        return objArr2;
    }

    public Object[] a(Object[] objArr, int i) {
        a();
        Object[] objArr2 = this.c;
        if (objArr2 == null || objArr2.length < i) {
            this.c = new Object[Math.max(12, i)];
        }
        System.arraycopy(objArr, 0, this.c, 0, i);
        return this.c;
    }

    public Object[] e(Object[] objArr) {
        aij<Object[]> aijVar = new aij<>(objArr, null);
        if (this.b == null) {
            this.f235a = aijVar;
            this.b = aijVar;
        } else {
            this.f235a.b(aijVar);
            this.f235a = aijVar;
        }
        int length = objArr.length;
        this.e += length;
        if (length < 16384) {
            length += length;
        } else if (length < 262144) {
            length += length >> 2;
        }
        return new Object[length];
    }

    public Object[] d(Object[] objArr, int i) {
        int i2 = this.e + i;
        Object[] objArr2 = new Object[i2];
        b(objArr2, i2, objArr, i);
        a();
        return objArr2;
    }

    public <T> T[] a(Object[] objArr, int i, Class<T> cls) {
        int i2 = this.e + i;
        T[] tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i2));
        b(tArr, i2, objArr, i);
        a();
        return tArr;
    }

    public void a(Object[] objArr, int i, List<Object> list) {
        int i2;
        aij<Object[]> aijVarB = this.b;
        while (true) {
            i2 = 0;
            if (aijVarB == null) {
                break;
            }
            Object[] objArrC = aijVarB.c();
            int length = objArrC.length;
            while (i2 < length) {
                list.add(objArrC[i2]);
                i2++;
            }
            aijVarB = aijVarB.b();
        }
        while (i2 < i) {
            list.add(objArr[i2]);
            i2++;
        }
        a();
    }

    public int b() {
        Object[] objArr = this.c;
        if (objArr == null) {
            return 0;
        }
        return objArr.length;
    }

    public int c() {
        return this.e;
    }

    protected void a() {
        aij<Object[]> aijVar = this.f235a;
        if (aijVar != null) {
            this.c = aijVar.c();
        }
        this.f235a = null;
        this.b = null;
        this.e = 0;
    }

    protected final void b(Object obj, int i, Object[] objArr, int i2) {
        int i3 = 0;
        for (aij<Object[]> aijVarB = this.b; aijVarB != null; aijVarB = aijVarB.b()) {
            Object[] objArrC = aijVarB.c();
            int length = objArrC.length;
            System.arraycopy(objArrC, 0, obj, i3, length);
            i3 += length;
        }
        System.arraycopy(objArr, 0, obj, i3, i2);
        int i4 = i3 + i2;
        if (i4 == i) {
            return;
        }
        throw new IllegalStateException("Should have gotten " + i + " entries, got " + i4);
    }
}
