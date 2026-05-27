package defpackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class nwc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<String> f16205a;
    private Map<String, ArrayList<String>> c;
    private Map<String, ArrayList<String>> d;

    public List<String> a() {
        return this.f16205a;
    }

    public void a(List<String> list) {
        this.f16205a = list;
    }

    public Map<String, ArrayList<String>> d() {
        return this.c;
    }

    public void d(Map<String, ArrayList<String>> map) {
        this.c = map;
    }

    public Map<String, ArrayList<String>> e() {
        return this.d;
    }

    public void b(Map<String, ArrayList<String>> map) {
        this.d = map;
    }
}
