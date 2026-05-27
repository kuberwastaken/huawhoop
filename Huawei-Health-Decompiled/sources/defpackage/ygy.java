package defpackage;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class ygy extends yhy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<X509Certificate> f19314a;
    private final PrivateKey b;
    private final PublicKey e;

    public ygy(yhh yhhVar, Object obj) {
        super(yhhVar, obj);
        this.b = null;
        this.e = null;
        this.f19314a = null;
    }

    public PrivateKey a() {
        return this.b;
    }

    public PublicKey e() {
        return this.e;
    }

    public List<X509Certificate> d() {
        return this.f19314a;
    }
}
