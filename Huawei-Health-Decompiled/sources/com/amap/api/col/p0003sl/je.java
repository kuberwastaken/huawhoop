package com.amap.api.col.p0003sl;

import android.text.TextUtils;
import java.util.Vector;

/* JADX INFO: loaded from: classes3.dex */
public final class je {
    private static int b = 100;
    private static int d = 10000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Vector<jb> f1135a;
    private int c;
    private int e;

    public je() {
        this.e = 0;
        this.c = 10;
        this.f1135a = new Vector<>();
    }

    public je(byte b2) {
        this.c = b;
        this.e = 0;
        this.f1135a = new Vector<>();
    }

    public final boolean a(String str) {
        synchronized (this) {
            if (str == null) {
                return false;
            }
            if (this.f1135a.size() >= this.c) {
                return true;
            }
            return this.e + str.getBytes().length > d;
        }
    }

    public final Vector<jb> a() {
        return this.f1135a;
    }

    public final void b() {
        synchronized (this) {
            this.f1135a.clear();
            this.e = 0;
        }
    }

    public final void a(jb jbVar) {
        synchronized (this) {
            if (jbVar != null) {
                if (!TextUtils.isEmpty(jbVar.b())) {
                    this.f1135a.add(jbVar);
                    this.e += jbVar.b().getBytes().length;
                }
            }
        }
    }
}
