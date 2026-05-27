package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class ohg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("previewUrl")
    private String f16373a;

    @SerializedName("previewName")
    private String d;

    @SerializedName("language")
    private String e;

    public String b() {
        return this.f16373a;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("PreviewInfo{previewUrl=");
        stringBuffer.append(this.f16373a);
        stringBuffer.append(", previewName=").append(this.d);
        stringBuffer.append(", language=").append(this.e);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
