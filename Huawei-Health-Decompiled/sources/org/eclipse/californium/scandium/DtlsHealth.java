package org.eclipse.californium.scandium;

/* JADX INFO: loaded from: classes8.dex */
public interface DtlsHealth {
    void dump(String str, int i, int i2, int i3);

    void endHandshake(boolean z);

    boolean isEnabled();

    void receivingRecord(boolean z);

    void sendingRecord(boolean z);

    void startHandshake();
}
