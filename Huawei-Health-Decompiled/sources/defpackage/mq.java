package defpackage;

import com.alipay.sdk.m.j.b;

/* JADX INFO: loaded from: classes9.dex */
public final class mq extends b {
    public final String f;

    public mq(String str) {
        this.f = str;
    }

    @Override // com.alipay.sdk.m.j.b
    public void a() throws Exception {
        this.f787a = (byte) 1;
        byte[] bytes = this.f.getBytes("UTF-8");
        this.c = bytes;
        this.b = (byte) bytes.length;
    }
}
