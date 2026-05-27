package defpackage;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: loaded from: classes3.dex */
public class crt implements Comparator<hqp>, Serializable {
    private static final long serialVersionUID = -4531604421710697216L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f12010a;

    public crt(boolean z) {
        this.f12010a = z;
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compare(hqp hqpVar, hqp hqpVar2) {
        return this.f12010a ? d(hqpVar2, hqpVar) : d(hqpVar, hqpVar2);
    }

    private int d(hqp hqpVar, hqp hqpVar2) {
        if (hqpVar.n() != hqpVar2.n()) {
            return Integer.compare(hqpVar.n(), hqpVar2.n());
        }
        if (hqpVar.n() == 256) {
            return this.f12010a ? -1 : 1;
        }
        if (hqpVar.n() == 512) {
            return 1;
        }
        return Long.compare(hqpVar2.i(), hqpVar.i());
    }
}
