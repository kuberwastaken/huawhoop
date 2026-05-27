package com.huawei.profile.coordinator;

/* JADX INFO: loaded from: classes7.dex */
public interface ProfileRequestCallback {
    void onFailure(int i, String str);

    void onSuccess(ProfileRequestResult profileRequestResult);
}
