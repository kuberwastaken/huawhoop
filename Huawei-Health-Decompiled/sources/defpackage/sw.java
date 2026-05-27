package defpackage;

import java.io.IOException;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/braintreepayments/api/BraintreeException;", "Ljava/io/IOException;", "message", "", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "BraintreeCore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class sw extends IOException {
    public /* synthetic */ sw(String str, Throwable th, int i, xka xkaVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : th);
    }

    public sw(String str, Throwable th) {
        super(str, th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public sw(String str) {
        this(str, null, 2, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public sw() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }
}
