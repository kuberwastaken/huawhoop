package org.eclipse.californium.scandium.dtls;

/* JADX INFO: loaded from: classes8.dex */
public enum ExtendedMasterSecretMode {
    NONE,
    OPTIONAL,
    ENABLED,
    REQUIRED;

    public boolean is(ExtendedMasterSecretMode extendedMasterSecretMode) {
        return ordinal() >= extendedMasterSecretMode.ordinal();
    }
}
