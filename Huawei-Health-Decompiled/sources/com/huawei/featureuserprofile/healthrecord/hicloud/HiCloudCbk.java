package com.huawei.featureuserprofile.healthrecord.hicloud;

/* JADX INFO: loaded from: classes10.dex */
public interface HiCloudCbk<T> {
    void onFailure(int i, String str);

    void onSuccess(T t);
}
