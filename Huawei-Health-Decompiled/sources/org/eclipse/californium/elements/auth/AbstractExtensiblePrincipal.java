package org.eclipse.californium.elements.auth;

import defpackage.yfd;
import java.security.Principal;

/* JADX INFO: loaded from: classes8.dex */
public abstract class AbstractExtensiblePrincipal<T extends Principal> implements ExtensiblePrincipal<T> {
    private final yfd additionalInfo;

    protected AbstractExtensiblePrincipal() {
        this(null);
    }

    public AbstractExtensiblePrincipal(yfd yfdVar) {
        if (yfdVar == null) {
            this.additionalInfo = yfd.a();
        } else {
            this.additionalInfo = yfdVar;
        }
    }

    @Override // org.eclipse.californium.elements.auth.ExtensiblePrincipal
    public final yfd getExtendedInfo() {
        return this.additionalInfo;
    }
}
