package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class chz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f655a;
    private String b;
    private List<chz> c;
    private int e;

    public chz(int i, String str, String str2) {
        this.e = i;
        this.b = str2;
        this.f655a = str;
    }

    public chz() {
        this.c = new ArrayList(16);
    }

    public List<chz> d() {
        return this.c;
    }

    public int a() {
        return this.e;
    }

    public String b() {
        return this.b;
    }

    public void d(String str) {
        this.b = str;
    }

    public String e() {
        return this.f655a;
    }

    public void b(String str) {
        this.f655a = str;
    }
}
