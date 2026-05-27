package com.huawei.hwcloudjs.service.debugtool;

/* JADX INFO: loaded from: classes11.dex */
public class SetUrl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static SetUrl f6428a;
    private GetUrlCallBack b;

    public interface GetUrlCallBack {
        void onResult(String str);
    }

    public GetUrlCallBack b() {
        return this.b;
    }

    public void a(GetUrlCallBack getUrlCallBack) {
        this.b = getUrlCallBack;
    }

    public static SetUrl a() {
        SetUrl setUrl;
        synchronized (SetUrl.class) {
            if (f6428a == null) {
                f6428a = new SetUrl();
            }
            setUrl = f6428a;
        }
        return setUrl;
    }
}
