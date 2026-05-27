package defpackage;

import java.util.LinkedList;

/* JADX INFO: loaded from: classes3.dex */
public class vv<E> {
    private LinkedList<E> d = new LinkedList<>();
    private int c = 0;

    public void d(E e) {
        synchronized (this) {
            this.c++;
            this.d.addLast(e);
        }
    }

    public E a() {
        E eRemoveFirst;
        synchronized (this) {
            this.c--;
            eRemoveFirst = this.d.removeFirst();
        }
        return eRemoveFirst;
    }

    public int b() {
        int i;
        synchronized (this) {
            i = this.c;
        }
        return i;
    }

    public void e() {
        synchronized (this) {
            this.d.clear();
            this.c = 0;
        }
    }
}
