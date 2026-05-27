package defpackage;

/* JADX INFO: loaded from: classes11.dex */
public class pcp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f16624a;
    public int b;
    public boolean c;
    public int d;
    public int e;

    private pcp() {
        this.d = 9728;
        this.f16624a = 9729;
        this.b = 33071;
        this.e = 33071;
        this.c = false;
    }

    public static class a {
        public int b = 9728;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f16625a = 9729;
        public int d = 33071;
        public int e = 33071;
        public boolean c = false;

        public a b(int i) {
            this.b = i;
            return this;
        }

        public a c(int i) {
            this.f16625a = i;
            return this;
        }

        public a d(boolean z) {
            this.c = z;
            return this;
        }

        public pcp c() {
            int i;
            pcp pcpVar = new pcp();
            pcpVar.d = this.b;
            pcpVar.f16624a = this.f16625a;
            pcpVar.b = this.d;
            pcpVar.e = this.e;
            pcpVar.c = this.c;
            if (!this.c || ((i = this.b) != 9728 && i != 9729)) {
                return pcpVar;
            }
            pcj.b("TextureOptions", "The value not good for texture when you wanna use mipmap.");
            throw new RuntimeException("the value GLES20.GL_NEAREST or GLES20.GL_LINEAR for GL_TEXTURE_MIN_FILTER is not good for texture when you wanna use mipmap");
        }
    }

    public static pcp a() {
        return new a().c();
    }

    public static pcp e() {
        return new a().d(true).b(9987).c(9987).c();
    }
}
