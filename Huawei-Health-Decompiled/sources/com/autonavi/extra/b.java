package com.autonavi.extra;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<a> f1639a = new ArrayList();

    public final void a() {
        synchronized (b.class) {
            List<a> list = this.f1639a;
            if (list != null) {
                list.add(null);
            }
        }
    }

    public final void b() {
        synchronized (b.class) {
            Iterator<a> it = this.f1639a.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public final void c() {
        synchronized (b.class) {
            Iterator<a> it = this.f1639a.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public final void d() {
        synchronized (b.class) {
            Iterator<a> it = this.f1639a.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public final void e() {
        synchronized (b.class) {
            Iterator<a> it = this.f1639a.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public final void f() {
        synchronized (b.class) {
            Iterator<a> it = this.f1639a.iterator();
            while (it.hasNext()) {
                it.next();
            }
            this.f1639a.clear();
        }
    }

    public final String g() {
        String string;
        synchronized (b.class) {
            StringBuffer stringBuffer = new StringBuffer();
            for (a aVar : this.f1639a) {
                if (aVar != null) {
                    String strA = aVar.a();
                    if (!TextUtils.isEmpty(strA)) {
                        stringBuffer.append(strA);
                        if (!strA.endsWith(";")) {
                            stringBuffer.append(";");
                        }
                    }
                }
            }
            string = stringBuffer.toString();
        }
        return string;
    }

    public final void h() {
        synchronized (b.class) {
            Iterator<a> it = this.f1639a.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public final void i() {
        synchronized (b.class) {
            Iterator<a> it = this.f1639a.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public final Object j() {
        Object objB;
        synchronized (b.class) {
            for (a aVar : this.f1639a) {
                if (aVar != null && (objB = aVar.b()) != null) {
                    return objB;
                }
            }
            return null;
        }
    }
}
