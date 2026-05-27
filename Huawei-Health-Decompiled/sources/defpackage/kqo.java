package defpackage;

import java.util.function.Consumer;

/* JADX INFO: loaded from: classes5.dex */
public final class kqo {
    public static <T> void c(T t, Consumer<T> consumer) {
        if (t != null) {
            consumer.accept(t);
        }
    }
}
