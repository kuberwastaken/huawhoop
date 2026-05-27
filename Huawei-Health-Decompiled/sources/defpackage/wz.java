package defpackage;

import java.io.Serializable;
import org.apache.commons.io.FilenameUtils;

/* JADX INFO: loaded from: classes9.dex */
public class wz implements Comparable<wz>, Serializable {
    private static final wz g = new wz(0, 0, 0, null, null, null);
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final int f18985a;
    protected final int b;
    protected final String c;
    protected final String d;
    protected final int e;
    protected final String i;

    public wz(int i, int i2, int i3, String str, String str2, String str3) {
        this.f18985a = i;
        this.e = i2;
        this.b = i3;
        this.i = str;
        this.d = str2 == null ? "" : str2;
        this.c = str3 == null ? "" : str3;
    }

    public static wz b() {
        return g;
    }

    public boolean e() {
        String str = this.i;
        return str != null && str.length() > 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f18985a);
        sb.append(FilenameUtils.EXTENSION_SEPARATOR);
        sb.append(this.e);
        sb.append(FilenameUtils.EXTENSION_SEPARATOR);
        sb.append(this.b);
        if (e()) {
            sb.append('-');
            sb.append(this.i);
        }
        return sb.toString();
    }

    public int hashCode() {
        return this.c.hashCode() ^ (((this.d.hashCode() + this.f18985a) - this.e) + this.b);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        wz wzVar = (wz) obj;
        return wzVar.f18985a == this.f18985a && wzVar.e == this.e && wzVar.b == this.b && wzVar.c.equals(this.c) && wzVar.d.equals(this.d);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(wz wzVar) {
        if (wzVar == this) {
            return 0;
        }
        int iCompareTo = this.d.compareTo(wzVar.d);
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        int iCompareTo2 = this.c.compareTo(wzVar.c);
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        int i = this.f18985a - wzVar.f18985a;
        if (i != 0) {
            return i;
        }
        int i2 = this.e - wzVar.e;
        return i2 == 0 ? this.b - wzVar.b : i2;
    }
}
