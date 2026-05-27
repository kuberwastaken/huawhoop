package defpackage;

import java.io.File;

/* JADX INFO: loaded from: classes11.dex */
public class wsy {
    private String b;
    private File d;

    protected wsy(d dVar) {
        this.d = dVar.b;
        this.b = dVar.f18918a;
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f18918a;
        private File b;

        public d a(File file) {
            this.b = file;
            return this;
        }

        public wsy a() {
            return new wsy(this);
        }
    }

    public File c() {
        return this.d;
    }

    public String a() {
        return this.b;
    }
}
