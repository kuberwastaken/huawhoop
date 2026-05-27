package com.alipay.sdk.app.debug;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class AlipayDebugOptions {
    private AlipayPayLifeCycle b;

    public interface AlipayPayLifeCycle {
        void onPayEnd(JSONObject jSONObject);
    }

    public AlipayPayLifeCycle b() {
        return this.b;
    }
}
