package com.huawei.hms.push;

import com.huawei.hms.push.notification.SubscribedItem;
import com.huawei.hms.support.api.client.Result;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class SubscribeResult extends Result {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5861a;
    private List<SubscribedItem> b;

    public String getErrorMsg() {
        return this.f5861a;
    }

    public List<SubscribedItem> getSubscribedItems() {
        return this.b;
    }

    public void setErrorMsg(String str) {
        this.f5861a = str;
    }

    public void setSubscribedItems(List<SubscribedItem> list) {
        this.b = list;
    }
}
