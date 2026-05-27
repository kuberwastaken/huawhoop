package defpackage;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class vye {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f18838a;
    private Map<String, vya> c = new HashMap(16);
    private String e;

    public void a(String str) {
        this.e = str;
    }

    public void c(String str, vya vyaVar) {
        this.c.put(str, vyaVar);
    }

    public vya e(String str) {
        return this.c.get(str);
    }

    public void d(String str) {
        this.f18838a = str;
    }
}
