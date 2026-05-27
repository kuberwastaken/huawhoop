package org.eclipse.californium.elements.config;

/* JADX INFO: loaded from: classes8.dex */
public enum CertificateAuthenticationMode {
    NONE(false),
    WANTED(true),
    NEEDED(true);

    private final boolean useCertificateRequest;

    CertificateAuthenticationMode(boolean z) {
        this.useCertificateRequest = z;
    }

    public boolean useCertificateRequest() {
        return this.useCertificateRequest;
    }
}
