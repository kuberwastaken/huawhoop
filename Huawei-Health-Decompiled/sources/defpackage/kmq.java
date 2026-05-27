package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.openalliance.ad.db.bean.ContentResource;

/* JADX INFO: loaded from: classes11.dex */
public class kmq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("fileSize")
    private int f14760a;

    @SerializedName("bizSubType")
    private int b;

    @SerializedName("fileSha256")
    private String c;

    @SerializedName("bizType")
    private int d;

    @SerializedName(ContentResource.FILE_NAME)
    private String e;

    @SerializedName("fileType")
    private int j;

    public void a(int i) {
        this.d = i;
    }

    public void b(int i) {
        this.b = i;
    }

    public void a(String str) {
        this.e = str;
    }

    public void d(int i) {
        this.j = i;
    }

    public void c(String str) {
        this.c = str;
    }

    public void e(int i) {
        this.f14760a = i;
    }
}
