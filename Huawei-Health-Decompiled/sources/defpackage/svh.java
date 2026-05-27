package defpackage;

/* JADX INFO: loaded from: classes8.dex */
public class svh extends pfx {
    private svk c;

    public svh(float f, svk svkVar) {
        super(f);
        this.c = svkVar;
    }

    public svk a() {
        return this.c;
    }

    @Override // defpackage.pfx
    public float b() {
        svk svkVar = this.c;
        if (svkVar != null) {
            return svkVar.e();
        }
        return super.b();
    }

    @Override // defpackage.pfx
    public float d() {
        svk svkVar = this.c;
        if (svkVar != null) {
            return svkVar.c();
        }
        return super.d();
    }
}
