package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class trh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("isAppEnabled")
    private boolean f18123a;

    @SerializedName("isPrivacyAccepted")
    private boolean c;

    @SerializedName("isNotifyEnabled")
    private boolean d;

    @SerializedName("currentFastingLiteMode")
    private tsc e;

    public boolean e() {
        return this.f18123a;
    }

    public void a(boolean z) {
        this.f18123a = z;
    }

    public tsc b() {
        return this.e;
    }

    public boolean a() {
        return this.d;
    }

    public String toString() {
        return "FastingLiteAppSetting{isAppEnabled=" + this.f18123a + ", currentFastingLiteMode=" + this.e + ", isPrivacyAccepted=" + this.c + ", isNotifyEnabled=" + this.d + '}';
    }
}
