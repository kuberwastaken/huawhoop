package defpackage;

import java.security.PublicKey;
import java.security.cert.CertPath;

/* JADX INFO: loaded from: classes8.dex */
public final class ygw extends yhy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PublicKey f19312a;
    private final CertPath c;
    private final yhx e;

    public ygw(yhh yhhVar, CertPath certPath, Object obj) {
        super(yhhVar, obj);
        this.c = certPath;
        this.f19312a = null;
        this.e = null;
    }

    public ygw(yhh yhhVar, PublicKey publicKey, Object obj) {
        super(yhhVar, obj);
        this.c = null;
        this.f19312a = publicKey;
        this.e = null;
    }

    public ygw(yhh yhhVar, yhx yhxVar, Object obj) {
        super(yhhVar, obj);
        if (yhxVar == null) {
            throw new NullPointerException("exception must not be null!");
        }
        this.c = null;
        this.f19312a = null;
        this.e = yhxVar;
    }

    public CertPath c() {
        return this.c;
    }

    public PublicKey a() {
        return this.f19312a;
    }

    public yhx e() {
        return this.e;
    }
}
