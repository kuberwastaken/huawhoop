package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public class fcw extends pfx {
    private float c;
    private float f;
    private fcu g;
    private float h;
    private float j;

    public fcw(float f, fcu fcuVar) {
        super(f);
        this.g = fcuVar;
    }

    public float i() {
        return this.f;
    }

    public void a(float f) {
        this.f = f;
    }

    public float c() {
        return this.j;
    }

    public void e(float f) {
        this.j = f;
    }

    public float e() {
        return this.h;
    }

    public void d(float f) {
        this.h = f;
    }

    public float a() {
        return this.c;
    }

    public void b(float f) {
        this.c = f;
    }

    public void e(fcu fcuVar) {
        this.g = fcuVar;
    }

    public fcu f() {
        return this.g;
    }

    @Override // defpackage.pfx
    public float b() {
        fcu fcuVar = this.g;
        if (fcuVar != null) {
            return fcuVar.c();
        }
        return super.b();
    }

    @Override // defpackage.pfx
    public float d() {
        fcu fcuVar = this.g;
        if (fcuVar != null) {
            return fcuVar.d();
        }
        return super.d();
    }
}
