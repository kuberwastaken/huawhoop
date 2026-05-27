package com.huawei.hmf.orb;

/* JADX INFO: loaded from: classes10.dex */
public class IndexedObject<T> {
    private long mId = RemoteSession.nextID();
    private T mObject;

    public IndexedObject(T t) {
        this.mObject = t;
    }

    public void set(T t) {
        this.mObject = t;
    }

    public T get() {
        return this.mObject;
    }

    public long id() {
        return this.mId;
    }
}
