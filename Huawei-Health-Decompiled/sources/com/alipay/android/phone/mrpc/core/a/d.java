package com.alipay.android.phone.mrpc.core.a;

import android.util.Log;
import com.alipay.android.phone.mrpc.core.RpcException;
import java.lang.reflect.Type;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class d extends a {
    @Override // com.alipay.android.phone.mrpc.core.a.c
    public Object a() {
        try {
            String str = new String(this.b);
            Log.v("HttpCaller", "threadid = " + Thread.currentThread().getId() + "; rpc response:  " + str);
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("resultStatus");
            if (i == 1000) {
                return this.f733a == String.class ? jSONObject.optString("result") : com.alipay.sdk.m.f.a.a(jSONObject.optString("result"), this.f733a);
            }
            throw new RpcException(Integer.valueOf(i), jSONObject.optString("tips"));
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("response  =");
            sb.append(new String(this.b));
            sb.append(":");
            sb.append(e);
            throw new RpcException((Integer) 10, sb.toString() == null ? "" : e.getMessage());
        }
    }

    public d(Type type, byte[] bArr) {
        super(type, bArr);
    }
}
