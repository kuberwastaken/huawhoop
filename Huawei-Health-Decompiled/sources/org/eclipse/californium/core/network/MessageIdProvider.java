package org.eclipse.californium.core.network;

import java.net.InetSocketAddress;

/* JADX INFO: loaded from: classes8.dex */
public interface MessageIdProvider {
    int getNextMessageId(InetSocketAddress inetSocketAddress);
}
