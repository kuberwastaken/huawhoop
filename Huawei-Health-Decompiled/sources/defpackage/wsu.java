package defpackage;

import java.io.File;

/* JADX INFO: loaded from: classes11.dex */
public class wsu {
    private String b;
    private File c;
    private byte[] d;
    private boolean e;

    protected wsu(e eVar) {
        this.b = eVar.c;
        this.d = eVar.b;
        this.c = eVar.e;
        this.e = eVar.f18912a;
    }

    public static class e {
        private byte[] b;
        String c;
        private File e;
        private int d = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f18912a = true;

        public e e(byte[] bArr) {
            int i = this.d;
            if (i == 0 || i == 1) {
                this.b = bArr == null ? null : (byte[]) bArr.clone();
                this.d = 1;
                return this;
            }
            throw new wqt(5);
        }

        public e c(File file) {
            int i = this.d;
            if (i == 0 || i == 2) {
                this.e = file;
                this.d = 2;
                return this;
            }
            throw new wqt(5);
        }

        public wsu e() {
            return new wsu(this);
        }
    }

    public byte[] b() {
        byte[] bArr = this.d;
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    public File e() {
        return this.c;
    }

    public String a() {
        return this.b;
    }

    public int c() {
        if (this.d != null) {
            return 1;
        }
        return this.c != null ? 2 : 0;
    }

    public boolean d() {
        return this.e;
    }
}
