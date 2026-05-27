package com.huawei.wisesecurity.kfs.entity;

import defpackage.wwr;

/* JADX INFO: loaded from: classes11.dex */
public interface KfsCallback<Response extends wwr> {
    void onFailure(Throwable th);

    void onSuccess(Response response);
}
