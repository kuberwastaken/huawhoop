package com.huawei.openalliance.ad;

import android.os.Process;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes6.dex */
public class hx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f7179a;
    private String b;
    private int c;
    private String e;
    private int f;
    private long d = 0;
    private final StringBuilder g = new StringBuilder();

    public String toString() {
        StringBuilder sb = new StringBuilder();
        a(sb);
        b(sb);
        return sb.toString();
    }

    public String b() {
        StringBuilder sb = new StringBuilder();
        b(sb);
        return sb.toString();
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        a(sb);
        return sb.toString();
    }

    public <T> hx a(T t) {
        this.g.append(t);
        return this;
    }

    private hx c() {
        this.d = System.currentTimeMillis();
        this.e = Thread.currentThread().getName();
        this.f = Process.myPid();
        return this;
    }

    private StringBuilder b(StringBuilder sb) {
        sb.append(' ');
        sb.append((CharSequence) this.g);
        return sb;
    }

    private StringBuilder a(StringBuilder sb) {
        SimpleDateFormat simpleDateFormatA = com.huawei.openalliance.ad.utils.ar.a("yyyy-MM-dd HH:mm:ss.SSS");
        sb.append('[');
        sb.append(simpleDateFormatA.format(Long.valueOf(this.d)));
        String strA = hu.a(this.c);
        sb.append(' ');
        sb.append(strA);
        sb.append('/');
        sb.append(this.f7179a);
        sb.append('/');
        sb.append(this.b);
        sb.append(' ');
        sb.append(this.f);
        sb.append(':');
        sb.append(this.e);
        sb.append(']');
        return sb;
    }

    hx(String str, int i, String str2) {
        this.f7179a = null;
        this.b = "HA";
        this.c = 0;
        this.f7179a = str;
        this.c = i;
        if (str2 != null) {
            this.b = str2;
        }
        c();
    }
}
