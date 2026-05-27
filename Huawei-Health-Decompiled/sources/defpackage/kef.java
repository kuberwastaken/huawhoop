package defpackage;

import com.huawei.hihealth.HiHealthData;
import java.util.function.ToLongFunction;

/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class kef implements ToLongFunction {
    @Override // java.util.function.ToLongFunction
    public final long applyAsLong(Object obj) {
        return ((HiHealthData) obj).getStartTime();
    }
}
