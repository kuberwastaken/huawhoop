package com.huawei.syncmgr.menstrual;

import com.huawei.hihealth.HiHealthData;
import defpackage.dst;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public interface MenstrualSyncApi {
    List<HiHealthData> getMenstrualFlow(long j, long j2, long j3);

    boolean syncMenstrualToDevice(List<dst> list);
}
