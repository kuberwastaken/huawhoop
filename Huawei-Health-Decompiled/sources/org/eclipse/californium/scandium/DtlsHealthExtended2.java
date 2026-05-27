package org.eclipse.californium.scandium;

/* JADX INFO: loaded from: classes8.dex */
public interface DtlsHealthExtended2 {
    void receivingMacError();

    void setPendingHandshakeJobs(int i);

    void setPendingIncomingJobs(int i);

    void setPendingOutgoingJobs(int i);
}
