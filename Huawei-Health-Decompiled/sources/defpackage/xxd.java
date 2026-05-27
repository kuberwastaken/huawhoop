package defpackage;

import net.lingala.zip4j.headers.HeaderSignature;
import net.lingala.zip4j.model.ZipHeader;

/* JADX INFO: loaded from: classes8.dex */
public class xxd extends ZipHeader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f19186a;
    private long b;
    private String c = "";
    private long d;
    private int e;
    private int h;
    private int i;
    private int j;

    public xxd() {
        setSignature(HeaderSignature.END_OF_CENTRAL_DIRECTORY);
    }

    public int d() {
        return this.f19186a;
    }

    public void c(int i) {
        this.f19186a = i;
    }

    public int e() {
        return this.e;
    }

    public void d(int i) {
        this.e = i;
    }

    public int f() {
        return this.h;
    }

    public void a(int i) {
        this.h = i;
    }

    public int g() {
        return this.i;
    }

    public void b(int i) {
        this.i = i;
    }

    public void e(int i) {
        this.j = i;
    }

    public long b() {
        return this.b;
    }

    public void b(long j) {
        this.b = j;
    }

    public long c() {
        return this.d;
    }

    public void e(long j) {
        this.d = j;
    }

    public String a() {
        return this.c;
    }

    public void b(String str) {
        if (str != null) {
            this.c = str;
        }
    }
}
