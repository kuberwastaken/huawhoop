package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public class fbs extends pfx {
    private fbw c;

    public fbs(float f, fbw fbwVar) {
        super(f);
        this.c = fbwVar;
    }

    public fbw a() {
        return this.c;
    }

    @Override // defpackage.pfx
    public float b() {
        fbw fbwVar = this.c;
        if (fbwVar != null) {
            return fbwVar.a();
        }
        return super.b();
    }

    @Override // defpackage.pfx
    public float d() {
        fbw fbwVar = this.c;
        if (fbwVar != null) {
            return fbwVar.d();
        }
        return super.d();
    }
}
