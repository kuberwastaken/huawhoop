package org.eclipse.californium.elements.auth;

import defpackage.yfd;
import java.security.Principal;

/* JADX INFO: loaded from: classes8.dex */
public interface ExtensiblePrincipal<T extends Principal> extends Principal {
    T amend(yfd yfdVar);

    yfd getExtendedInfo();
}
