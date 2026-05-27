package defpackage;

import com.airbnb.lottie.parser.moshi.LinkedHashTreeMap;

/* JADX INFO: loaded from: classes9.dex */
public class iv extends LinkedHashTreeMap.LinkedTreeMapIterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ LinkedHashTreeMap.e f14311a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public iv(LinkedHashTreeMap.e eVar) {
        super();
        this.f14311a = eVar;
    }

    @Override // java.util.Iterator
    public K next() {
        return nextNode().c;
    }
}
