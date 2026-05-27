package com.huawei.hms.kit.awareness.barrier;

import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public interface BarrierStatusMap {
    Set<String> getBarrierLabels();

    BarrierStatus getBarrierStatus(String str);
}
