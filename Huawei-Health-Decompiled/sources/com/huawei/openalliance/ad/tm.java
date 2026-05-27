package com.huawei.openalliance.ad;

import android.content.Context;
import com.huawei.openalliance.ad.db.bean.ContentRecord;

/* JADX INFO: loaded from: classes6.dex */
public abstract class tm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f7797a;
    protected ContentRecord b;
    private String c = null;
    private tm d;

    public abstract boolean a();

    public String c() {
        tm tmVar;
        String str = this.c;
        return (str != null || (tmVar = this.d) == null) ? str : tmVar.c();
    }

    public boolean b() {
        tm tmVar = this.d;
        if (tmVar != null) {
            return tmVar.a();
        }
        return false;
    }

    public void b(String str) {
        this.c = str;
    }

    public void a(tm tmVar) {
        this.d = tmVar;
    }

    public tm(Context context, ContentRecord contentRecord) {
        this.f7797a = context;
        this.b = contentRecord;
    }

    public tm() {
    }
}
