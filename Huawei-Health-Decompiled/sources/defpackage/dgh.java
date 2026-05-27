package defpackage;

import java.util.LinkedList;

/* JADX INFO: loaded from: classes4.dex */
public class dgh<E> {
    private LinkedList<E> b = new LinkedList<>();
    private volatile int e = 0;
    private final Object c = new Object();

    public void a(E e) {
        synchronized (this.c) {
            this.e++;
            this.b.addLast(e);
        }
    }

    public E d() {
        synchronized (this.c) {
            if (this.e <= 0) {
                this.e = 0;
                return null;
            }
            this.e--;
            return this.b.removeFirst();
        }
    }

    public int e() {
        int i;
        synchronized (this.c) {
            i = this.e;
        }
        return i;
    }

    public void a() {
        synchronized (this.c) {
            this.b.clear();
            this.e = 0;
        }
    }
}
