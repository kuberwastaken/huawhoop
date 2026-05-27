package defpackage;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class vxz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f18833a;
    private String d;
    private Map<String, vye> e = new HashMap(16);

    public void e(String str) {
        this.d = str;
    }

    public void e(String str, vye vyeVar) {
        this.e.put(str, vyeVar);
    }

    public vye b(String str) {
        return this.e.get(str);
    }

    public void d(long j) {
        this.f18833a = j;
    }
}
