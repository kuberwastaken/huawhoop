package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes9.dex */
public class ahz<T> implements Iterator<T>, Iterable<T> {
    private int b = 0;
    private final T[] d;

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return this;
    }

    public ahz(T[] tArr) {
        this.d = tArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b < this.d.length;
    }

    @Override // java.util.Iterator
    public T next() {
        int i = this.b;
        T[] tArr = this.d;
        if (i >= tArr.length) {
            throw new NoSuchElementException();
        }
        this.b = i + 1;
        return tArr[i];
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
