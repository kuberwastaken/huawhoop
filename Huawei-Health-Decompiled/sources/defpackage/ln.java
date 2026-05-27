package defpackage;

/* JADX INFO: loaded from: classes9.dex */
public class ln implements Runnable {
    public final /* synthetic */ lp b;

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.b.d();
        } catch (Exception e) {
            lq.d(e);
        }
    }

    public ln(lp lpVar) {
        this.b = lpVar;
    }
}
