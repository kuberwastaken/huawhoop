package defpackage;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class vxk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f18828a;
    private String c;
    private boolean b = true;
    private Map<String, Object> e = new HashMap();
    private boolean d = true;

    public vxk() {
    }

    public vxk(String str, String str2) {
        this.c = str;
        this.f18828a = str2;
    }

    public void b(String str) {
        this.f18828a = str;
    }

    public void e(String str) {
        this.c = str;
    }

    public void c(boolean z) {
        this.d = z;
    }

    public Object c(String str) {
        return this.e.get(str);
    }

    public void d(Map<String, Object> map) {
        this.e.putAll(map);
    }

    public void a(boolean z) {
        this.b = z;
    }
}
