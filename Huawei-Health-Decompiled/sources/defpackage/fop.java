package defpackage;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class fop implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("thumbnailForDevice")
    private String f13062a;

    @SerializedName("landscapeImages")
    private List<String> b;

    @SerializedName("thumbnailBackground")
    private String c;

    @SerializedName("alternateDomainName")
    private List<String> d;

    @SerializedName("thumbnailForDeviceSmall")
    private String e;

    @SerializedName("thumbnailImage")
    private String h;

    public String c() {
        return (!mgx.d(this.d) ? this.d.get(0) : "") + "/" + this.h;
    }

    public String b() {
        if (TextUtils.isEmpty(this.f13062a)) {
            return "";
        }
        return (mgx.d(this.d) ? "" : this.d.get(0)) + "/" + this.f13062a;
    }

    public String a() {
        if (TextUtils.isEmpty(this.e)) {
            return "";
        }
        return (mgx.d(this.d) ? "" : this.d.get(0)) + "/" + this.e;
    }

    public String e() {
        if (TextUtils.isEmpty(this.c)) {
            return "";
        }
        return (mgx.d(this.d) ? "" : this.d.get(0)) + "/" + this.c;
    }

    public List<String> d() {
        return this.b;
    }

    public String toString() {
        return "PathImageInfo{thumbnailImage='" + this.h + "', thumbnailForDevice=" + this.f13062a + ", thumbnailForDeviceSmall=" + this.e + ", landscapeImage=" + this.b + ", alternateDomainName=" + this.d + ", thumbnailBackground=" + this.c + '}';
    }
}
