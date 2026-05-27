package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class eov {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("duration")
    private int f12701a;

    @SerializedName("isFromCloud")
    private boolean b = false;

    @SerializedName("fileList")
    private List<eot> c = new ArrayList(0);

    @SerializedName("resultDesc")
    private String d;

    @SerializedName("resultCode")
    private int e;

    @SerializedName("resultType")
    private int f;

    public int b() {
        return this.e;
    }

    public boolean d() {
        return this.b;
    }

    public void e(boolean z) {
        this.b = z;
    }

    public List<eot> a() {
        return this.c;
    }
}
