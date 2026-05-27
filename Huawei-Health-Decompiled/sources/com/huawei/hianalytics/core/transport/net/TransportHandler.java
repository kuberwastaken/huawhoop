package com.huawei.hianalytics.core.transport.net;

import android.text.TextUtils;
import com.huawei.hianalytics.core.transport.Utils;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public abstract class TransportHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3987a;
    public Map<String, String> b;
    public byte[] c;

    /* JADX INFO: loaded from: classes10.dex */
    public interface Methods {
        public static final String METHOD_GET = "GET";
        public static final String METHOD_POST = "POST";
    }

    public abstract Response a();

    public abstract Response b();

    public Response execute(String str) {
        if (TextUtils.isEmpty(this.f3987a)) {
            return new Response(-104, "collectUrls is empty");
        }
        try {
            return "GET".equals(str) ? a() : b();
        } catch (Exception e) {
            return Utils.handlerException(e);
        }
    }

    public Response execute() {
        return execute("POST");
    }

    public TransportHandler(String str, Map<String, String> map, byte[] bArr) {
        this.f3987a = str;
        this.b = map;
        this.c = bArr != null ? (byte[]) bArr.clone() : new byte[0];
    }
}
