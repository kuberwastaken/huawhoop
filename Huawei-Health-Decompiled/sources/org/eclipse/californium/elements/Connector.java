package org.eclipse.californium.elements;

import defpackage.yev;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetSocketAddress;

/* JADX INFO: loaded from: classes8.dex */
public interface Connector {
    void destroy();

    InetSocketAddress getAddress();

    String getProtocol();

    boolean isRunning();

    void processDatagram(DatagramPacket datagramPacket);

    void send(yev yevVar);

    void setEndpointContextMatcher(EndpointContextMatcher endpointContextMatcher);

    void setRawDataReceiver(RawDataChannel rawDataChannel);

    void start() throws IOException;

    void stop();
}
