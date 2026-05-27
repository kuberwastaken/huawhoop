package org.eclipse.californium.scandium.dtls.cipher;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.eclipse.californium.scandium.dtls.cipher.ThreadLocalCrypto;

/* JADX INFO: loaded from: classes8.dex */
public class ThreadLocalCryptoMap<TL extends ThreadLocalCrypto<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentMap<String, TL> f16532a = new ConcurrentHashMap();
    private final Factory<TL> c;

    public interface Factory<T> {
        T getInstance(String str);
    }

    public ThreadLocalCryptoMap(Factory<TL> factory) {
        this.c = factory;
    }

    public TL b(String str) {
        TL tl = this.f16532a.get(str);
        if (tl != null) {
            return tl;
        }
        TL factory = this.c.getInstance(str);
        TL tlPutIfAbsent = this.f16532a.putIfAbsent(str, factory);
        return tlPutIfAbsent == null ? factory : tlPutIfAbsent;
    }
}
