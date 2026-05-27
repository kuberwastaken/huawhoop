package org.apache.commons.io;

import java.nio.file.Path;
import java.util.function.Function;

/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class FileUtils$$ExternalSyntheticLambda9 implements Function {
    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ((Path) obj).toFile();
    }
}
