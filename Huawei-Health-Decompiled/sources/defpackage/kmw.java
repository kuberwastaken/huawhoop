package defpackage;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes11.dex */
public class kmw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("uploadMethod")
    private String f14764a;

    @SerializedName("filePartId")
    private String b;

    @SerializedName("uploadUrl")
    private String c;

    @SerializedName("uploadHeaders")
    private JsonObject e;

    public String c() {
        return this.c;
    }

    public String a() {
        return this.f14764a;
    }

    public JsonObject e() {
        return this.e;
    }

    public void d(String str) {
        this.c = str;
    }

    public void e(String str) {
        this.f14764a = str;
    }

    public void d(JsonObject jsonObject) {
        this.e = jsonObject;
    }
}
