package defpackage;

import java.util.LinkedList;

/* JADX INFO: loaded from: classes11.dex */
public class pct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    LinkedList<Runnable> f16627a = new LinkedList<>();

    public void a() {
        synchronized (this.f16627a) {
            while (!this.f16627a.isEmpty()) {
                try {
                    this.f16627a.removeFirst().run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void d(Runnable runnable) {
        synchronized (this.f16627a) {
            this.f16627a.addLast(runnable);
        }
    }

    public void e() {
        synchronized (this.f16627a) {
            this.f16627a.clear();
        }
    }

    public void b() {
        e();
        this.f16627a = null;
    }
}
