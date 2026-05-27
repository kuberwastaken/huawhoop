package defpackage;

import com.fasterxml.jackson.databind.util.LookupCache;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes9.dex */
public class aia<K, V> implements LookupCache<K, V>, Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final transient int f231a;
    protected final transient ConcurrentHashMap<K, V> b;
    protected transient int c;

    public aia(int i, int i2) {
        this.b = new ConcurrentHashMap<>(i, 0.8f, 4);
        this.f231a = i2;
    }

    @Override // com.fasterxml.jackson.databind.util.LookupCache
    public V put(K k, V v) {
        if (this.b.size() >= this.f231a) {
            synchronized (this) {
                if (this.b.size() >= this.f231a) {
                    clear();
                }
            }
        }
        return this.b.put(k, v);
    }

    @Override // com.fasterxml.jackson.databind.util.LookupCache
    public V putIfAbsent(K k, V v) {
        if (this.b.size() >= this.f231a) {
            synchronized (this) {
                if (this.b.size() >= this.f231a) {
                    clear();
                }
            }
        }
        return this.b.putIfAbsent(k, v);
    }

    @Override // com.fasterxml.jackson.databind.util.LookupCache
    public V get(Object obj) {
        return this.b.get(obj);
    }

    @Override // com.fasterxml.jackson.databind.util.LookupCache
    public void clear() {
        this.b.clear();
    }

    @Override // com.fasterxml.jackson.databind.util.LookupCache
    public int size() {
        return this.b.size();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        this.c = objectInputStream.readInt();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.c);
    }

    protected Object readResolve() {
        int i = this.c;
        return new aia(i, i);
    }
}
