package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.operation.utils.Constants;

/* JADX INFO: loaded from: classes4.dex */
public class ero {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("thumbnail")
    private String f12754a;

    @SerializedName("fileSize")
    private String b;

    @SerializedName("thumbnailSize")
    private String c;

    @SerializedName(Constants.ACTIVITY_SHARE_TYPE)
    private String d;

    @SerializedName("subTitle")
    private String e;

    @SerializedName("title")
    private String f;

    @SerializedName("uri")
    private String i;

    @SerializedName("url")
    private String j;

    public void a(String str) {
        this.d = str;
    }

    public void i(String str) {
        this.i = str;
    }

    public void j(String str) {
        this.j = str;
    }

    public void h(String str) {
        this.f = str;
    }

    public void b(String str) {
        this.e = str;
    }

    public void d(String str) {
        this.f12754a = str;
    }

    public void e(String str) {
        this.c = str;
    }

    public void c(String str) {
        this.b = str;
    }

    public String toString() {
        return "ShareParamData{mShareType='" + this.d + "', mUri='" + this.i + "', mUrl='" + this.j + "', mTitle='" + this.f + "', mSubTitle='" + this.e + "', mThumbnail='" + this.f12754a + "', mThumbnailSize='" + this.c + "', mFileSize='" + this.b + "'}";
    }
}
