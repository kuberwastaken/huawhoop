package defpackage;

import java.util.Objects;
import org.eclipse.californium.elements.auth.AbstractExtensiblePrincipal;

/* JADX INFO: loaded from: classes8.dex */
public final class yfh extends AbstractExtensiblePrincipal<yfh> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f19282a;
    private final String b;
    private final boolean c;
    private final String e;

    public yfh(String str) {
        this(false, null, str, null);
    }

    public yfh(String str, String str2) {
        this(true, str, str2, null);
    }

    private yfh(boolean z, String str, String str2, yfd yfdVar) {
        super(yfdVar);
        if (str2 == null) {
            throw new NullPointerException("Identity must not be null");
        }
        this.c = z;
        if (z) {
            StringBuilder sb = new StringBuilder();
            if (str == null) {
                this.f19282a = null;
            } else if (ygp.a(str)) {
                String lowerCase = str.toLowerCase();
                this.f19282a = lowerCase;
                sb.append(lowerCase);
            } else {
                throw new IllegalArgumentException("virtual host is not a valid hostname");
            }
            sb.append(":");
            sb.append(str2);
            this.b = sb.toString();
        } else {
            if (str != null) {
                throw new IllegalArgumentException("virtual host is not supported, if sni is disabled");
            }
            this.f19282a = null;
            this.b = str2;
        }
        this.e = str2;
    }

    private yfh(boolean z, String str, String str2, String str3, yfd yfdVar) {
        super(yfdVar);
        this.c = z;
        this.f19282a = str;
        this.e = str2;
        this.b = str3;
    }

    @Override // org.eclipse.californium.elements.auth.ExtensiblePrincipal
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public yfh amend(yfd yfdVar) {
        return new yfh(this.c, this.f19282a, this.e, this.b, yfdVar);
    }

    public boolean d() {
        return this.c;
    }

    public String b() {
        return this.f19282a;
    }

    public String a() {
        return this.e;
    }

    @Override // java.security.Principal
    public String getName() {
        return this.b;
    }

    @Override // java.security.Principal
    public String toString() {
        if (this.c) {
            return "PreSharedKey Identity [virtual host: " + this.f19282a + ", identity: " + this.e + "]";
        }
        return "PreSharedKey Identity [identity: " + this.e + "]";
    }

    @Override // java.security.Principal
    public int hashCode() {
        return this.b.hashCode();
    }

    @Override // java.security.Principal
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return Objects.equals(this.b, ((yfh) obj).b);
        }
        return false;
    }
}
