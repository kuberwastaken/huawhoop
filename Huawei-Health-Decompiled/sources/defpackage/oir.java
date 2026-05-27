package defpackage;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class oir implements Serializable {
    private static final long serialVersionUID = 1;

    @SerializedName("title")
    private String b;

    @SerializedName("detailItemType")
    private String c;

    @SerializedName("id")
    private String e;

    public oir(String str, String str2, String str3) {
        this.e = str;
        this.c = str2;
        this.b = str3;
    }

    public String b() {
        return this.c;
    }
}
