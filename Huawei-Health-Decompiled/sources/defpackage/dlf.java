package defpackage;

import android.text.TextUtils;
import com.huawei.hihealth.util.HiJsonUtil;
import com.huawei.ui.openservice.OpenServiceUtil;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class dlf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f12287a;
    private String b;
    private String c;
    private String d;
    private dkx e;
    private int h;
    private String i;
    private String j;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private String t;
    private int u;
    private String v;
    private String x;
    private String y;
    private int z;
    private int f = 1;
    private int k = 0;
    private int g = 0;
    private String w = OpenServiceUtil.Source.THIRD_H5;

    public String d() {
        return this.p;
    }

    public void m(String str) {
        this.p = str;
    }

    public void s(String str) {
        this.v = str;
    }

    public String c() {
        return this.l;
    }

    public void i(String str) {
        this.l = str;
    }

    public void c(String str) {
        this.d = str;
    }

    public int b() {
        return this.z;
    }

    public void f(int i) {
        this.z = i;
    }

    public void k(String str) {
        this.q = str;
    }

    public void l(String str) {
        this.r = str;
    }

    public void b(String str) {
        this.b = str;
    }

    public String a() {
        return this.x;
    }

    public void t(String str) {
        this.x = str;
    }

    public void j(String str) {
        this.m = str;
    }

    public void g(int i) {
        this.u = i;
    }

    public void d(int i) {
        this.f12287a = i;
    }

    public void a(String str) {
        this.i = str;
    }

    public void c(int i) {
        this.h = i;
    }

    public void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.e = (dkx) HiJsonUtil.b(str, dkx.class);
    }

    public void f(String str) {
        this.j = str;
    }

    public void e(int i) {
        this.f = i;
    }

    public void a(int i) {
        this.k = i;
    }

    public void b(int i) {
        this.g = i;
    }

    public void g(String str) {
        this.o = str;
    }

    public void r(String str) {
        this.w = str;
    }

    public void n(String str) {
        this.t = str;
    }

    public void o(String str) {
        this.s = str;
    }

    public void p(String str) {
        this.y = str;
    }

    public void h(String str) {
        this.n = str;
    }

    public void d(String str) {
        this.c = str;
    }

    public static void c(List<dlf> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Collections.sort(list, new Comparator<dlf>() { // from class: dlf.5
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public int compare(dlf dlfVar, dlf dlfVar2) {
                return dlfVar.b() - dlfVar2.b();
            }
        });
    }
}
