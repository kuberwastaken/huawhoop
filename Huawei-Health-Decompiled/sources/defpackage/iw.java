package defpackage;

import com.airbnb.lottie.parser.moshi.LinkedHashTreeMap;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public class iw extends LinkedHashTreeMap.LinkedTreeMapIterator {
    final /* synthetic */ LinkedHashTreeMap.b d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public iw(LinkedHashTreeMap.b bVar) {
        super(LinkedHashTreeMap.this);
        this.d = bVar;
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Map.Entry<K, V> next() {
        return nextNode();
    }
}
