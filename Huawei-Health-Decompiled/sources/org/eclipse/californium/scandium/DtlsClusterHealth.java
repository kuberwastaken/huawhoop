package org.eclipse.californium.scandium;

/* JADX INFO: loaded from: classes11.dex */
public interface DtlsClusterHealth extends DtlsHealth {
    void backwardMessage();

    void badBackwardMessage();

    void badForwardMessage();

    void dropBackwardMessage();

    void dropForwardMessage();

    void forwardMessage();

    void processForwardedMessage();

    void receivingClusterManagementMessage();

    void sendBackwardedMessage();

    void sendingClusterManagementMessage();
}
