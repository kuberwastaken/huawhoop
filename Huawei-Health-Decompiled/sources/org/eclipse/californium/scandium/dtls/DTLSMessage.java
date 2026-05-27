package org.eclipse.californium.scandium.dtls;

/* JADX INFO: loaded from: classes8.dex */
public interface DTLSMessage {
    ContentType getContentType();

    int size();

    byte[] toByteArray();

    String toString(int i);
}
