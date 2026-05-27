package defpackage;

import com.huawei.devicesdk.entity.CharacterOperationType;
import com.huawei.devicesdk.entity.SendMode;
import com.huawei.devicesdk.entity.SimpleDataHead;

/* JADX INFO: loaded from: classes3.dex */
public class ced {
    private String f;
    private SendMode j;
    private String b = "";
    private CharacterOperationType i = CharacterOperationType.WRITE;
    private byte[] c = new byte[0];
    private int h = 0;
    private int g = 1;
    private boolean d = true;
    private byte e = SimpleDataHead.INVALID.getDataHead();
    private int k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f604a = 0;

    public SendMode g() {
        return this.j;
    }

    public void a(SendMode sendMode) {
        this.j = sendMode;
    }

    public String i() {
        return this.f;
    }

    public void b(String str) {
        this.f = str;
    }

    public String c() {
        return this.b;
    }

    public void d(String str) {
        this.b = str;
    }

    public byte[] b() {
        return this.c;
    }

    public void c(byte[] bArr) {
        this.c = bArr;
    }

    public CharacterOperationType e() {
        return this.i;
    }

    public int h() {
        return this.h;
    }

    public int f() {
        return this.g;
    }

    public void e(int i) {
        this.g = i;
    }

    public boolean k() {
        return this.d;
    }

    public void b(boolean z) {
        this.d = z;
    }

    public byte a() {
        return this.e;
    }

    public void a(int i) {
        this.k = i;
    }

    public int j() {
        return this.k;
    }

    public void c(int i) {
        this.f604a = i;
    }

    public int d() {
        return this.f604a;
    }

    public static final class e {
        private CharacterOperationType d = CharacterOperationType.WRITE;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f605a = 0;
        private int c = 1;
        private boolean e = true;
        private byte b = SimpleDataHead.INVALID.getDataHead();

        public e d(CharacterOperationType characterOperationType) {
            this.d = characterOperationType;
            return this;
        }

        public e e(boolean z) {
            this.e = z;
            return this;
        }

        public e e(int i) {
            this.f605a = i;
            return this;
        }

        public e a(int i) {
            this.c = i;
            return this;
        }

        public e b(byte b) {
            this.b = b;
            return this;
        }

        public ced a(ced cedVar) {
            if (cedVar == null) {
                return cedVar;
            }
            cedVar.g = this.c;
            cedVar.h = this.f605a;
            cedVar.i = this.d;
            cedVar.d = this.e;
            cedVar.e = this.b;
            return cedVar;
        }
    }
}
