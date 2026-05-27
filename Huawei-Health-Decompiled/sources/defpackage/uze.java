package defpackage;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes11.dex */
public class uze {
    public static final uze d = new uze("no_match", Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("max_version")
    @Expose
    private int f18528a;

    @SerializedName("min_version")
    @Expose
    private int c;

    @SerializedName("feature_name")
    @Expose
    private String e;

    uze(String str, int i, int i2) {
        this.e = str;
        this.c = i;
        this.f18528a = i2;
    }
}
