package defpackage;

import com.huawei.health.healthcloudconfig.listener.DownloadCallback;

/* JADX INFO: loaded from: classes4.dex */
public class eow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f12702a;
    private eou b;
    private boolean c;
    private String d;
    private DownloadCallback e;

    private eow(d dVar) {
        this.c = false;
        this.b = dVar.d;
        this.d = dVar.b;
        this.f12702a = dVar.c;
        this.c = dVar.f12703a;
        this.e = dVar.e;
    }

    public eou d() {
        return this.b;
    }

    public String a() {
        return this.d;
    }

    public String b() {
        return this.f12702a;
    }

    public boolean c() {
        return this.c;
    }

    public DownloadCallback e() {
        return this.e;
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f12703a;
        private String b;
        private String c;
        private eou d;
        private DownloadCallback e;

        public d d(eou eouVar) {
            this.d = eouVar;
            return this;
        }

        public d b(String str) {
            this.b = str;
            return this;
        }

        public d d(String str) {
            this.c = str;
            return this;
        }

        public d a(boolean z) {
            this.f12703a = z;
            return this;
        }

        public d d(DownloadCallback downloadCallback) {
            this.e = downloadCallback;
            return this;
        }

        public eow c() {
            return new eow(this);
        }
    }
}
