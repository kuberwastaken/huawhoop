package com.huawei.hmf.orb;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes10.dex */
public final class RemoteSession {
    private static final AtomicInteger sequence = new AtomicInteger(0);
    private HashMap<Long, RemoteTarget> remoteTargetMap = new HashMap<>();

    RemoteSession() {
    }

    public static long nextID() {
        return sequence.incrementAndGet();
    }

    public long add(RemoteTarget remoteTarget) {
        long jNextID = nextID();
        this.remoteTargetMap.put(Long.valueOf(jNextID), remoteTarget);
        return jNextID;
    }

    public long add(IndexedObject<? extends RemoteTarget> indexedObject) {
        this.remoteTargetMap.put(Long.valueOf(indexedObject.id()), indexedObject.get());
        return indexedObject.id();
    }

    public RemoteTarget get(Long l) {
        return this.remoteTargetMap.get(l);
    }

    public void release() {
        Iterator<RemoteTarget> it = this.remoteTargetMap.values().iterator();
        while (it.hasNext()) {
            it.next().release();
        }
    }
}
