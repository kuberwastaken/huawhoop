package com.huawei.health.userprofilemgr.model;

import com.huawei.up.model.UserInfomation;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes5.dex */
public abstract class UserInformationCallback<T> implements BaseResponseCallback<UserInfomation> {
    public WeakReference<T> mReference;

    public UserInformationCallback(T t) {
        this.mReference = new WeakReference<>(t);
    }
}
