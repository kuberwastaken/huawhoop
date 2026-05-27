package defpackage;

/* JADX INFO: loaded from: classes5.dex */
public class iua {
    private float e = 0.0f;
    private irt d = new irt(0.0d, 0.0d);
    private float c = 0.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f14292a = 0.0f;
    private float b = 0.0f;

    public static iua b(iua iuaVar) {
        if (iuaVar == null) {
            return new iua();
        }
        iua iuaVar2 = new iua();
        iuaVar2.e(iuaVar.c()).d(iuaVar.e()).c(iuaVar.a()).b(iuaVar.d()).b(iuaVar.b());
        return iuaVar2;
    }

    public float b() {
        return this.b;
    }

    public iua b(float f) {
        this.b = f;
        return this;
    }

    public float a() {
        return this.e;
    }

    public iua c(float f) {
        this.e = f;
        return this;
    }

    public irt d() {
        return this.d;
    }

    public iua b(irt irtVar) {
        this.d = irtVar;
        return this;
    }

    public float e() {
        return this.c;
    }

    public iua d(float f) {
        this.c = f;
        return this;
    }

    public float c() {
        return this.f14292a;
    }

    public iua e(float f) {
        this.f14292a = f;
        return this;
    }
}
