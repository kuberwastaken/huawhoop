package defpackage;

import com.huawei.hms.framework.network.restclient.Headers;
import com.huawei.hms.framework.network.restclient.hwhttp.ResponseBody;

/* JADX INFO: loaded from: classes6.dex */
public class nba extends Exception {
    private byte[] b;
    private Headers c;
    private int d;
    private ResponseBody e;

    public nba(int i, String str, byte[] bArr, Headers headers, ResponseBody responseBody) {
        super(str);
        this.d = i;
        this.b = bArr;
        this.c = headers;
        this.e = responseBody;
    }

    public Headers a() {
        return this.c;
    }

    public byte[] d() {
        return this.b;
    }

    public int b() {
        return this.d;
    }

    public ResponseBody e() {
        return this.e;
    }
}
