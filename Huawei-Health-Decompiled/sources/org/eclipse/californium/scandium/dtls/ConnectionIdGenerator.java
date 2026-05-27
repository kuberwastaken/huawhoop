package org.eclipse.californium.scandium.dtls;

import defpackage.ygg;
import defpackage.yhh;

/* JADX INFO: loaded from: classes8.dex */
public interface ConnectionIdGenerator {
    yhh createConnectionId();

    yhh read(ygg yggVar);

    boolean useConnectionId();
}
