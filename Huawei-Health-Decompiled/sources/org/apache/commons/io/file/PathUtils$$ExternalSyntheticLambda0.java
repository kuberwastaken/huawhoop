package org.apache.commons.io.file;

import java.net.URL;
import org.apache.commons.io.function.IOSupplier;

/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class PathUtils$$ExternalSyntheticLambda0 implements IOSupplier {
    public final /* synthetic */ URL f$0;

    @Override // org.apache.commons.io.function.IOSupplier
    public final Object get() {
        return this.f$0.openStream();
    }

    public /* synthetic */ PathUtils$$ExternalSyntheticLambda0(URL url) {
        this.f$0 = url;
    }
}
