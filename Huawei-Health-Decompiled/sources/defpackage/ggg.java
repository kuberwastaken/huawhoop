package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ggg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("isUpdated")
    private boolean f13441a;

    @SerializedName("result")
    private Map<String, Object> c;

    public Map<String, Object> d() {
        return this.c;
    }

    public void c(Map<String, Object> map) {
        this.c = map;
    }

    public boolean b() {
        return this.f13441a;
    }

    public void a(boolean z) {
        this.f13441a = z;
    }
}
