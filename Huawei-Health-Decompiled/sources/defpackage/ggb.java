package defpackage;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class ggb implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("advice_type")
    private int f13439a;

    @SerializedName("advice_code")
    private String c;

    @SerializedName("advice_id")
    private int e;

    public void d(int i) {
        this.e = i;
    }

    public int b() {
        return this.e;
    }

    public void a(int i) {
        this.f13439a = i;
    }

    public int d() {
        return this.f13439a;
    }

    public void e(String str) {
        this.c = str;
    }

    public String c() {
        return this.c;
    }

    public String toString() {
        return "{\"DailyAdvice\": {\"adviceId\":" + this.e + ", \"adviceType\":" + this.f13439a + ", \"adviceCode\": \"" + this.c + "\"}}";
    }
}
