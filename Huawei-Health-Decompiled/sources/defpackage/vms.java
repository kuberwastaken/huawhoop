package defpackage;

import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes8.dex */
public class vms<E> extends LinkedBlockingQueue<E> {
    @Override // java.util.concurrent.LinkedBlockingQueue, java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean offer(E e) {
        if (size() < 7) {
            return super.offer(e);
        }
        return true;
    }
}
