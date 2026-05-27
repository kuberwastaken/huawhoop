package defpackage;

import java.util.Objects;
import net.lingala.zip4j.headers.HeaderSignature;
import net.lingala.zip4j.model.AbstractFileHeader;

/* JADX INFO: loaded from: classes8.dex */
public class xwz extends AbstractFileHeader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f19181a = 0;
    private byte[] b;
    private String c;
    private int d;
    private byte[] e;
    private int h;
    private long i;

    public xwz() {
        setSignature(HeaderSignature.CENTRAL_DIRECTORY);
    }

    public int b() {
        return this.h;
    }

    public void a(int i) {
        this.h = i;
    }

    public void c(int i) {
        this.f19181a = i;
    }

    public int d() {
        return this.d;
    }

    public void e(int i) {
        this.d = i;
    }

    public void b(byte[] bArr) {
        this.b = bArr;
    }

    public byte[] c() {
        return this.e;
    }

    public void d(byte[] bArr) {
        this.e = bArr;
    }

    public long a() {
        return this.i;
    }

    public void d(long j) {
        this.i = j;
    }

    public String e() {
        return this.c;
    }

    public void a(String str) {
        this.c = str;
    }

    public String toString() {
        return getFileName();
    }

    @Override // net.lingala.zip4j.model.AbstractFileHeader
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && super.equals(obj) && b(this) == b((xwz) obj);
    }

    public int hashCode() {
        return Objects.hash(getFileName(), Long.valueOf(b(this)));
    }

    private long b(xwz xwzVar) {
        if (xwzVar.getZip64ExtendedInfo() != null) {
            return xwzVar.getZip64ExtendedInfo().b();
        }
        return xwzVar.a();
    }
}
