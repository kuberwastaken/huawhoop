package defpackage;

/* JADX INFO: loaded from: classes9.dex */
public final class aij<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private aij<T> f236a;
    private final T e;

    public aij(T t, aij<T> aijVar) {
        this.e = t;
        this.f236a = aijVar;
    }

    public void b(aij<T> aijVar) {
        if (this.f236a != null) {
            throw new IllegalStateException();
        }
        this.f236a = aijVar;
    }

    public aij<T> b() {
        return this.f236a;
    }

    public T c() {
        return this.e;
    }

    public static <ST> boolean c(aij<ST> aijVar, ST st) {
        while (aijVar != null) {
            if (aijVar.c() == st) {
                return true;
            }
            aijVar = aijVar.b();
        }
        return false;
    }
}
