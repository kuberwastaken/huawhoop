package com.huawei.hms.scankit.p;

import com.google.common.primitives.UnsignedBytes;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes5.dex */
final class y2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f6111a;
    private e7 b;
    private final StringBuilder c;
    int d;
    private int e;
    private d7 f;
    private int g;

    public void a(m2 m2Var, m2 m2Var2) {
    }

    y2(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.ISO_8859_1);
        StringBuilder sb = new StringBuilder(bytes.length);
        int length = bytes.length;
        for (int i = 0; i < length; i++) {
            char c = (char) (bytes[i] & UnsignedBytes.MAX_VALUE);
            if (c == '?' && str.charAt(i) != '?') {
                throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
            }
            sb.append(c);
        }
        this.f6111a = sb.toString();
        this.b = e7.FORCE_NONE;
        this.c = new StringBuilder(str.length());
        this.e = -1;
    }

    public String d() {
        return this.f6111a;
    }

    public char c() {
        return this.f6111a.charAt(this.d);
    }

    public StringBuilder b() {
        return this.c;
    }

    public int a() {
        return this.c.length();
    }

    public int e() {
        return this.e;
    }

    public void j() {
        this.e = -1;
    }

    public boolean i() {
        return this.d < h();
    }

    private int h() {
        return this.f6111a.length() - this.g;
    }

    public int f() {
        return h() - this.d;
    }

    public d7 g() {
        return this.f;
    }

    public void l() {
        c(a());
    }

    public void k() {
        this.f = null;
    }

    public void a(int i) {
        this.g = i;
    }

    public void b(int i) {
        this.e = i;
    }

    public void c(int i) {
        d7 d7Var = this.f;
        if (d7Var == null || i > d7Var.a()) {
            this.f = d7.a(i, this.b, null, null, true);
        }
    }

    public void a(e7 e7Var) {
        this.b = e7Var;
    }

    public void a(char c) {
        this.c.append(c);
    }

    public void a(String str) {
        this.c.append(str);
    }
}
