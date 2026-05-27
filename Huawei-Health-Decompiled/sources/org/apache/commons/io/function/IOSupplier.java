package org.apache.commons.io.function;

import java.io.IOException;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes11.dex */
@FunctionalInterface
public interface IOSupplier<T> {
    T get() throws IOException;

    default Supplier<T> asSupplier() {
        return new Supplier() { // from class: org.apache.commons.io.function.IOSupplier$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return Uncheck.get(this.f$0);
            }
        };
    }
}
