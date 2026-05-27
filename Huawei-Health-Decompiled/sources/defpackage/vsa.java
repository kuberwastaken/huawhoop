package defpackage;

import health.compact.a.LogUtil;
import java.io.File;

/* JADX INFO: loaded from: classes8.dex */
public class vsa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private File f18784a;
    private boolean b;
    private String c;
    private int d;
    private byte[] e;

    protected vsa(d dVar) {
        this.c = dVar.d;
        this.e = dVar.e;
        this.f18784a = dVar.c;
        this.b = dVar.b;
        this.d = dVar.f18785a;
    }

    public static class d {
        private File c;
        String d;
        private byte[] e;
        private int h = 0;
        private boolean b = true;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f18785a = 1;

        public d d(byte[] bArr) {
            int i = this.h;
            if (i == 0 || i == 1) {
                this.e = bArr;
                this.h = 1;
            } else {
                LogUtil.b("P2pMessage", "Data setPayload type: ", Integer.valueOf(i));
            }
            return this;
        }

        public d a(File file) {
            int i = this.h;
            if (i == 0 || i == 2) {
                this.c = file;
                this.h = 2;
            } else {
                LogUtil.b("P2pMessage", "File setPayload type: ", Integer.valueOf(i));
            }
            return this;
        }

        public d d(String str) {
            this.d = str;
            return this;
        }

        public d c(boolean z) {
            this.b = z;
            return this;
        }

        public d a(int i) {
            this.f18785a = i;
            return this;
        }

        public vsa b() {
            return new vsa(this);
        }
    }

    public byte[] c() {
        return this.e;
    }

    public File b() {
        return this.f18784a;
    }

    public String d() {
        return this.c;
    }

    public int a() {
        if (this.e != null) {
            return 1;
        }
        return this.f18784a != null ? 2 : 0;
    }

    public boolean g() {
        return this.b;
    }

    public int e() {
        return this.d;
    }
}
