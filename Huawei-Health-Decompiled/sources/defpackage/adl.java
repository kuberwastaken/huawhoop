package defpackage;

import com.huawei.operation.utils.Constants;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes9.dex */
public final class adl implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final int f184a;
    protected final Class<?> c;
    protected String d;

    public adl(Class<?> cls) {
        this(cls, null);
    }

    public adl(Class<?> cls, String str) {
        this.c = cls;
        this.f184a = cls.getName().hashCode() + (str == null ? 0 : str.hashCode());
        c(str);
    }

    public Class<?> a() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public void c(String str) {
        if (str == null || str.isEmpty()) {
            str = null;
        }
        this.d = str;
    }

    public boolean b() {
        return this.d != null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        adl adlVar = (adl) obj;
        return this.c == adlVar.c && Objects.equals(this.d, adlVar.d);
    }

    public int hashCode() {
        return this.f184a;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder("[NamedType, class ");
        sb.append(this.c.getName());
        sb.append(", name: ");
        if (this.d == null) {
            str = Constants.NULL;
        } else {
            str = "'" + this.d + "'";
        }
        sb.append(str);
        sb.append("]");
        return sb.toString();
    }
}
