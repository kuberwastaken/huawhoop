package com.huawei.hmf.services.ui.ref;

import com.huawei.hmf.services.ui.internal.ReferenceTypeImpl;

/* JADX INFO: loaded from: classes10.dex */
public final class Allocator {
    public static final Allocator DEFAULT = new Allocator();

    public <T> ReferenceType<T> alloc(T t) {
        return ReferenceTypeImpl.create(t);
    }
}
