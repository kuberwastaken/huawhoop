package defpackage;

import com.huawei.wisesecurity.kfs.crypto.key.KfsKeyPurpose;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsNotBlank;
import com.huawei.wisesecurity.kfs.validation.constrains.KfsNotNull;

/* JADX INFO: loaded from: classes8.dex */
public class wwh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f18951a;

    @KfsNotNull
    @KfsNotBlank
    private String b;
    private boolean c;

    @KfsNotNull
    private KfsKeyPurpose d;

    public wwh(String str, int i, KfsKeyPurpose kfsKeyPurpose) {
        this(str, i, kfsKeyPurpose, true);
    }

    public wwh(String str, int i, KfsKeyPurpose kfsKeyPurpose, boolean z) {
        this.b = str;
        this.f18951a = i;
        this.d = kfsKeyPurpose;
        this.c = z;
    }

    public String e() {
        return this.b;
    }

    public int d() {
        return this.f18951a;
    }

    public KfsKeyPurpose b() {
        return this.d;
    }

    public boolean a() {
        return this.c;
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f18952a;
        private String b;
        private KfsKeyPurpose c;
        private boolean d = true;

        public b c(String str) {
            this.b = str;
            return this;
        }

        public b a(int i) {
            this.f18952a = i;
            return this;
        }

        public b b(KfsKeyPurpose kfsKeyPurpose) {
            this.c = kfsKeyPurpose;
            return this;
        }

        public wwh d() {
            return new wwh(this.b, this.f18952a, this.c, this.d);
        }
    }
}
