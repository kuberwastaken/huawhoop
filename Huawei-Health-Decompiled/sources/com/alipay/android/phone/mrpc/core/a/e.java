package com.alipay.android.phone.mrpc.core.a;

import android.util.Log;
import com.alipay.android.phone.mrpc.core.RpcException;
import java.util.ArrayList;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

/* JADX INFO: loaded from: classes9.dex */
public class e extends b {
    private int c;
    private Object d;

    @Override // com.alipay.android.phone.mrpc.core.a.f
    public byte[] a() {
        try {
            ArrayList arrayList = new ArrayList();
            if (this.d != null) {
                arrayList.add(new BasicNameValuePair("extParam", com.alipay.sdk.m.f.a.a(this.d)));
            }
            arrayList.add(new BasicNameValuePair("operationType", this.f734a));
            arrayList.add(new BasicNameValuePair("id", this.c + ""));
            StringBuilder sb = new StringBuilder("mParams is:");
            sb.append(this.b);
            Log.d("JsonSerializer", sb.toString());
            Object obj = this.b;
            arrayList.add(new BasicNameValuePair("requestData", obj == null ? "[]" : com.alipay.sdk.m.f.a.a(obj)));
            String str = URLEncodedUtils.format(arrayList, "utf-8");
            Log.i("JsonSerializer", "request = " + str);
            return str.getBytes();
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder("request  =");
            sb2.append(this.b);
            sb2.append(":");
            sb2.append(e);
            throw new RpcException(9, sb2.toString() != null ? e.getMessage() : "", e);
        }
    }

    @Override // com.alipay.android.phone.mrpc.core.a.f
    public void a(Object obj) {
        this.d = obj;
    }

    public e(int i, String str, Object obj) {
        super(str, obj);
        this.c = i;
    }
}
