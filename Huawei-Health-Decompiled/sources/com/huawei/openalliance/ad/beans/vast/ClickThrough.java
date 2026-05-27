package com.huawei.openalliance.ad.beans.vast;

import com.huawei.openalliance.ad.annotations.a;

/* JADX INFO: loaded from: classes6.dex */
public class ClickThrough {
    private String id;

    @a
    private String url;

    public void b(String str) {
        this.url = str;
    }

    public void a(String str) {
        this.id = str;
    }

    public String a() {
        return this.url;
    }
}
