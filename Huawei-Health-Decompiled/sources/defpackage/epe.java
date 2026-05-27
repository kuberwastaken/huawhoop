package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.openalliance.ad.db.bean.ContentResource;

/* JADX INFO: loaded from: classes4.dex */
public class epe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(ContentResource.FILE_NAME)
    protected String f12710a;

    @SerializedName("version")
    protected int b;

    public int e() {
        return this.b;
    }

    public void e(int i) {
        this.b = i;
    }

    public String d() {
        return this.f12710a;
    }

    public void c(String str) {
        this.f12710a = str;
    }
}
