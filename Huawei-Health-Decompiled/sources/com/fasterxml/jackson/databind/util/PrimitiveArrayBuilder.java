package com.fasterxml.jackson.databind.util;

/* JADX INFO: loaded from: classes9.dex */
public abstract class PrimitiveArrayBuilder<T> {
    static final int INITIAL_CHUNK_SIZE = 12;
    static final int MAX_CHUNK_SIZE = 262144;
    static final int SMALL_CHUNK_SIZE = 16384;
    protected c<T> _bufferHead;
    protected c<T> _bufferTail;
    protected int _bufferedEntryCount;
    protected T _freeBuffer;

    protected abstract T _constructArray(int i);

    public int bufferedSize() {
        return this._bufferedEntryCount;
    }

    public T resetAndStart() {
        _reset();
        T t = this._freeBuffer;
        return t == null ? _constructArray(12) : t;
    }

    public final T appendCompletedChunk(T t, int i) {
        c<T> cVar = new c<>(t, i);
        if (this._bufferHead == null) {
            this._bufferTail = cVar;
            this._bufferHead = cVar;
        } else {
            this._bufferTail.c(cVar);
            this._bufferTail = cVar;
        }
        this._bufferedEntryCount += i;
        return _constructArray(i < 16384 ? i + i : i + (i >> 2));
    }

    public T completeAndClearBuffer(T t, int i) {
        int i2 = this._bufferedEntryCount + i;
        T t_constructArray = _constructArray(i2);
        int iE = 0;
        for (c<T> cVarA = this._bufferHead; cVarA != null; cVarA = cVarA.a()) {
            iE = cVarA.e(t_constructArray, iE);
        }
        System.arraycopy(t, 0, t_constructArray, iE, i);
        int i3 = iE + i;
        if (i3 == i2) {
            return t_constructArray;
        }
        throw new IllegalStateException("Should have gotten " + i2 + " entries, got " + i3);
    }

    protected void _reset() {
        c<T> cVar = this._bufferTail;
        if (cVar != null) {
            this._freeBuffer = cVar.c();
        }
        this._bufferTail = null;
        this._bufferHead = null;
        this._bufferedEntryCount = 0;
    }

    static final class c<T> {
        final T c;
        final int d;
        c<T> e;

        public c(T t, int i) {
            this.c = t;
            this.d = i;
        }

        public T c() {
            return this.c;
        }

        public int e(T t, int i) {
            System.arraycopy(this.c, 0, t, i, this.d);
            return i + this.d;
        }

        public c<T> a() {
            return this.e;
        }

        public void c(c<T> cVar) {
            if (this.e != null) {
                throw new IllegalStateException();
            }
            this.e = cVar;
        }
    }
}
