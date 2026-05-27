package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class knl {

    @SerializedName("labelName")
    private String b;

    @SerializedName("labelValue")
    private List<String> e;

    public String b() {
        return this.b;
    }

    public void e(String str) {
        this.b = str;
    }

    public List<String> e() {
        return this.e;
    }

    public void b(List<String> list) {
        this.e = list;
    }
}
