package defpackage;

import android.app.Application;
import android.content.Context;

/* JADX INFO: loaded from: classes6.dex */
public class nne {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f16050a;
    private final Application b;
    private final Context c;
    private final String d;
    private final String e;

    private nne(b bVar) {
        this.b = bVar.e;
        this.c = bVar.d;
        this.f16050a = bVar.f16051a;
        this.e = bVar.b;
        this.d = bVar.c;
    }

    public Context a() {
        Application application = this.b;
        return application != null ? application : this.c;
    }

    public String b() {
        return this.f16050a;
    }

    public String e() {
        return this.e;
    }

    public String d() {
        return this.d;
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f16051a;
        private String b;
        private String c;
        private Context d;
        private Application e;

        public b cmq_(Application application) {
            this.e = application;
            return this;
        }

        public b e(String str) {
            this.f16051a = str;
            return this;
        }

        public b d(String str) {
            this.b = str;
            return this;
        }

        public b a(String str) {
            this.c = str;
            return this;
        }

        public nne b() {
            return new nne(this);
        }
    }
}
