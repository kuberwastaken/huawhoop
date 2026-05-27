package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.pluginhealthzone.interactors.HealthZonePushReceiver;
import com.huawei.watchface.mvp.model.webview.JsNetwork;

/* JADX INFO: loaded from: classes7.dex */
public class obx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(JsNetwork.NetworkType.MOBILE)
    private String f16276a;

    @SerializedName("huid")
    private long b;

    @SerializedName(HealthZonePushReceiver.MEMBER_HUID)
    private Long c;

    @SerializedName("email")
    private String d;

    @SerializedName("headPictureURL")
    private String e;

    @SerializedName("nickname")
    private String h;

    @SerializedName("pushSubType")
    private int j;

    public void e(String str) {
        this.e = str;
    }

    public void d(Long l) {
        this.c = l;
    }

    public void d(String str) {
        this.f16276a = str;
    }

    public void c(String str) {
        this.d = str;
    }

    public void b(int i) {
        this.j = i;
    }

    public void a(long j) {
        this.b = j;
    }

    public void a(String str) {
        this.h = str;
    }
}
