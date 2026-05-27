package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes3.dex */
public class cci {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("encryptData")
    private String f572a;

    @SerializedName("version")
    private int d = 1;

    public String d() {
        return this.f572a;
    }

    public void c(String str) {
        this.f572a = str;
    }

    public int b() {
        return this.d;
    }
}
