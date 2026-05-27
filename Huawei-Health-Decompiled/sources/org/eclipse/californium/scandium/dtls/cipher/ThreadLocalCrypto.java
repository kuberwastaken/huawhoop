package org.eclipse.californium.scandium.dtls.cipher;

import defpackage.ygn;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes8.dex */
public class ThreadLocalCrypto<CryptoFunction> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ThreadLocal<CryptoFunction> f16531a;
    private final GeneralSecurityException b;
    private final Factory<CryptoFunction> c;

    public interface Factory<CryptoFunction> {
        CryptoFunction getInstance() throws GeneralSecurityException;
    }

    static {
        ygn.d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ThreadLocalCrypto(Factory<CryptoFunction> factory) {
        GeneralSecurityException e;
        ThreadLocal<CryptoFunction> threadLocal = null;
        try {
            CryptoFunction factory2 = factory.getInstance();
            if (factory2 != null) {
                try {
                    ThreadLocal<CryptoFunction> threadLocal2 = new ThreadLocal<>();
                    try {
                        threadLocal2.set(factory2);
                    } catch (GeneralSecurityException 
                    /*  JADX ERROR: Method code generation error
                        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getCodeVar()" because "ssaVar" is null
                        */
                    /*
                        this = this;
                        r3.<init>()
                        r0 = 0
                        java.lang.Object r1 = r4.getInstance()     // Catch: java.security.GeneralSecurityException -> L3a
                        if (r1 == 0) goto L19
                        java.lang.ThreadLocal r2 = new java.lang.ThreadLocal     // Catch: java.security.GeneralSecurityException -> L17
                        r2.<init>()     // Catch: java.security.GeneralSecurityException -> L17
                        r2.set(r1)     // Catch: java.security.GeneralSecurityException -> L15
                    L12:
                        r1 = r0
                        r0 = r2
                        goto L3d
                    L15:
                        r0 = move-exception
                        goto L12
                    L17:
                        r1 = move-exception
                        goto L3d
                    L19:
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.security.GeneralSecurityException -> L3a
                        r1.<init>()     // Catch: java.security.GeneralSecurityException -> L3a
                        java.security.GeneralSecurityException r2 = new java.security.GeneralSecurityException     // Catch: java.security.GeneralSecurityException -> L3a
                        java.lang.Class r4 = r4.getClass()     // Catch: java.security.GeneralSecurityException -> L3a
                        java.lang.String r4 = r4.getSimpleName()     // Catch: java.security.GeneralSecurityException -> L3a
                        r1.append(r4)     // Catch: java.security.GeneralSecurityException -> L3a
                        java.lang.String r4 = " not supported!"
                        r1.append(r4)     // Catch: java.security.GeneralSecurityException -> L3a
                        java.lang.String r4 = r1.toString()     // Catch: java.security.GeneralSecurityException -> L3a
                        r2.<init>(r4)     // Catch: java.security.GeneralSecurityException -> L3a
                        r4 = r0
                        r1 = r2
                        goto L3d
                    L3a:
                        r4 = move-exception
                        r1 = r4
                        r4 = r0
                    L3d:
                        r3.f16531a = r0
                        r3.c = r4
                        r3.b = r1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.eclipse.californium.scandium.dtls.cipher.ThreadLocalCrypto.<init>(org.eclipse.californium.scandium.dtls.cipher.ThreadLocalCrypto$Factory):void");
                }

                public CryptoFunction e() {
                    if (!c()) {
                        return null;
                    }
                    CryptoFunction factory = this.f16531a.get();
                    if (factory != null) {
                        return factory;
                    }
                    try {
                        factory = this.c.getInstance();
                        this.f16531a.set(factory);
                        return factory;
                    } catch (GeneralSecurityException unused) {
                        return factory;
                    }
                }

                public CryptoFunction d() throws GeneralSecurityException {
                    GeneralSecurityException generalSecurityException = this.b;
                    if (generalSecurityException != null) {
                        throw generalSecurityException;
                    }
                    return e();
                }

                public final boolean c() {
                    return this.b == null;
                }
            }
