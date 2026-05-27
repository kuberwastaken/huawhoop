package defpackage;

/* JADX INFO: loaded from: classes5.dex */
public class hkk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f13865a;
    private Object b;
    private int c;

    public hkk(int i) {
        this(-1, i);
    }

    public hkk(int i, int i2) {
        this.f13865a = i;
        this.c = i2;
    }

    public int b() {
        return this.f13865a;
    }

    public int d() {
        return this.c;
    }

    public Object e() {
        return this.b;
    }

    public void b(Object obj) {
        this.b = obj;
    }

    public String toString() {
        return "RecycleItemData{viewId=" + this.f13865a + ", viewType=" + this.c + ", itemData=" + this.b + '}';
    }
}
