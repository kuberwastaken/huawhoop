package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.operation.utils.Constants;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class kjy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("columnHead")
    private String f14715a;

    @SerializedName("exposureTime")
    private long b;

    @SerializedName("itemIndex")
    private String c;

    @SerializedName(Constants.ITEM_NAME)
    private String d;

    @SerializedName("columnId")
    private String e;

    @SerializedName("resourceId")
    private String f;

    public kjy(String str, String str2, String str3, String str4, String str5, long j) {
        this.e = str;
        this.f14715a = str2;
        this.d = str3;
        this.f = str4;
        this.c = str5;
        this.b = j;
    }

    public String d() {
        return this.e;
    }

    public String e() {
        return this.f14715a;
    }

    public String c() {
        return this.d;
    }

    public String b() {
        return this.c;
    }

    public String f() {
        return this.f;
    }

    public long a() {
        return this.b;
    }

    public void a(long j) {
        this.b = j;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof kjy)) {
            return false;
        }
        kjy kjyVar = (kjy) obj;
        return Objects.equals(d(), kjyVar.d()) && Objects.equals(e(), kjyVar.e()) && Objects.equals(c(), kjyVar.c()) && Objects.equals(b(), kjyVar.b()) && Objects.equals(f(), kjyVar.f());
    }
}
