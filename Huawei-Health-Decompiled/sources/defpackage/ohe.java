package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class ohe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("resultInfo")
    private String f16371a;

    @SerializedName("cursor")
    private String b;

    @SerializedName("list")
    private List<ohh> c;

    @SerializedName("resultCode")
    private String e;

    public String b() {
        return this.e;
    }

    public List<ohh> e() {
        return this.c;
    }

    public String a() {
        return this.b;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("GetThemeListRsp{resultCode=");
        stringBuffer.append(this.e);
        stringBuffer.append("resultInfo=").append(this.f16371a);
        stringBuffer.append(", list=").append(this.c);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
