package org.eclipse.californium.elements;

import defpackage.yen;
import java.net.InetSocketAddress;
import java.security.Principal;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public interface EndpointContext {
    Map<yen<?>, Object> entries();

    <T> T get(yen<T> yenVar);

    InetSocketAddress getPeerAddress();

    Principal getPeerIdentity();

    <T> String getString(yen<T> yenVar);

    String getVirtualHost();

    boolean hasCriticalEntries();
}
