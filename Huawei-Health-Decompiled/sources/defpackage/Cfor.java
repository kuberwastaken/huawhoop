package defpackage;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: renamed from: for, reason: invalid class name */
/* JADX INFO: loaded from: classes4.dex */
public class Cfor implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("name")
    private String f13064a;

    @SerializedName("id")
    private int e;

    public Cfor(String str, int i) {
        this.f13064a = str;
        this.e = i;
    }

    public String d() {
        String str = this.f13064a;
        return str == null ? "" : str;
    }

    public int a() {
        return this.e;
    }

    public String toString() {
        return this.f13064a;
    }
}
