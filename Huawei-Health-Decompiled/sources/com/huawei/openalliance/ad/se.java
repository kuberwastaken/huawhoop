package com.huawei.openalliance.ad;

import com.huawei.openalliance.ad.beans.inner.HttpConnection;
import com.huawei.openalliance.ad.db.bean.ContentRecord;

/* JADX INFO: loaded from: classes6.dex */
public class se {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f7786a;
    private String c;
    private String d;
    private Long j;
    private ContentRecord k;
    private HttpConnection l;
    private long m;
    private Long n;
    private String o;
    private Integer s;
    private String t;
    private Integer u;
    private long b = 52428800;
    private int e = 10000;
    private int f = 10000;
    private boolean g = true;
    private boolean h = false;
    private boolean i = false;
    private String p = "normal";
    private boolean q = false;
    private boolean r = false;

    public Integer u() {
        return this.s;
    }

    public boolean t() {
        return this.r;
    }

    public boolean s() {
        return this.q;
    }

    public String r() {
        return this.p;
    }

    public String q() {
        return this.o;
    }

    public Long p() {
        return this.n;
    }

    public long o() {
        return this.m;
    }

    public HttpConnection n() {
        return this.l;
    }

    public boolean m() {
        return this.h;
    }

    public ContentRecord l() {
        return this.k;
    }

    public Long k() {
        return this.j;
    }

    public boolean j() {
        return this.g;
    }

    public String i() {
        return this.f7786a;
    }

    public long h() {
        return this.b;
    }

    public int g() {
        return this.f;
    }

    public int f() {
        return this.e;
    }

    public void e(String str) {
        this.p = str;
    }

    public String e() {
        return this.d;
    }

    public void d(boolean z) {
        this.r = z;
    }

    public void d(String str) {
        this.f7786a = str;
    }

    public String d() {
        return this.c;
    }

    public void c(boolean z) {
        this.h = z;
    }

    public void c(String str) {
        this.d = str;
    }

    public void c(int i) {
        this.b = ((long) i) * 1024;
    }

    public String c() {
        return this.t;
    }

    public void b(boolean z) {
        this.g = z;
    }

    public void b(String str) {
        this.c = str;
    }

    public void b(Long l) {
        this.n = l;
    }

    public void b(Integer num) {
        this.s = num;
    }

    public void b(long j) {
        this.m = j;
    }

    public void b(int i) {
        this.f = i;
    }

    public Integer b() {
        return this.u;
    }

    public boolean a() {
        return this.i;
    }

    public void a(boolean z) {
        this.i = z;
    }

    public void a(String str) {
        this.t = str;
    }

    public void a(Long l) {
        this.j = l;
    }

    public void a(Integer num) {
        this.u = num;
    }

    public void a(ContentRecord contentRecord) {
        this.k = contentRecord;
    }

    public void a(HttpConnection httpConnection) {
        this.l = httpConnection;
    }

    public void a(long j) {
        this.b = j;
    }

    public void a(int i) {
        this.e = i;
    }
}
