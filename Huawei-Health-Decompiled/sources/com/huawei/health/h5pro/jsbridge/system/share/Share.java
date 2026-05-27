package com.huawei.health.h5pro.jsbridge.system.share;

/* JADX INFO: loaded from: classes.dex */
public interface Share {

    /* JADX INFO: loaded from: classes10.dex */
    public interface ShareCallback {
        void onFailure(int i, String str);

        void onSuccess();
    }

    void shareImage(ShareImageObj shareImageObj, ShareCallback shareCallback);

    void shareLink(ShareLinkObj shareLinkObj, ShareCallback shareCallback);

    void shareText(String str, ShareCallback shareCallback);
}
