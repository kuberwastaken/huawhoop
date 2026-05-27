package defpackage;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes7.dex */
public class sgj<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<V> f17698a;

    public void e(V v) {
        this.f17698a = new WeakReference<>(v);
    }

    public void e() {
        WeakReference<V> weakReference = this.f17698a;
        if (weakReference != null) {
            weakReference.clear();
            this.f17698a = null;
        }
    }

    public V a() {
        WeakReference<V> weakReference = this.f17698a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }
}
