package com.huawei.agconnect.common.datastore;

/* JADX INFO: loaded from: classes10.dex */
public interface IDataStore<T> {
    T a(String str);

    void a(String str, T t);

    T b(String str, T t);

    void b(String str);

    boolean contains(String str);
}
