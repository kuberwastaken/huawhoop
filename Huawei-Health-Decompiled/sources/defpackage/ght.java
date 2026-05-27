package defpackage;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class ght implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("mWatermarkId")
    private int f13463a;

    @SerializedName("mBitmapId")
    private int e;

    public void b(int i) {
        this.f13463a = i;
    }

    public int a() {
        return this.f13463a;
    }

    public void c(int i) {
        this.e = i;
    }

    public int c() {
        return this.e;
    }
}
