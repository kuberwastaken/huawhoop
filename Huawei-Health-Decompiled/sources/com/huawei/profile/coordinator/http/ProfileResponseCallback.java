package com.huawei.profile.coordinator.http;

/* JADX INFO: loaded from: classes7.dex */
public interface ProfileResponseCallback {
    void onFailure(int i, ProfileHttpResponse profileHttpResponse);

    void onSuccess(String str);
}
