package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.watchface.mvp.model.webview.JsNetwork;

/* JADX INFO: loaded from: classes6.dex */
public class nar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("requestId")
    private int f15979a;

    @SerializedName(JsNetwork.NetworkType.MOBILE)
    private String c;

    public void a(String str) {
        this.c = str;
    }

    public String toString() {
        return "ESDeviceInfo{requestId=" + this.f15979a + '}';
    }

    public void b(int i) {
        this.f15979a = i;
    }
}
