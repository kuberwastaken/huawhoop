package com.amap.api.col.p0003sl;

import android.text.TextUtils;
import com.huawei.health.ecologydevice.ui.measure.fragment.ropefragment.mediamanager.MediaManager;

/* JADX INFO: loaded from: classes3.dex */
@kf(a = "a")
public final class ix {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @kg(a = "a1", b = 6)
    private String f1121a;

    @kg(a = "a2", b = 6)
    private String b;

    @kg(a = "a6", b = 2)
    private int c;

    @kg(a = "a3", b = 6)
    private String d;

    @kg(a = "a4", b = 6)
    private String e;

    @kg(a = "a5", b = 6)
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String[] l;

    /* synthetic */ ix(a aVar, byte b) {
        this(aVar);
    }

    private ix() {
        this.c = 1;
        this.l = null;
    }

    private ix(a aVar) {
        this.c = 1;
        this.l = null;
        this.g = aVar.f1122a;
        this.h = aVar.b;
        this.j = aVar.c;
        this.i = aVar.d;
        this.c = aVar.e ? 1 : 0;
        this.k = aVar.f;
        this.l = aVar.g;
        this.b = iy.b(this.h);
        this.f1121a = iy.b(this.j);
        this.d = iy.b(this.i);
        this.e = iy.b(a(this.l));
        this.f = iy.b(this.k);
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f1122a;
        private String b;
        private String c;
        private String d;
        private boolean e = true;
        private String f = MediaManager.ROPE_MEDIA_STANDARD;
        private String[] g = null;

        public a(String str, String str2, String str3) {
            this.f1122a = str2;
            this.b = str2;
            this.d = str3;
            this.c = str;
        }

        public final a a(boolean z) {
            this.e = z;
            return this;
        }

        public final a a(String[] strArr) {
            if (strArr != null) {
                this.g = (String[]) strArr.clone();
            }
            return this;
        }

        public final a a(String str) {
            this.b = str;
            return this;
        }

        public final ix a() throws ik {
            if (this.g == null) {
                throw new ik("sdk packages is null");
            }
            return new ix(this, (byte) 0);
        }
    }

    public final void a(boolean z) {
        this.c = z ? 1 : 0;
    }

    public final String a() {
        if (TextUtils.isEmpty(this.j) && !TextUtils.isEmpty(this.f1121a)) {
            this.j = iy.c(this.f1121a);
        }
        return this.j;
    }

    public final String b() {
        return this.g;
    }

    public final String c() {
        if (TextUtils.isEmpty(this.h) && !TextUtils.isEmpty(this.b)) {
            this.h = iy.c(this.b);
        }
        return this.h;
    }

    public final String d() {
        if (TextUtils.isEmpty(this.k) && !TextUtils.isEmpty(this.f)) {
            this.k = iy.c(this.f);
        }
        if (TextUtils.isEmpty(this.k)) {
            this.k = MediaManager.ROPE_MEDIA_STANDARD;
        }
        return this.k;
    }

    public final boolean e() {
        return this.c == 1;
    }

    public final String[] f() {
        String[] strArr = this.l;
        if ((strArr == null || strArr.length == 0) && !TextUtils.isEmpty(this.e)) {
            this.l = a(iy.c(this.e));
        }
        return (String[]) this.l.clone();
    }

    private static String[] a(String str) {
        try {
            return str.split(";");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static String a(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            for (String str : strArr) {
                sb.append(str);
                sb.append(";");
            }
            return sb.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        try {
            if (this.j.equals(((ix) obj).j) && this.g.equals(((ix) obj).g)) {
                if (this.h.equals(((ix) obj).h)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
