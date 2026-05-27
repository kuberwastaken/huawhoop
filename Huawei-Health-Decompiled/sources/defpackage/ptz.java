package defpackage;

/* JADX INFO: loaded from: classes7.dex */
public class ptz extends ptv {
    private static final long serialVersionUID = -4823894855853644001L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f16878a;
    private String b;

    public String a() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    public void c(int i) {
        this.f16878a = i;
    }

    public String toString() {
        return "Paragraph{mValue='" + this.b + "', mPlaceholderCount=" + this.f16878a + ", mPartType=" + this.d + '}';
    }
}
